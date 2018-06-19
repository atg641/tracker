package org.goldberg.tracker;

import java.util.List;

public class TrackPair {
	public TrackPoint first;
	public TrackPoint second;
	public long deltaTime;
	public double deltaDistance;
	
	public TrackPair(TrackPoint f, TrackPoint s) {
	first = f;
	second = s;
	deltaTime = TrackPoint.timeBetweenTrackPoints(f , s);
	deltaDistance = TrackPoint.distanceTo(f, s);
}

	@Override
	public String toString() {
		return "TrackPair [deltaTime=" + deltaTime + ", deltaDistance=" + deltaDistance + ", first=" + first
				+ ", second=" + second + "]";
	}

	

}
