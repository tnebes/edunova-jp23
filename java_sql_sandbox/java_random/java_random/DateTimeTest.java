package java_random;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class DateTimeTest {

	public static void main(String[] args) {
		
		Instant myInstant = Instant.now();
		System.out.println(myInstant);
		// YYYY-MM-DD HH:MM:SS.ffffff
		DateTimeFormatter myDateTimeFormatter = DateTimeFormatter.ofPattern("uuuu-mm-dd hh:mm:hhss").withLocale(Locale.GERMAN).withZone(ZoneId.of("UTC"));
		System.out.println(myDateTimeFormatter.format(myInstant).toString());
	}
	
}
