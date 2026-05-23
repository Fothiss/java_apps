package lab7;

import java.io.*;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example6_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }
        
        // Создание файлов
        String inputFileName = folder.getAbsolutePath() + File.separator + "input.txt";
        String outputFileName = folder.getAbsolutePath() + File.separator + "output.txt";
        
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        
        try {
            if (inputFile.createNewFile()) {
                System.out.println("Входной файл создан: " + inputFileName);
            }
            if (outputFile.createNewFile()) {
                System.out.println("Выходной файл создан: " + outputFileName);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файлов: " + e.getMessage());
        }
        
        // Ввод текста из консоли
        System.out.print("Введите текст для записи во входной файл: ");
        String data = scanner.nextLine();
        
        // Запись данных во входной файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFileName))) {
            writer.write(data);
            System.out.println("Данные записаны во входной файл: " + inputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
        
        // Чтение из входного файла и запись в выходной
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
             PrintWriter printWriter = new PrintWriter(outputFileName, "UTF-8")) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printWriter.println(line);
            }
            System.out.println("Данные скопированы в файл: " + outputFileName);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
        
        // Чтение и вывод содержимого выходного файла
        System.out.println("Содержимое выходного файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        
        // Удаление файлов и папки
        if (inputFile.delete()) {
            System.out.println("Входной файл удален: " + inputFileName);
        }
        if (outputFile.delete()) {
            System.out.println("Выходной файл удален: " + outputFileName);
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}