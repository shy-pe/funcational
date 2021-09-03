package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeDemo01 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println(datetime);

        LocalDate lastChristmas = LocalDate.of( 2020, 12, 25);
        System.out.println(lastChristmas);

        LocalDate firstDay = lastChristmas.minusDays(100);
        System.out.println(firstDay);

        DayOfWeek dayOfWeek = firstDay.getDayOfWeek();
        System.out.println(dayOfWeek);  // WEDNESDAY
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN)); // 수요일
        System.out.println(dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN)); // 수
        System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN)); // 수

        // 2001.9.11 로부터 300일 후의 2달 전
        LocalDate terrorDay = LocalDate.of(2001, 9, 11);
        System.out.println(terrorDay.plusDays(300).minusMonths(2));

        // 현재시각의 세 시간전의 20분 후
        LocalDateTime curDateTime = LocalDateTime.now();
        System.out.println(curDateTime.minusHours(3).plusMinutes(20));
        //System.out.println(curDateTime.minusHours(3).plusMinutes(20).format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH24:MI:SS")));
    }
}
