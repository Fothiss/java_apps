import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number: ");
        int n = in.nextInt();

        int prev = n - 1;
        int next = n + 1;
        int sum = prev + n + next;
        int square = sum * sum;

        System.out.println(prev);
        System.out.println(n);
        System.out.println(next);
        System.out.println(square);
        in.close();
    }
}
