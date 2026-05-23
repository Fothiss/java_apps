package lab7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example10_folder");
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
        
        // Запись содержимого в файл (чтобы файл был не пустой)
        System.out.print("Введите текст для записи в файл: ");
        String content = scanner.nextLine();
        try (FileWriter writer = new FileWriter(fullPath)) {
            writer.write(content);
            System.out.println("Текст записан в файл");
        }
        
        // Вывод размера файла в байтах
        long fileSize = file.length();
        System.out.println("Размер файла \"" + fileName + "\": " + fileSize + " байт");
        
        // Удаление файла и папки
        if (file.delete()) {
            System.out.println("Файл удален: " + fullPath);
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}