package lab3;

import java.util.HashMap;
import java.util.Map;

public class Ex9 {
    public static void main(String[] args) {
        // 1. Заполнить HashMap 10 объектами <Integer, String>
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");

        // 2. Найти строки у которых ключ > 5
        System.out.println("Строки с ключом > 5:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
            }
        }

        // 3. Если ключ = 0, вывести строки через запятую
        System.out.print("\nСтроки с ключом = 0: ");
        if (map.containsKey(0)) {
            System.out.println(map.get(0));
        } else {
            System.out.println("нет");
        }

        // 4. Перемножить все ключи, где длина строки > 5
        long product = 1;
        boolean found = false;
        
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                found = true;
                System.out.println("Ключ " + entry.getKey() + " (строка: \"" + entry.getValue() + "\", длина: " + entry.getValue().length() + ")");
            }
        }
        
        if (found) {
            System.out.println("\nПроизведение ключей (длина строки > 5): " + product);
        } else {
            System.out.println("\nНет строк с длиной > 5");
        }
    }
}
