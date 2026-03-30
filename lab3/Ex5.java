package lab3;

public class Ex5 {
    private static int step = 0;
    
    public static void main(String[] args) {
        System.out.println("fib(5) = " + fib(5));
    }
    
    public static int fib(int n) {
        space();
        System.out.println("fib(" + n + ")");
        step++;
        
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fib(n - 2) + fib(n - 1);
        }
        
        step--;
        space();
        System.out.println("return " + result + " for fib(" + n + ")");
        
        return result;
    }
    
    public static void space() {
        for (int i = 0; i < step; i++) {
            System.out.print("  ");
        }
    }
}
