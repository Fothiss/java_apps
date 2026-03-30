package lab3;

public class Ex1 {
    public static void main(String[] args) {
        printSequence(5); // вызов для примера
    }
    
    public static void printSequence(int x) {
        if (x < 0 || x >= 20) return;
        System.out.print(x + " ");
        printSequence(2 * x + 1);
    }
}

