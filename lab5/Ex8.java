package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex8 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите размер списка:");
        int size = in.nextInt();

        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\nСписок до:");
        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(50));
            System.out.println(integers.get(i));
        }

        List<Integer> integersAfter = squareList(integers);

        System.out.println("\nСписок после возведения в квадрат:");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }

        in.close();
    }

    private static List<Integer> squareList(List<Integer> list) {
        return list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }
}