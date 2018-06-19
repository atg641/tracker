package org.goldberg.tracker;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class GPSTrack {
	final static double NUMBER_OF_SECONDS_PER_HOUR = 3600.0D;
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
			if(currentTP.deltaTime < 10) {
				sum += currentTP.deltaTime;
			}
	}
		return sum;
	}

	public double getDistance() {
		// TrackPoint prev = null;
		// double sum = 0;
		// for(TrackPoint currentTP : points) {
		// if(prev != null ) { // all but first first tp
		// sum += TrackPoint.distanceTo(prev, currentTP);
		// }
		// prev = currentTP;
		// }
		// //total distance traveled
		// return sum;

		double sum = 0;
		for (int i = 1; i < points.size(); i++) {
			TrackPoint currentTP = points.get(i);
			TrackPoint prevTP = points.get(i - 1);
			sum += TrackPoint.distanceTo(prevTP, currentTP);
		}
		return sum;

		// for(int i = 0; i < points.size() - 1; i++) {
		// TrackPoint currentTP = points.get(i);
		// TrackPoint nextTP = points.get(i+1);
		// sum += TrackPoint.distanceTo(nextTP, currentTP);
		// }

	}

	/**
	 * @return average speed in mph
	 */
	public double getAverageSpeed() {
		// fill in this method and pay attention to units
		double distance = getDistance();
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
