package org.goldberg.tracker;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class TrackPointTests {
	
	
	@Test
	public void testSmoothElevation1(){
		GPSTrack gpsTrack = new GPSTrack();
		TrackPoint tp1 = new TrackPoint(10.0);
		TrackPoint tp2 = new TrackPoint(10.0);
		gpsTrack.points = new ArrayList<TrackPoint>();
		gpsTrack.points.add(tp1);
		gpsTrack.points.add(tp2);
		gpsTrack.setSmoothElevation();
		assertTrue(gpsTrack.points.get(0).smoothElevation == 10.0);
		assertTrue(gpsTrack.points.get(1).smoothElevation == 10.0);		
	}
	
	@Test
	public void testSmoothElevation2(){
		GPSTrack gpsTrack = new GPSTrack();
		TrackPoint tp1 = new TrackPoint(10.0);
		TrackPoint tp2 = new TrackPoint(10.0);
		gpsTrack.points = new ArrayList<TrackPoint>();
		gpsTrack.points.add(tp1);
		gpsTrack.points.add(tp2);
		gpsTrack.setSmoothElevation(2, 2);
		assertTrue(gpsTrack.points.get(0).smoothElevation == 10.0);
		assertTrue(gpsTrack.points.get(1).smoothElevation == 10.0);		
	}
	
	@Test
	public void testSmoothElevation3(){
		GPSTrack gpsTrack = new GPSTrack();
		gpsTrack.points = new ArrayList<TrackPoint>();
		for(int i = 0;  i < 20; i++  ) {
			TrackPoint tp1 = new TrackPoint(10.0);
			gpsTrack.points.add(tp1);
		}
		gpsTrack.setSmoothElevation(2, 2);
		assertTrue(gpsTrack.points.get(10).smoothElevation == 10.0);

		
	}
	
	@Test
	public void testSmoothElevation4(){
		GPSTrack gpsTrack = new GPSTrack();
		gpsTrack.points = new ArrayList<TrackPoint>();
		for(int i = 0;  i < 20; i++  ) {
			TrackPoint tp1 = new TrackPoint(10.0);
			gpsTrack.points.add(tp1);
		}
		gpsTrack.setSmoothElevation(2, 2);
		assertTrue(gpsTrack.points.get(10).smoothElevation == 10.0);
		
	}
	
	@Test
	public void testSmoothElevation5(){
		GPSTrack gpsTrack = new GPSTrack();
		gpsTrack.points = new ArrayList<TrackPoint>();
		for(int i = 0;  i < 20; i++  ) {
			TrackPoint tp1 = new TrackPoint(i);
			gpsTrack.points.add(tp1);
		}
		gpsTrack.setSmoothElevation(2, 3);
		assertTrue(gpsTrack.points.get(10).smoothElevation == (9.5 + 11) /  2);
		
	}
	
	// setSmoothElevation  = setSmoothElevation(2, 2)
	// setSMmoothElevation(1, 1) = elevation

}
