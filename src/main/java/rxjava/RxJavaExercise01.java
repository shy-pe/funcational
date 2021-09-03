package rxjava;

import io.reactivex.rxjava3.core.Flowable;

import java.util.Arrays;
import java.util.List;

public class RxJavaExercise01 {
    public static void main(String[] args) {
        // 1. 컬렉션으로부터 Flowable을 만든다
        // 2. filtering 글자수가 4글자 이상인 색깔 필터링
        // 3. mapping 대문자로 변경
        // 4. 콘솔에 출력

        List<String> strings = Arrays.asList(
                "blue", "brown", "white", "pink", "red", "purple"
        );

        Flowable.fromIterable(strings)
                .filter(str -> str.length() >= 4)
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }




}
