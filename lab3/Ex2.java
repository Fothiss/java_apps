package lab3;

public class Ex2 {
    public static void m(int x) {
        if (x >= 0 && x < 20) {
            m(2 * x + 1);
            System.out.println("x=" + x);
        }
    }

    public static void main(String[] args) {
        m(1);
    }
    
}
