package org.goldberg.tracker;

import java.time.Instant;
import java.util.ArrayList;

public class TrackPoint {

	public double latitude;
	public double longitude;
	public double elevation; // units?
	public double smoothElevation;
	public double distanceFromTrackStart;
	public Instant time;
	
	
	public Integer cadence;
	public Integer heartRate;
	public Double atemp;
	
	

	@Override
	public String toString() {
		return "TrackPoint [latitude=" + latitude + ", longitude=" + longitude + ", elevation=" + elevation
				+ ", smoothElevation=" + smoothElevation + ", time=" + time + ", cadence=" + cadence + ", heartRate="
				+ heartRate + ", atemp=" + atemp + "]";
	}

	final static double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;

	public TrackPoint(String lat, String lon, String ele, String t) {
		latitude = Double.parseDouble(lat);
		longitude = Double.parseDouble(lon);
		elevation = Double.parseDouble(ele);
		time = Instant.parse(t);
		
	}
	
	//just for testing
	public TrackPoint(double elevat) {
		elevation = elevat;
	}

	public static double distanceTo(TrackPoint trackPoint, TrackPoint anotherTrackPoint) {

		double lat1 = Math.toRadians(anotherTrackPoint.latitude);
		double lon1 = Math.toRadians(anotherTrackPoint.longitude);
		double lat2 = Math.toRadians(trackPoint.latitude);
		double lon2 = Math.toRadians(trackPoint.longitude);
		// great circle distance in radians, using law of cosines formula
		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

		// each degree on a great circle of Earth is 60 nautical miles
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;
	}
	
	public long timeBetweenTrackPoints(TrackPoint anotherTrackPoint) {
		return timeBetweenTrackPoints(this, anotherTrackPoint);
	}
	
	public static long timeBetweenTrackPoints(TrackPoint first, TrackPoint second) {
		Instant startTime = first.time;
		Instant endTime = second.time;		
		long differenceInSeconds = endTime.getEpochSecond()-startTime.getEpochSecond();
		int  nanoStart = startTime.getNano();
		//can we get this elapsed time accurate to milli-seconds? 
		return differenceInSeconds;
	}

	}
	



