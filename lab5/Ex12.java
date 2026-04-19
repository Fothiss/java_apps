package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex12{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.println("Введите размер списка:");
        int size = in.nextInt();
        
        System.out.println("Введите пороговое значение:");
        int threshold = in.nextInt();
        
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("\nИсходный список:");
        for (int i = 0; i < size; i++) {
            integers.add(random.nextInt(100));
            System.out.println(integers.get(i));
        }
        
        List<Integer> integersAfter = filterGreaterThan(integers, threshold);
        
        System.out.println("\nЧисла больше " + threshold + ":");
        for (Integer i : integersAfter) {
            System.out.println(i);
        }
        
        in.close();
    }
    
    public static List<Integer> filterGreaterThan(List<Integer> list, int threshold) {
        return list.stream()
                .filter(x -> x > threshold)
                .collect(Collectors.toList());
    }
}