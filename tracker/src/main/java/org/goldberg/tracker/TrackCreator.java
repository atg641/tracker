package org.goldberg.tracker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
import org.xml.sax.SAXException;

public class TrackCreator {

	public static GPSTrack createTrackFromXML(String filename) {
		Document doc = null;
		try {
			File fXmlFile = new File(filename);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("trkpt");
		GPSTrack gpsTrack  = new GPSTrack();
		gpsTrack.points = new ArrayList<TrackPoint>();
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			// A geographic point with optional elevation and time. Available for use by
			// other schemas.

			Element element = (Element) node;
			String latS = element.getAttribute("lat");
			String lonS = element.getAttribute("lon");
			String elevationS = element.getElementsByTagName("ele").item(0).getTextContent();
			String timeS = element.getElementsByTagName("time").item(0).getTextContent();
			gpsTrack.points.add(new TrackPoint(latS, lonS, elevationS, timeS));
		}
		String trackName  = doc.getElementsByTagName("name").item(0).getTextContent();
		gpsTrack.trackName = trackName;
		
		
		return gpsTrack;
	}

	public static void main(String [] arg) {
		GPSTrack myTrack = createTrackFromXML("data/tracks/Track102.xml");
		System.out.println("Track has " + myTrack.points.size() + " points " );
		long timeInSeconds = myTrack.getDuration();
	}
}
