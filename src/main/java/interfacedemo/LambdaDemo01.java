package interfacedemo;

public class LambdaDemo01 {
    public static void main(String[] args) {
        LambdaDemo01 demo = new LambdaDemo01();

        System.out.println(demo.calcNumber(new FFIImpl(), 2, 3));

        // Anonymous inner class
        System.out.println(demo.calcNumber(new FirstFunctionalInterface() {
            @Override
            public int calc(int a, int b) {
                return a * a - 3 + b;
            }
        }, 2, 3));
    }
    
    public int calcNumber(FirstFunctionalInterface ffi, int a, int b) {
        return ffi.calc(a, b);
    }

    static class FFIImpl implements FirstFunctionalInterface {
        @Override
        public int calc(int a, int b) {
            return a * 2 + b;
        }
    }
}

// 추상메소드가 하나만 있는 메소드 = FunctionalInterface
// FunctionalInterface 는 Lambda식으로 변경할 수 있다
@FunctionalInterface
interface FirstFunctionalInterface {
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