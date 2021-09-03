package stream.terminal;

import stream.dish.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateDemo {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("beef", false, 800, "MEAT"),
                new Dish("pork", false, 700, "MEAT"),
                new Dish("chicken", false, 450, "MEAT"),
                new Dish("french fires", true, 530, "OTHER"),
                new Dish("rice", true, 300, "OTHER"),
                new Dish("spaghetti", true, 400, "NOODLE"),
                new Dish("apple", true, 300, "FRUIT"),
                new Dish("melon", true, 320, "FRUIT"),
                new Dish("salmon", true, 420, "FISH"),
                new Dish("prawn", true, 410, "FISH")
        );

        // 1. 전체 요리의 갯수
        long count = dishes.stream()
                .count();
        System.out.println("전체 요리 갯수 : " + count);

        // 2. 칼로리가 300 이상인 Fish 요리 갯수
        count = dishes.stream()
                .filter(dish -> dish.getCalories() >= 300)
                .filter(dish -> dish.getType().equals("FISH"))
                .count();
        System.out.println("300 이상 칼로리의 FISH 갯수 : " + count);

        // 3. vegeterian 용 요리의 평균 칼로리 구하기
        OptionalDouble average = dishes.stream()
                .filter(dish -> dish.isVegetarian())
                .mapToInt(dish -> dish.getCalories())        // Stream<Integer> -> IntStream
                .average();
        double result = average.orElse(0);
        //System.out.println(result);
        System.out.println("vegeterian용 요리의 평균 칼로리 : " + result);

        // 4. 과일과 기타 요리중에 가장 칼로리가 높은 음식의 이름을 출력하세요
        List<Dish> collect = dishes.stream()
                .filter(dish -> dish.getType().equals("FRUIT") || dish.getType().equals("OTHER"))
                .sorted((a, b) -> b.getCalories() - a.getCalories())
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("과일과 기타 요리중에 가장 칼로리가 높은 음식의 이름 : " + collect.get(0).getName());

        // 4-1. 과일과 기타 요리중 가장 높은 칼로리
        OptionalInt maxCalories = dishes.stream()
                .filter(dish -> dish.getType().equals("FRUIT") || dish.getType().equals("OTHER"))
                .mapToInt(dish -> dish.getCalories())
                .max();
        System.out.println("과일과 기타 요리중 가장 높은 칼로리 : " + maxCalories.orElse(0));

        // 5. match 관련 - 칼로리가 700 이상인 요리가 있는지 여부 (anyMatch 사용, 유사 allMatch, nonMatch)
        boolean isOverCalories = dishes.stream()
                .anyMatch(dish -> dish.getCalories() >= 700);
        System.out.println("칼로리가 700 이상인 요리가 있는지 여부 : " + isOverCalories);

        // 6. reduce 사용하여 칼로리의 합계를 구한다.
        // - 채식주의자용 요리의 칼로리 합
        Optional<Integer> optionalInteger = dishes.stream()
                .filter(dish -> dish.isVegetarian())
                .map(dish -> dish.getCalories())    // Stream<Integer>
                //.reduce((a, b) -> a + b);
                .reduce(Integer::sum);
        System.out.println("채식주의자용 요리의 칼로리 합 : " + optionalInteger.orElse(0));

        int resultSum = dishes.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("채식주의자용 요리의 칼로리 int 합 : " + resultSum);
        
    }
}
