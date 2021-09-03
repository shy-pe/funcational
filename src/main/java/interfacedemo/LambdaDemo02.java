package interfacedemo;

public class LambdaDemo02 {
    public static void main(String[] args) {
        LambdaDemo02 demo = new LambdaDemo02();

        int c;
        // Lambda 식에서는 함수명이 불필요
        c = demo.calcNumber(
                (int a, int b) -> {
                    return a * a + b;
                }, 5, 7
        );
        System.out.println(c);

        // 좀 더 간결하게 바디를 한줄로
        c = demo.calcNumber((int a, int b) -> { return a * a + b; }, 5, 7 );
        System.out.println(c);

        // 바디의 리턴을 생략이 가능하다, 이때 괄호(brace)는 제거해야한다. (Closure 지원)
        c = demo.calcNumber((int a, int b) -> a * a + b, 5, 7 );
        System.out.println(c);

        // 같은 타잎일 경우에는 type 도 생략이 가능하다
        c = demo.calcNumber((a, b) -> a * a + b, 5, 7 );
        System.out.println(c);

        // 함수를 바로 선언해서도 대입이 가능하다
        FirstFunctionalInterface02 ffi02 = (a, b) -> a * a + b;
        c = demo.calcNumber(ffi02, 5, 7);
        System.out.println(c);
    }

    public int calcNumber(FirstFunctionalInterface02 ffi, int a, int b) {
        return ffi.calc(a, b);
    }
}

// 추상메소드가 하나만 있는 메소드 = FunctionalInterface
@FunctionalInterface
interface FirstFunctionalInterface02 {
    int calc( int a, int b);

    // Default Method 는 상관이 없다
    default int add(int a, int b) {
        return a + b;
    }

    // Static Method 도 상관이 없다
    static int sub(int a, int b) {
        return a - b;
    }
}