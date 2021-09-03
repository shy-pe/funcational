package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrimitive {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "lee", "seunghoon");
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

        int[] intArray = {1, 2, 3, 4, 5};

        Stream<String> stringStream = strings.stream();
        Stream<Integer> integerStream = ints.stream();
        IntStream intStream = Arrays.stream(intArray);

    }
}