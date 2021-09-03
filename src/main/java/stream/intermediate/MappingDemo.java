package stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingDemo {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "ab", "abc", "abcd", "abcde");

        Stream<Integer> integers = strings.stream()
                .map(str -> str.length());
        //IntStream 으로 해야 성능이 향상 - 프리미티브 타입
        IntStream ints = strings.stream()
                .mapToInt(str -> str.length());

        IntStream intStream = IntStream.rangeClosed(1, 20);
        intStream
                //.boxed()          // Stream<Integer> // Integer 변환필요시 boxed 사용 (연산 성능 저하)
                //.peek(System.out::println)           // 중간 중간 로그 사용 위해 사용
                .map(i -> i * 2)
                .limit(10)
                //.peek(System.out::println)
                .forEach(System.out::println);


    }
}
