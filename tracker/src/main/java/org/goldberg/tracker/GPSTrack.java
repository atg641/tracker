package org.goldberg.tracker;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GPSTrack {
	final static double NUMBER_OF_SECONDS_PER_HOUR = 3600.0D;
	private static final long TIME_BETWEEN_TRACKS_VIEWED_AS_PAUSE = 23;
	List<TrackPoint> points;
	List<TrackPair> pairs;
	public String trackName;
	public String trackDecription;

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
	public void setTrackPairs() {
		pairs = new ArrayList<TrackPair>(points.size() - 1);

		for (int i = 1; i < points.size(); i++) {
			TrackPoint currentTP = points.get(i);
			TrackPoint prevTP = points.get(i - 1);
			TrackPair pair = new TrackPair(prevTP, currentTP);
			pairs.add(pair);
		}
	}

	public void setSmoothElevation() {
		
		for (int i = 1; i < points.size() - 1; i++) {
			double avgElevation = 0;
			TrackPoint currentTP = points.get(i);
			TrackPoint nextTP = points.get(i + 1);
			TrackPoint prevTP = points.get(i - 1);
			avgElevation = (currentTP.elevation + nextTP.elevation + prevTP.elevation) / 3;	
			currentTP.smoothElevation = avgElevation;
		}
		points.get(0).smoothElevation = points.get(0).elevation;
		points.get(points.size()-1).smoothElevation = points.get(points.size()-1).elevation;
		
	}
	
	public void setSmoothElevation(int pointsBefore, int pointsAfter) {
		for (int i = 4; i < points.size() - 4; i++) {
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
		}	
	}
	
	public double getTotalDistance() {
	
		double sum = 0;
		for (TrackPair currentTP : pairs) {
			sum += currentTP.deltaDistance;
		}
		return sum;
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
			System.out.println("graadiant: " + currentTP.gradiant);
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
