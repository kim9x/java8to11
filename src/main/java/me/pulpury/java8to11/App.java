package me.pulpury.java8to11;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		
		// Instant는 기계용, 시간을 재거나 비교할 때 주로 사용.
		Instant instant = Instant.now();
		System.out.println(instant);	// 기준 시 UTC: GMT
		System.out.println(instant.atZone(ZoneId.of("UTC")));
		
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
		System.out.println(zonedDateTime);
		
		
		// LocalDateTime은 사람용,
		// Local을 보면 알겠지만 현재 속해있는 zone을 참고해줌.
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime birthDay = LocalDateTime.of(1996, Month.JANUARY, 5, 0, 0, 0);
		
		ZonedDateTime nowInLA = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(nowInLA);
		
		Instant nowInstant = Instant.now();
		ZonedDateTime zonedDateTime2 = nowInstant.atZone(ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDateTime2);
		
		// Instant와 ZonedDateTime의 변환이 자유롭다.
		Instant zonedToInstant = zonedDateTime.toInstant();
		
		LocalDate today = LocalDate.now();
		LocalDate thisYearBirthday = LocalDate.of(2021, Month.JANUARY, 5);
		
		Period period = Period.between(today, thisYearBirthday);
		System.out.println(period.getDays());
		
		Period until = today.until(thisYearBirthday);
		System.out.println(until.get(ChronoUnit.DAYS));
		
		Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS);
		Duration between = Duration.between(nowInstant, plus);
		System.out.println(between.getSeconds());
		
		// 머신용 시간을 비교할 땐 Duration를 사용
		// 휴먼용 시간을 비교할 땐 Period를 사용
		
		
		System.out.println(now);
		DateTimeFormatter MMddYYYY = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(now.format(MMddYYYY));
		
		LocalDate parse = LocalDate.parse("07/15/1982", MMddYYYY);
		System.out.println(parse);
		
		// Date와 Instant 사이의 형 변환이 자유롭다.
		Date date = new Date();
		Instant instant2 = date.toInstant();
		Date newDate = Date.from(instant2);
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		LocalDateTime localDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDateTime();
		
		ZonedDateTime zonedDateTime3 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
		
		GregorianCalendar from = GregorianCalendar.from(zonedDateTime3);
		
		ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
		
		LocalDateTime now2 = localDateTime.now();
		LocalDateTime plus2 = now2.plus(10, ChronoUnit.DAYS);
		
	}
}
