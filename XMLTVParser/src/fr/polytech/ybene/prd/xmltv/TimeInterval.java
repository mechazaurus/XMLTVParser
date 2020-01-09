package fr.polytech.ybene.prd.xmltv;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Yohann BENETREAULT
 * @version 0.1
 *
 */

public class TimeInterval {
	
	// === Attributes ===
	private Calendar startingDate, endingDate;
	private String channel, rawStart, rawStop;
	// ==================

	public TimeInterval(String channel, String start, String stop) {
		this.channel = channel;
		this.rawStart = start;
		this.rawStop = stop;
		formatRawTimes();
	}
	
	// === Getters ===
	public Calendar getStartingDate() {
		return this.startingDate;
	}
	
	public Calendar getEndingDate() {
		return this.endingDate;
	}
	
	public String getChannel() {
		return this.channel;
	}

	public String getStart() {
		return this.rawStart;
	}
	
	public String getStop() {
		return this.rawStop;
	}
	// ===============
	
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Channel :");
		strBuilder.append(this.channel);
		strBuilder.append("\n");
		strBuilder.append("Start :");
		strBuilder.append(this.rawStart);
		strBuilder.append("\n");
		strBuilder.append("Stop :");
		strBuilder.append(this.rawStop);
		strBuilder.append("\n");
		strBuilder.append("\n");
		
		return strBuilder.toString();
	}
	
	
	/**
	 * The time format is : AAAAMMDDHHMMSS +TimeZone
	 * This method convert the string into a Date object
	 */
	private void formatRawTimes() {
		// Creating format
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssZ");
		
		// Creating calendars
		startingDate = Calendar.getInstance();
		endingDate = Calendar.getInstance();

		try {
			// Taking care of the starting date
			Date rawStartingDate = simpleDateFormat.parse(rawStart);
			startingDate.setTime(rawStartingDate);
			// Taking care of the ending date
			Date rawEndingDate = simpleDateFormat.parse(rawStop);
			endingDate.setTime(rawEndingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
