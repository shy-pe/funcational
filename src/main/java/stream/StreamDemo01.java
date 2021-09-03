package stream;

import apple.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo01 {
    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple(250, "green"),
                new Apple(350, "red"),
                new Apple(550, "green"),
                new Apple(150, "red"),
                new Apple(450, "green"),
                new Apple(250, "green"),
                new Apple(550, "red")
        );

        // 목적 :: 300그램 이상인 사과의 갯수 확인
        // 1. 전통적인 데이터 처리 방식을 사용 (컬렉션을 그대로 사용 - for 문)
        int count = 0;
        for (Apple apple : apples) {
            if (apple.getWeight() > 300) {
                count++;
            }
        }
        System.out.println("300그램 이상 사과 : " + count + "개");

        // 2. 자바8의 스트림을 사용한 방식 (Stream, functional-way)
        long count1 = apples.stream()     // Stream<Apple>
                .filter(apple -> apple.getWeight() > 300)
                .count();
        System.out.println("300그램 이상 사과 : " + count1 + "개");
    }
}
