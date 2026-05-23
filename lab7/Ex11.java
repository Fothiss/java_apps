package lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example11_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        }
        
        // Запрос имени файла у пользователя
        System.out.print("Введите название файла: ");
        String fileName = scanner.nextLine();
        
        String fullPath = folder.getAbsolutePath() + File.separator + fileName;
        File file = new File(fullPath);
        
        // Создание файла
        if (file.createNewFile()) {
            System.out.println("Файл создан: " + fullPath);
        } else {
            System.out.println("Файл уже существует: " + fullPath);
        }
        
        // Запись содержимого в файл
        System.out.println("Введите строки для записи в файл (для завершения введите 'end'):");
        try (FileWriter writer = new FileWriter(fullPath)) {
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equals("end")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }
        }
        System.out.println("Данные записаны в файл");
        
        // Запрос слова для поиска
        System.out.print("Введите слово для поиска: ");
        String searchWord = scanner.nextLine();
        
        // Поиск строк, содержащих слово
        System.out.println("\nСтроки, содержащие слово \"" + searchWord + "\":");
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fullPath))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchWord)) {
                    System.out.println("Строка " + lineNumber + ": " + line);
                    found = true;
                }
                lineNumber++;
            }
        }
        
        if (!found) {
            System.out.println("Слово \"" + searchWord + "\" не найдено в файле.");
        }
        
        // Удаление файла и папки
        if (file.delete()) {
            System.out.println("\nФайл удален: " + fullPath);
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}