package interfacedemo;

public class InterfaceDemo01 {

    private final int c = 5;
    public static void main(String[] args) {
        System.out.println("Hello world");

        MyInterface.calc(1, 2);
    }

    public int calcTowNumbers(int a, int b) {
        System.out.println("hello");
        return a + b;
    }
}

interface MyInterface {
    //public static final int MY_INT = 5;
    int MY_INT = 5;
    double MY_DOUBLE = 3.14;

    //public abstract int add(int a, int b);
    int add(int a, int b);
    int sub(int a, int b);

    // interface 에서 구현메소드는 default 로 선언하면 가능해졌다.
    // Companion class 를 굳이 필요없게 됨.
    // 예전에는 static 메소드를 포함한 Companion class 를 별도로 두었음  (Collection - Collections, Path - Paths 관계)
    default int multiply(int a, int b) {
        return a * b;
    }

    // 추상메소드를 추가로 만들면 상속받은 클래스들에서 구현된 동일 메소드에서 오류가 난다..?
    //int divide(int a, int b);
    default int divide(int a, int b) {
        return a / b;
    }

    // interface 의 static method도 가능
    static int calc(int a, int b) {
        return a+b;
    }

    // JAVA9에서는 private nethod 도 가능
}

class MyClass implements MyInterface {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return MyInterface.super.multiply(a, b);
    }

    @Override
    public int divide(int a, int b) {
        return MyInterface.super.divide(a, b);
    }
}
