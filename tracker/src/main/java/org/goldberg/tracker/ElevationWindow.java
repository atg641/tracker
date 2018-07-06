package org.goldberg.tracker;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class ElevationWindow extends JFrame {
	static final int WINDOW_SIZE = 400;

	public ElevationWindow(GPSTrack track) {

		setSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel cp = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				
				Point2D topYAxis = new Point2D.Double(100.0, 0.0);
				Point2D origin = new Point2D.Double(100.0, 400.0);
				Line2D yAxis  = new Line2D.Double(topYAxis, origin);
				g2.draw(yAxis);
				Point2D  endXAxis = new Point2D.Double(500.0, 400.0);
				Line2D xAxis  = new Line2D.Double(endXAxis, origin);
				g2.draw(xAxis);
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
