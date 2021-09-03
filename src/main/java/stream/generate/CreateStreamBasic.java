package stream.generate;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreateStreamBasic {
    public static void main(String[] args) {
        // 1. 컬렉션에서 생성
        List<String> stringList = Arrays.asList("hello", "world", "lee", "seunghoon");
        Stream<String> stream = stringList.stream();

        // 중간연산과 최종연산
        stream
                .filter(str -> str.length() >= 5)
                .forEach(System.out::println);

        // 2. 배열에서 생성 (int, double 등은 프리미티브 타입)
        String[] stringArray = {"hello", "world", "lee", "kim", "park"};
        int[] intArray = {1, 2, 3, 4, 5, 6};
        double[] doubleArray = {1.0, 2.0, 3.1, 4.5};

        Stream<String> stringStream = Stream.of(stringArray);
        IntStream intStream = IntStream.of(intArray);
        DoubleStream doubleStream = DoubleStream.of(doubleArray);

        stringStream
                .filter(str -> str.length() == 3)
                .forEach(System.out::println);

        // 3. 특정 범위로 스트림 생성
        IntStream range = IntStream.range(1, 10);
        range.forEach(System.out::println);

        OptionalDouble average =
                LongStream
                        .rangeClosed(1_000_000_000, 10_000_000_000L)
                        .average();
        double v = average.orElse(0);
        System.out.println(v);
    }
}
