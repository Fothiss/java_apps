package lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        System.out.println("Введите предложение:");
        String text = in.nextLine();

        List<String> strings = List.of(text.split(" "));

        System.out.println("\nСписок слов после сплитования:");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringsAfter = filterCapitalizedStrings(strings);

        System.out.println("\nСлова, начинающиеся с большой буквы:");
        for (String e : stringsAfter) {
            System.out.println(e);
        }

        in.close();
    }

    public static List<String> filterCapitalizedStrings(List<String> list) {
        return list.stream()
                .filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}