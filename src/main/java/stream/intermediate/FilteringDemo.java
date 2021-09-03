package stream.intermediate;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class FilteringDemo {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 1000);
        IntStream intStream1 = IntStream.of(1,2,3,4,5,6,6,7,7);

        // intStream1 에서 중복을 제거한다.
        intStream1
                .distinct()
                .forEach(System.out::println);

        // intStream 에서 짝수만 필터링, 50건만큼만, 앞 5개를 스킵
        intStream
                .filter(i -> i % 2 == 0)
                .limit(50)
                .skip(5)
                .forEach(System.out::println);

    }
}
