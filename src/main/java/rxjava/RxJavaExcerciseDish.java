package rxjava;

import io.reactivex.rxjava3.core.Flowable;
import stream.dish.Dish;

import java.util.Arrays;
import java.util.List;

public class RxJavaExcerciseDish {
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

        // 1. dishes(컬렉션)에서 Flowable 생성
        // 2. 400 칼로리 이하의 음식 필터링
        // 3. 이름만 반환(매핑)
        // 4. 콘솔에 출력

        Flowable.fromIterable(dishes)
                .filter(dish -> dish.getCalories() <= 400)
                .map(dish -> dish.getName())
                .subscribe(System.out::println);
    }
}
