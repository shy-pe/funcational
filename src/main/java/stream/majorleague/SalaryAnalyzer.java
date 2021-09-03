package stream.majorleague;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SalaryAnalyzer {
    public static void main(String[] args) throws IOException {

        // 핵심 - salary.csv -> Stream<Salary>

        // 1. File 객체를 생성 -> Path 객체로 변경
        Path file = Paths.get("C:/funcational/src/main/resources/Salaries.csv");

        //yearID,teamID,lgID,playerID,salary
        //1985,ATL,NL,barkele01,870000

        Files.lines(file)  // Stream<String>
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
                .limit(100)
                .forEach(System.out::println);
    }
}
