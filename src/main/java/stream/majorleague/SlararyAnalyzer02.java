package stream.majorleague;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SlararyAnalyzer02 {
    public static void main(String[] args) throws IOException {
        // 핵심 - salary.csv -> Stream<Salary>

        // 1. File 객체를 생성 -> Path 객체로 변경
        Path file = Paths.get("C:/funcational/src/main/resources/Salaries.csv");

        //yearID,teamID,lgID,playerID,salary
        //1985,ATL,NL,barkele01,870000

        // 2. 2016년 LA다저스의 평균연봉을 출력
        double lad = Files.lines(file)  // Stream<String>
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
                .filter(salary -> salary.getYear() == 2016)
                .filter(salary -> salary.getTeam().equals("LAD"))
                .mapToLong(Salary::getSalary)
                .average()
                .orElse(0);

        System.out.println(lad);
    }
}
