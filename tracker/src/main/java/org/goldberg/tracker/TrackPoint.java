package org.goldberg.tracker;

import java.time.Instant;

public class TrackPoint {

	public double latitude;
	public double longitude;
	public double elevation; // units?
	public Instant time;

	public TrackPoint(String lat, String lon, String ele, String t) {
		latitude = Double.parseDouble(lat);
		longitude = Double.parseDouble(lon);
		elevation = Double.parseDouble(ele);
		time = Instant.parse(t);
	}

	public double distanceTo(TrackPoint anotherTrackPoint) {

		double STATUTE_MILES_PER_NAUTICAL_MILE = 1.15077945;
		double lat1 = Math.toRadians(anotherTrackPoint.latitude);
		double lon1 = Math.toRadians(anotherTrackPoint.longitude);
		double lat2 = Math.toRadians(latitude);
		double lon2 = Math.toRadians(longitude);

		// great circle distance in radians, using law of cosines formula
		double angle = Math
				.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));

		// each degree on a great circle of Earth is 60 nautical miles
		double nauticalMiles = 60 * Math.toDegrees(angle);
		double statuteMiles = STATUTE_MILES_PER_NAUTICAL_MILE * nauticalMiles;
		return statuteMiles;

	}

}
