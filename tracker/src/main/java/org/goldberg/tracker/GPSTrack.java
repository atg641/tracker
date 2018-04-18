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
		Instant startTime = first.time;
		Instant endTime = last.time;		
		long differenceInSeconds = endTime.getEpochSecond()-startTime.getEpochSecond();
		return differenceInSeconds;
		
	}
	
	

}
