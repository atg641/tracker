package org.goldberg.tracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import shape.Circle;



public class ElevationWindow extends JFrame {
	static final int WINDOW_SIZE = 500;
	static final int WINDOW_OFFSET = 200;


	public ElevationWindow(final GPSTrack track) {

		setSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel cp = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				
				Point2D topYAxis = new Point2D.Double(WINDOW_OFFSET, 0.0);
				Point2D origin = new Point2D.Double(WINDOW_OFFSET, WINDOW_SIZE);
				Line2D yAxis  = new Line2D.Double(topYAxis, origin);
				g2.draw(yAxis);
				Point2D  endXAxis = new Point2D.Double(WINDOW_OFFSET + WINDOW_SIZE, WINDOW_SIZE);
				Line2D xAxis  = new Line2D.Double(endXAxis, origin);
				g2.draw(xAxis);
				String maxElevation = Integer.toString((int) track.maxSmoothedElevation);
				g.drawString(maxElevation, WINDOW_OFFSET - 60, 20);
				String minElevation = Integer.toString((int) track.minSmoothedElevation);
				g.drawString(minElevation, WINDOW_OFFSET - 60, WINDOW_SIZE);
				String totalDistance = Integer.toString((int) track.trackTotalDistance);
				g.drawString(totalDistance, WINDOW_OFFSET + WINDOW_SIZE - 25, WINDOW_SIZE + 25);
				int elevationChange = (int) (track.maxSmoothedElevation - track.minSmoothedElevation);
				for(TrackPoint tp :track.points) {
					Double x= 0.0;  
					Double y = 0.0;
					x = WINDOW_OFFSET + (tp.distanceFromTrackStart/track.trackTotalDistance) * WINDOW_SIZE;
					y = WINDOW_SIZE - (tp.smoothElevation - track.minSmoothedElevation) / elevationChange * WINDOW_SIZE;
					Point2D p = new Point2D.Double(x, y);
					Ellipse2D.Double dot =
							  new Ellipse2D.Double(x, y, 3, 3);
					g2.draw(dot);	
				}
				g2.setColor(Color.red);
				
				for(TrackPoint tp :track.points) {
					Double x= 0.0;  
					Double y = 0.0;
					x = WINDOW_OFFSET + (tp.distanceFromTrackStart/track.trackTotalDistance) * WINDOW_SIZE;
					y = WINDOW_SIZE - (tp.elevation - track.minSmoothedElevation) / elevationChange * WINDOW_SIZE;
					Point2D p = new Point2D.Double(x, y);
					
					Ellipse2D.Double dot =
							  new Ellipse2D.Double(x, y, 3, 3);
					g2.draw(dot);	
				}
				
				
			}

		};
		//getContentPane().add(contentPane);
		setContentPane(cp);
		setTitle("Elevation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);

	}

}
