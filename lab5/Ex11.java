package lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex11 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.println("Введите предложение:");
        String text = in.nextLine();
        
        System.out.println("Введите минимальную длину строки:");
        int minLength = in.nextInt();
        
        List<String> strings = List.of(text.split(" "));
        
        System.out.println("\nИсходный список слов:");
        for (String e : strings) {
            System.out.println(e);
        }
        
        List<String> stringsAfter = filterByLength(strings, minLength);
        
        System.out.println("\nСлова длиной больше " + minLength + " символов:");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
        
        in.close();
    }
    
    public static List<String> filterByLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}