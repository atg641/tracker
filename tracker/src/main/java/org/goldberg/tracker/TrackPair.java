package org.goldberg.tracker;

import java.util.List;

public class TrackPair {
	public TrackPoint first;
	public TrackPoint second;
	public long deltaTime;
	public double deltaDistance; //in miles
	public double deltaElevation;  //in meters
	public double deltaSmoothElevation;  //in meters
	public double gradiant; 
	public double METERS_IN_MILE = 1609.34;
	
	
	
	public TrackPair(TrackPoint f, TrackPoint s) {
	first = f;
	second = s;
	deltaTime = TrackPoint.timeBetweenTrackPoints(f , s);
	deltaDistance = TrackPoint.distanceTo(f, s);
	deltaElevation = s.elevation - f.elevation;
	deltaSmoothElevation = s.smoothElevation - f.smoothElevation;
	double deltaDistanceInMeters = deltaDistance * METERS_IN_MILE;
	gradiant = (deltaElevation / deltaDistanceInMeters) * 100.0;
	
}

	

	@Override
	public String toString() {
		return "TrackPair [deltaTime=" + deltaTime + ", deltaDistance=" + deltaDistance + ", first=" + first
				+ ", second=" + second + "]";
	}

	

}
