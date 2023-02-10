package _21javaVersions._8version;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeExample1 {
	public static void main(String[] args) {
		m1();
	}

	private static void m1() {

		OffsetDateTime currectUTC = OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime();
		String currentStr = currectUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T"
				+ currectUTC.format(DateTimeFormatter.ofPattern("hh:mm:ss.SSS"));
		System.out.println(currentStr);

		ZoneId zoneId=ZoneId.of("America/New_York");
		currectUTC = OffsetDateTime.now(zoneId);// .atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime();
		currentStr = currectUTC.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "T"
				+ currectUTC.format(DateTimeFormatter.ofPattern("hh:mm:ss.SSS"));
		System.out.println(currentStr);
	}

}
