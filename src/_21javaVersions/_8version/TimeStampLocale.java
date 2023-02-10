package _21javaVersions._8version;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeStampLocale {
	static DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma z");
	static DateTimeFormatter etFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mma 'ET'");

	static ZoneId istZoneId = ZoneId.of("Asia/Kolkata");
	static ZoneId etZoneId = ZoneId.of("America/New_York");

	public static void main(String[] args) throws Exception {
		// beforeJava8();
		// afterJava8();
		afterJava8_2();
		

	}

	private static void afterJava8_2() {
		LocalDateTime currentDateTime = LocalDateTime.now(ZoneId.of("America/New_York"));

		// ZonedDateTime currentISTime = currentDateTime.atZone(istZoneId); //India Time
		// ZonedDateTime currentETime = currentISTime.withZoneSameInstant(etZoneId);
		// //ET Time

		// 2023-02-03T11:14:57.021969700Z
		OffsetDateTime offsetDateTime = OffsetDateTime.now(ZoneId.of("America/New_York"));
		//System.out.println(offsetDateTime);
	//	OffsetDateTime parse = OffsetDateTime.parse( OffsetDateTime.now().format( DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss")));
		//System.out.println(parse);
		
		
		//DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("d-MMM-yyyy hh:mm:ss.SSSa");
		//String formattedDate = OffsetDateTime.now(ZoneId.of("America/New_York")).format(ofPattern);
       // System.out.println(formattedDate);
        //OffsetDateTime parse = OffsetDateTime.parse(formattedDate,ofPattern);
        
		String datum = "1988-03-08 00:00:00".replace(" ", "T");
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ss").withZone(ZoneId.of("America/New_York"));
	    ZonedDateTime datetime = ZonedDateTime.parse(datum, formatter);

	    //datetime.toOffsetDateTime();
		
		System.out.println();
        
        //OffsetDateTime.of(currentDateTime, e);

        //System.out.println(OffsetDateTime.parse(""));
       // DateTimeFormatter dtf =DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
       
	}

	private static void beforeJava8() throws Exception {
		String strDate = "June 2, 2021";
		SimpleDateFormat etDf = new SimpleDateFormat("MMMM d, yyyy");
		etDf.setTimeZone(TimeZone.getTimeZone("America/New_York"));

		// Date currentDate = new Date();
		// Calendar currentTime = Calendar.getInstance();

		Date parseDate = etDf.parse(strDate);
		System.out.println(parseDate);
		// In ET Time
		System.out.println(etDf.format(parseDate.getTime()));
		// System.out.println(etDf.format(currentTime.getTimeInMillis()));
		java.sql.Timestamp sql = new java.sql.Timestamp(parseDate.getTime());
		System.out.println(sql);
		java.sql.Timestamp sql2 = new java.sql.Timestamp(parseDate.getDate());
		System.out.println(sql2);
	}

	private static void afterJava8() {
		String strDate = "May 11, 2021";
		LocalDateTime currentDateTime = LocalDateTime.of(2021, 06, 11, 0, 0, 0);

		ZonedDateTime currentISTime = currentDateTime.atZone(istZoneId); // India Time
		ZonedDateTime currentETime = currentISTime.withZoneSameInstant(etZoneId); // ET Time

		System.out.println(globalFormat.format(currentISTime));
		System.out.println(etFormat.format(currentETime));
	}

}
