package org.goldberg.tracker;

public class GarminTrackPoint extends TrackPoint {
	public GarminTrackPoint(String lat, String lon, String ele, String t) {
		super(lat, lon, ele, t);
		// TODO Auto-generated constructor stub
	}

	int cadence;
	double speed;
	int heartRate;


	void foo(){
		latitude = 5;
	}
	

	double currentSpeed() {
		return speed;
	}

	public double distanceTo(TrackPoint anotherTrackPoint) {
		return 0;
	}
	
		
	
}
