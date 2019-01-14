package com.java8.sample.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.Locale;
/**
 * Reference URL: https://www.concretepage.com/java/java-8/java-datetimeformatter
 * @author 739126
 *
 */
public class DateTimeFormatterSample {

	public static void main(String[] args) {
		new DateTimeFormatterSample().dateTimeFormatter();
		new DateTimeFormatterSample().formatLocalDate();
		new DateTimeFormatterSample().formatLocalDateTime();
		new DateTimeFormatterSample().formatLocalTime();
		new DateTimeFormatterSample().temporalAccessor();
	}

	public void dateTimeFormatter(){
		System.out.println(TemporalQueries.zoneId().queryFrom(LocalDateTime.now()));
		LocalDate localDate = LocalDate.now();

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String formattedDate1 = formatter1.format(localDate);
		System.out.println(formattedDate1); 

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MMM dd, yyyy", Locale.CANADA);
		String formattedDate2 = formatter2.format(localDate);
		System.out.println(formattedDate2); 

		DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String formattedDate3 = formatter3.format(localDate);
		System.out.println(formattedDate3); 

		LocalDateTime localDateTime = LocalDateTime.now();

		DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String formattedDate4 = formatter4.format(localDateTime);
		System.out.println(formattedDate4); 

		DateTimeFormatter formatter5 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT);
		String formattedDate5 = formatter5.format(localDateTime);
		System.out.println(formattedDate5); 

		LocalTime localTime = LocalTime.now();

		DateTimeFormatter formatter6 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		String formattedDate6 = formatter6.format(localTime);
		System.out.println(formattedDate6); 
	}
	
	public void formatLocalDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		LocalDate ld = LocalDate.now();
		System.out.println(dtf.format(ld));

		dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd(E)");
		ld = LocalDate.now();
		System.out.println(dtf.format(ld));

		dtf = DateTimeFormatter.ofPattern("MMM dd, YYYY");
		ld = LocalDate.now();
		System.out.println(dtf.format(ld));
	}
	
	public void formatLocalDateTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm:ss");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(dtf.format(ldt)); 

		dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd(E) hh:mm:ss a");
		ldt = LocalDateTime.now();
		System.out.println(dtf.format(ldt));

		dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
		ldt = LocalDateTime.now();
		System.out.println(dtf.format(ldt));
	}
	
	public void formatLocalTime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
		LocalTime lt = LocalTime.now();
		System.out.println(dtf.format(lt));

		dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
		lt = LocalTime.now();
		System.out.println(dtf.format(lt));

		dtf = DateTimeFormatter.ofPattern("HH:mm");
		lt = LocalTime.now();
		System.out.println(dtf.format(lt));
	}
	
	public void temporalAccessor(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss");
		TemporalAccessor ta = formatter.parse("18-Dec-2017 02:46:41");
		System.out.println(ta.get(ChronoField.YEAR));
		System.out.println(ta.get(ChronoField.HOUR_OF_AMPM));
	}
}
