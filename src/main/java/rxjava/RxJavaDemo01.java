package rxjava;

import io.reactivex.rxjava3.core.Flowable;

public class RxJavaDemo01 {
    public static void main(String[] args) {
        // 1. 데이터 공급자 확보, ex) Stream<T>
        // 2. 데이터 연산
        // 3. 데이터 사용
        Flowable.just("hello", "world", "hi", "lee")
                .filter(str -> str.length() >= 3)
                .subscribe(str -> System.out.println(str));
    }
}
