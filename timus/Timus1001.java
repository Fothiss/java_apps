package timus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Timus1001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> numbers = new ArrayList<>();
        while (sc.hasNextLong()) {
            numbers.add(sc.nextLong());
        }
        sc.close();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            double sqrt = Math.sqrt(numbers.get(i));
            System.out.printf("%.4f%n", sqrt);
        }
    }
}