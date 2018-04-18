package org.goldberg.tracker;

import java.time.Instant;
import java.util.List;

public class GPSTrack {
	
	List<TrackPoint> points;
	public String trackName;
	public String trackDecription;
	public long getDuration() {
		TrackPoint first = points.get(0);
		TrackPoint last = points.get(points.size() - 1 );
		return TrackPoint.timeBetweenTrackPoints(first, last);
	}
	public long getDistance() {
		//total distance traveled
		return 0;
	}
	
	public long getAverageSpeed() {
		
		return 0;
	}
	
	

}
