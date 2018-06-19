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
			TrackPoint tp = new TrackPoint(latS, lonS, elevationS, timeS);
			gpsTrack.points.add(tp);
			Node extensionNode = element.getElementsByTagName("extensions").item(0);
			if (extensionNode != null) {
				Element extnEl = (Element) extensionNode;
				String tempS = getTagValue(extnEl, "ns3:atemp");
				if (tempS != null)
					tp.atemp = Double.parseDouble(tempS);
				String cadS = getTagValue(extnEl, "ns3:cad");
				if (cadS != null)
					tp.cadence = Integer.parseInt(cadS);
				String hrS = getTagValue(extnEl, "ns3:hr");
				if (cadS != null)
					tp.heartRate = Integer.parseInt(cadS);
			}

		}


	String trackName = doc.getElementsByTagName("name").item(0).getTextContent();gpsTrack.trackName=trackName;
		gpsTrack.trackName = trackName;
		gpsTrack.setTrackPairs();
	return gpsTrack;
	}

	private static String getTagValue(Element extn, String tag) {
		Node nodeTemp = extn.getElementsByTagName(tag).item(0);
		if (nodeTemp != null) {
			return nodeTemp.getTextContent();
		}
		return null;
	}

	public static void main(String[] arg) {
		GPSTrack myTrack = createTrackFromXML("data/tracks/OrindaCycleTrack.gpx");
		// myTrack.points = myTrack.points.subList(0, 10);
		System.out.println("Track has " + myTrack.points.size() + " points ");
		long timeInSeconds = myTrack.getDuration();
		double avgSpeed = myTrack.getAverageSpeed();
		System.out.println("Old average speed: " + avgSpeed);
		System.out.println("Old non-paused time: " + myTrack.getDuration());
		avgSpeed = myTrack.getAverageSpeedPairs();
		System.out.println("New average speed: " + avgSpeed);
		System.out.println("New non-paused time: " + + myTrack.getTotalTime());
		System.out.println("distance: " + + myTrack.getTotalDistance());
	}
}
