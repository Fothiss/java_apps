package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Ex10 {
        // Метод с использованием ArrayList
    public static int josephusArrayList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size(); // каждый второй
            list.remove(index);
        }
        return list.get(0);
    }
    
    // Метод с использованием LinkedList
    public static int josephusLinkedList(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            for (int i = 0; i < 2; i++) { // пропускаем первого, удаляем второго
                if (!it.hasNext()) {
                    it = list.iterator();
                }
                it.next();
            }
            it.remove();
        }
        return list.get(0);
    }
    
    // Оптимизированная версия с LinkedList через индекс (аналогично ArrayList)
    public static int josephusLinkedListIndex(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        int index = 0;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
    
    public static void main(String[] args) {
        int n = 40; // количество человек
        
        // Тестирование ArrayList
        long start = System.nanoTime();
        int resultArrayList = josephusArrayList(n);
        long end = System.nanoTime();
        System.out.println("ArrayList (" + n + " человек): " + resultArrayList);
        System.out.println("Время: " + (end - start) / 1_000_000.0 + " мс");
        
        // Тестирование LinkedList (через индекс)
        start = System.nanoTime();
        int resultLinkedList = josephusLinkedListIndex(n);
        end = System.nanoTime();
        System.out.println("\nLinkedList (через индекс): " + resultLinkedList);
        System.out.println("Время: " + (end - start) / 1_000_000.0 + " мс");
        
        // Для небольших n можно показать процесс
        System.out.println("\n--- Пример для n=7 (процесс) ---");
        simulateProcess(7);
    }
    
    public static void simulateProcess(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        System.out.println("Начало: " + list);
        int index = 0;
        int step = 1;
        while (list.size() > 1) {
            index = (index + 1) % list.size();
            System.out.println("Шаг " + step + ": удаляем " + list.get(index));
            list.remove(index);
            System.out.println("Остались: " + list);
            step++;
        }
        System.out.println("Победитель: " + list.get(0));
    }
}
