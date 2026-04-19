package lab5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in, "cp866");
        
        System.out.println("Введите предложение:");
        String text = in.nextLine();
        
        System.out.println("Введите подстроку для поиска:");
        String substring = in.nextLine();
        
        List<String> strings = List.of(text.split(" "));
        
        System.out.println("\nИсходный список слов:");
        for (String e : strings) {
            System.out.println(e);
        }
        
        List<String> stringsAfter = filterBySubstring(strings, substring);
        
        System.out.println("\nСлова, содержащие подстроку \"" + substring + "\":");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
        
        in.close();
    }
    
    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}