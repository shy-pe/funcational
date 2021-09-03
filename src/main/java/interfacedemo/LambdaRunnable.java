package interfacedemo;

public class LambdaRunnable {
    public static void main(String[] args) {

        // 1. 기존방식 스레드 -------------------------------
        // 기존에는 Thread 수행시 Runnable을 구현해야 한다. Runnable = 인터페이스
        System.out.println("1.메인스레드 시작");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1.별도 스레드 동작..");
            }
        }).start();
        System.out.println("1.메인스레드 종료");

        //
        // 2. 람다식 스레드 -------------------------------
        //
        // Runnable 은 Functional Interface 이므로 Lambda 식으로 변환 가능
        System.out.println("2.메인스레드 시작");
        new Thread(() -> System.out.println("2.별도 스레드 동작.."))
                .start();
        System.out.println("2.메인스레드 종료");

    }
}
