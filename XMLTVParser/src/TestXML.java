import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import fr.polytech.ybene.prd.xmltv.TimeInterval;
import fr.polytech.ybene.prd.xmltv.UserHandler;

public class TestXML {

	public static void main(String argv[]) {
		
		try {
			// Creating SAX parser
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			// Creating the handler
			UserHandler userHandler = new UserHandler();

			// Parsing XML file
			System.out.println("Processing XML file parsing...");
			long startTime = System.currentTimeMillis();
			saxParser.parse("./resources/tvguide_tnt.xml", userHandler);
			long endTime = System.currentTimeMillis();
			System.out.println("Done !");
			
			// Creating TimeInterval objects
			ArrayList<TimeInterval> timeIntervals = new ArrayList<TimeInterval>();
			timeIntervals = userHandler.getTimeIntervals();
			
			// Printing results
//			for (TimeInterval timeInterval : timeIntervals) {
//				System.out.println(timeInterval.toString());
//			}
			
			// Getting statistics
			Integer size = timeIntervals.size();
			Long time = endTime - startTime;
			
			// Printing statistics
			System.out.println("Parsing of " + size.toString() + " programms in " + time.toString() + " milliseconds.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
