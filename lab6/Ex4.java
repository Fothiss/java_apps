package lab6;

public class Ex4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int threadNumber = i;
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + threadNumber);
            });
            thread.start();
        }
    }
}
