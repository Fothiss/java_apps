package timus;
import java.util.Scanner;

public class Timus1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] queries = new long[n];
        for (int i = 0; i < n; i++) {
            queries[i] = sc.nextLong();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            System.out.print(getDigit(queries[i]) + " ");
        }
    }

    private static int getDigit(long pos) {
        long k = 1;
        while (pos > k) {
            pos -= k;
            k++;
        }
        if (pos == 1) return 1;
        else return 0;
    }
}