package stream.dish;

import java.util.*;
import java.util.stream.Collectors;

public class DishAnalyzer {
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
        // 목적 : 칼로리가 400이하인 요리의 이름을 칼로리순으로 정렬하고, 상위 3개의 이름을 출력

        // 2. 함수형 프로그래밍 with stream - pipeline
        // 1) 소스를 stream 으로 변경 -> 2) 중간 처리 -> 3) 최종 처리(집계, collect 등으로 반환)
        List<String> collect = dishes.stream()
                .filter(dish -> dish.getCalories() <= 400)              // Stream<Apple>
                //.sorted((a, b) -> a.getCalories() - b.getCalories())  // Method Reference 로 변경
                .sorted(Comparator.comparingInt(Dish::getCalories))     // Stream<Apple>
                //.map(dish -> dish.getName())                          // Method Reference 로 변경
                .map(Dish::getName)                                     // Stream<String>
                .collect(Collectors.toList());

        System.out.println(collect.subList(0, 3));


        // 1. 클래식 자바스타일, 컬렉션을 활용 (코드 실패..)
        /*
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() <= 400) {
                lowCalorieDishes.add(dish);
            }
        }
        Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        List<String> lowCalorieDishesName = new ArrayList<>();
        for (Dish dish : lowCalorieDishes) {
            lowCalorieDishesName.add(dish.getName());
        }
        List<String> lowCalorieLimit3DishesName = lowCalorieDishesName.subList(0, 3);
        System.out.println(lowCalorieLimit3DishesName);
        */
    }
}
