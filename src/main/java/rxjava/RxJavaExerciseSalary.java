package rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import stream.majorleague.Salary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RxJavaExerciseSalary {
    public static void main(String[] args) throws IOException {

        // 목적 : 2016년도 LAD 의 최고 연봉자 top 5를 구하기

        // 1. File 객체를 생성 -> Path 객체로 변경
        Path file = Paths.get("C:/funcational/src/main/resources/Salaries.csv");

        // 2. Stream 생성
        Stream<Salary> salaryStream = Files.lines(file)  // Stream<String>
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
                });

        // 3. Stream 을 Flowable 로 변경해서 subscribe
        Flowable.fromStream(salaryStream)
                .filter(salary -> salary.getYear() == 2016)
                .filter(salary -> salary.getTeam().equals("LAD"))
                .sorted((a, b) -> (int)(b.getSalary() - a.getSalary()))
                .take(5)
                .subscribe(System.out::println);
    }
}
