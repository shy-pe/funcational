package stream.majorleague;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class SalaryAnalyzerGrouping {
    public static void main(String[] args) throws IOException {
        // 팀별로 그룹핑, 2015년도와 2016년도 데이터만 사용

        Path file = Paths.get("C:/funcational/src/main/resources/Salaries.csv");

        Map<String, Long> collect = Files.lines(file)  // Stream<String>
                .skip(1)    // Stream<Salary>
                .map(line -> {
                    String[] splitted = line.split(",");
                    return new Salary(
                            Integer.parseInt(splitted[0]),
                            splitted[1],
                            splitted[2],
                            splitted[3],
                            Long.parseLong(splitted[4])
                    );
                })
                .filter(salary -> salary.getYear() == 2015 || salary.getYear() == 2016)
                .collect(groupingBy(Salary::getTeam,
                        summingLong(Salary::getSalary)));

        System.out.println("summingLong -----------------------");
        System.out.println(collect);

        Map<String, DoubleSummaryStatistics> collect1 = Files.lines(file)  // Stream<String>
                .skip(1)    // Stream<Salary>
                .map(line -> {
                    String[] splitted = line.split(",");
                    return new Salary(
                            Integer.parseInt(splitted[0]),
                            splitted[1],
                            splitted[2],
                            splitted[3],
                            Long.parseLong(splitted[4])
                    );
                })
                .filter(salary -> salary.getYear() == 2015 || salary.getYear() == 2016)
                .collect(groupingBy(Salary::getTeam,
                        summarizingDouble(Salary::getSalary)));

        System.out.println("summarizingDouble -----------------------");
        System.out.println(collect1);

        System.out.println("summarizingDouble-TEX -----------------------");
        System.out.println(collect1.get("TEX").getAverage());



    }
}
