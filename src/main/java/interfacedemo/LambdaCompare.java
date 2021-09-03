package interfacedemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaCompare {
    // psvm 하면 main 함수 자동 완성
    public static void main(String[] args) {
        List<String> favoriteColors =
                Arrays.asList("red", "pink", "blue", "brown", "purple");

        // 1. impl class version 호출
        favoriteColors.sort(new MyComparator());
        System.out.println(favoriteColors);

        // 2. anonymous inner class version
        favoriteColors.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(favoriteColors);

        // 3. Lambda version
        favoriteColors.sort((a, b) -> b.length() - a.length());
        System.out.println(favoriteColors);
    }
}

// 함수형 인터페이스인 Comparator 로 구현
// 1. impl class version
class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}

