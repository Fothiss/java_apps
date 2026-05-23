package lab7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example3_folder");
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
        String fileName = folder.getAbsolutePath() + File.separator + "example_file.txt";
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Файл уже существует: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }
        
        // Ввод текста из консоли
        System.out.print("Введите текст для записи в файл: ");
        String data = scanner.nextLine();
        
        // Запись данных в файл (символьные потоки)
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
            System.out.println("Данные записаны в файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
        
        // Чтение данных из файла (символьные потоки)
        try (FileReader reader = new FileReader(fileName)) {
            char[] buffer = new char[1024];
            int charRead = reader.read(buffer);
            String readData = new String(buffer, 0, charRead);
            System.out.println("Прочитанные данные: " + readData);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        
        // Удаление файла
        if (file.delete()) {
            System.out.println("Файл удален: " + fileName);
        } else {
            System.out.println("Не удалось удалить файл: " + fileName);
        }
        
        // Удаление папки
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}