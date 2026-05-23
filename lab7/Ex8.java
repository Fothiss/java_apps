package lab7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example8_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }
        
        // Создание файла
        String fileName = folder.getAbsolutePath() + File.separator + "input.txt";
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("Файл создан: " + fileName);
        } else {
            System.out.println("Файл уже существует: " + fileName);
        }
        
        // Ввод строк из консоли для записи в файл
        System.out.println("Введите строки для записи в файл (для завершения введите 'end'):");
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equals("end")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }
        }
        System.out.println("Данные записаны в файл: " + fileName);
        
        // Подсчет количества строк в файле
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }
            System.out.println("Количество строк в файле: " + lineCount);
        }
        
        // Удаление файла и папки
        if (file.delete()) {
            System.out.println("Файл удален: " + fileName);
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}