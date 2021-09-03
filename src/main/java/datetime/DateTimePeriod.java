package datetime;

import java.time.LocalDate;
import java.time.Period;

public class DateTimePeriod {
    public static void main(String[] args) {
        LocalDate imf = LocalDate.of(1997, 12, 15);
        LocalDate today = LocalDate.now();

        Period gap = imf.until(today);
        System.out.println(gap.getYears() + "년"
                        + gap.getMonths() + "월"
                        + gap.getDays() + "일"
        );

        Period gap2 = Period.between(imf, today);
        System.out.println(gap2.getYears() + "년"
                + gap2.getMonths() + "월"
                + gap2.getDays() + "일"
        );
    }
}
