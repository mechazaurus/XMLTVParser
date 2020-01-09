package fr.polytech.ybene.prd.xmltv;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Yohann BENETREAULT
 * @version 0.1
 *
 */

public class UserHandler extends DefaultHandler {

	// === Attributes ===
	private boolean getItBoy = false;
	private ArrayList<TimeInterval> timeIntervals = new ArrayList<TimeInterval>();
	// ==================

	
	// === Getters ===
	public ArrayList<TimeInterval> getTimeIntervals() {
		return this.timeIntervals;
	}
	// ===============

	
	// === Handler methods ===
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("PROGRAMME")) {
			// Getting values
			String start = attributes.getValue("start");
			String stop = attributes.getValue("stop");
			String channel = attributes.getValue("channel");
			// Creating TimeInterval object
			TimeInterval timeInerval = new TimeInterval(channel, start, stop);
			// Adding the object to the list
			timeIntervals.add(timeInerval);
			// We got it
			getItBoy = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// Nothing to be done
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		if (getItBoy) {
			// Ready to process the next one
			getItBoy = false;
		}
	}
	// =======================
}
