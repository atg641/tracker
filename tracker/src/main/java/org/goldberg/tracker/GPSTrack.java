package org.goldberg.tracker;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GPSTrack {
	final static double NUMBER_OF_SECONDS_PER_HOUR = 3600.0D;
	private static final long TIME_BETWEEN_TRACKS_VIEWED_AS_PAUSE = 23;
	List<TrackPoint> points;
	List<TrackPair> pairs;
	double totalAscent = 0;
	double totalDescent = 0;
	double totalSmoothAscent = 0;
	double totalSmoothDescent = 0;
	public String trackName;


	public String trackDecription;
	public double minSmoothedElevation  = Double.MAX_VALUE;
	public double maxSmoothedElevation  = Double.MIN_VALUE;
	public double trackTotalDistance;

	public long getDuration() {
		TrackPoint first = points.get(0);
		TrackPoint last = points.get(points.size() - 1);
		return TrackPoint.timeBetweenTrackPoints(first, last);
	}

	/**
	 * computes the total distance in miles traveled along the track
	 * 
	 * @return
	 */
	public void computeDerivedData() {
		setSmoothElevation(8,8);
		setTrackPairs();
	}
	
	private void setTrackPairs() {
		pairs = new ArrayList<TrackPair>(points.size() - 1);
		double distanceSoFar = 0;
		points.get(0).distanceFromTrackStart = 0.0;
		for (int i = 1; i < points.size(); i++) {
			TrackPoint currentTP = points.get(i);
			TrackPoint prevTP = points.get(i - 1);
			TrackPair pair = new TrackPair(prevTP, currentTP);
			distanceSoFar += pair.deltaDistance;
			if (pair.deltaElevation > 0) {
				totalAscent += pair.deltaElevation;
						}
			if (pair.deltaElevation < 0) {
				totalDescent += pair.deltaElevation;
						}
			if (pair.deltaSmoothElevation > 0) {
				totalSmoothAscent += pair.deltaSmoothElevation;
						}
			if (pair.deltaSmoothElevation < 0) {
				totalSmoothDescent += pair.deltaSmoothElevation;
						}
			currentTP.distanceFromTrackStart = distanceSoFar;
			pairs.add(pair);
		}
		
		trackTotalDistance = distanceSoFar;
	}

//	private void setSmoothElevation() {
//		
//		for (int i = 1; i < points.size() - 1; i++) {
//			double avgElevation = 0;
//			TrackPoint currentTP = points.get(i);
//			TrackPoint nextTP = points.get(i + 1);
//			TrackPoint prevTP = points.get(i - 1);
//			avgElevation = (currentTP.elevation + nextTP.elevation + prevTP.elevation) / 3;	
//			currentTP.smoothElevation = avgElevation;
//			setMaxMinSmoothedElevation(currentTP);
//		}
//		points.get(0).smoothElevation = points.get(0).elevation;
//		setMaxMinSmoothedElevation(points.get(0));
//		points.get(points.size()-1).smoothElevation = points.get(points.size()-1).elevation;
//		setMaxMinSmoothedElevation(points.get(points.size()-1));
//
//	}
	
	public void setSmoothElevation(int pointsBefore, int pointsAfter) {
		for (int i = pointsBefore; i < points.size() - pointsAfter; i++) {
			TrackPoint currentTP = points.get(i);
			double pointsBeforeAverage = 0;
			double pointsBeforeSum = 0;
			double pointsAfterAverage = 0;
			double pointsAfterSum = 0;
			for(int k = i; k > i - pointsBefore; k--) {
				TrackPoint TPBefore = points.get(k);
				pointsBeforeSum = pointsBeforeSum + TPBefore.elevation;
			}
			pointsBeforeAverage = pointsBeforeSum / pointsBefore;
			for(int a = i; a < i + pointsAfter; a++) {
				TrackPoint TPAfter = points.get(a);
				pointsAfterSum = pointsAfterSum + TPAfter.elevation;
			}
			pointsAfterAverage = pointsAfterSum / pointsAfter;
			currentTP.smoothElevation = (pointsBeforeAverage + pointsAfterAverage)/2;
			setMaxMinSmoothedElevation(currentTP);

		}	
		for (int i = 0 ; i < pointsBefore; i++) {
			TrackPoint currentTP = points.get(i);
			currentTP.smoothElevation = currentTP.elevation;
		}
		for (int i = points.size() - 1 ; i > points.size() - pointsAfter; i--) {
			TrackPoint currentTP = points.get(i);
			currentTP.smoothElevation = currentTP.elevation;
		}
	}
	
	private void  setMaxMinSmoothedElevation(TrackPoint tp) {
		if(tp.smoothElevation  > maxSmoothedElevation)
			maxSmoothedElevation = tp.smoothElevation;
		if(tp.smoothElevation  < minSmoothedElevation)
			minSmoothedElevation = tp.smoothElevation;
	}
	
	public double getTotalDistance() {
		return trackTotalDistance;
	}
	
	public long getTotalTime() {
		long sum = 0;
		for(TrackPair currentTP : pairs) {
			if(currentTP.deltaTime < TIME_BETWEEN_TRACKS_VIEWED_AS_PAUSE) {
				sum += currentTP.deltaTime;
			}
			else {
				System.out.println("Ignored time at for track pair:" + currentTP);
			}
	}
		return sum;
	}
	
	public void printElevation() {
		for(TrackPair currentTP: pairs) {
			System.out.println("ele: " + currentTP.deltaElevation);
			System.out.println("gradiant: " + currentTP.gradiant);
			System.out.println("time: " + currentTP.deltaTime);
		}
		for(TrackPoint currentTP: points) {
			System.out.println("ele: " + currentTP.elevation);
			System.out.println("Smooth Elevation: " + currentTP.smoothElevation);
			System.out.println("time: " + currentTP.time);
		}
	}
	
	/**
	 * @return average speed in mph
	 */
	public double getAverageSpeed() {
		// fill in this method and pay attention to units
		double distance = getTotalDistance();
		double time = getDuration() / NUMBER_OF_SECONDS_PER_HOUR;
		double result = distance / time;
		return result;
	}

	public double getAverageSpeedPairs() {
		// fill in this method and pay attention to units
		double distance = getTotalDistance();
		double time = getTotalTime() / NUMBER_OF_SECONDS_PER_HOUR;
		double result = distance / time;
		return result;
	}

	

}
