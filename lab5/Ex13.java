package lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex13 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.println("Введите предложение (слова могут содержать цифры и символы):");
        String text = in.nextLine();
        
        List<String> strings = List.of(text.split(" "));
        
        System.out.println("\nИсходный список слов:");
        for (String e : strings) {
            System.out.println(e);
        }
        
        List<String> stringsAfter = filterOnlyLetters(strings);
        
        System.out.println("\nСлова, содержащие только буквы:");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
        
        in.close();
    }
    
    public static List<String> filterOnlyLetters(List<String> list) {
        return list.stream()
                .filter(s -> s.matches("[a-zA-Zа-яА-Я]+"))
                .collect(Collectors.toList());
    }
}