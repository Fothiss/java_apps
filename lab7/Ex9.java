package lab7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example9_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }
        
        // Создание входного и выходного файлов
        String inputFileName = folder.getAbsolutePath() + File.separator + "input.txt";
        String outputFileName = folder.getAbsolutePath() + File.separator + "output.txt";
        
        File inputFile = new File(inputFileName);
        File outputFile = new File(outputFileName);
        
        if (inputFile.createNewFile()) {
            System.out.println("Входной файл создан: " + inputFileName);
        }
        if (outputFile.createNewFile()) {
            System.out.println("Выходной файл создан: " + outputFileName);
        }
        
        // Ввод текста из консоли для записи во входной файл
        System.out.print("Введите текст для записи во входной файл: ");
        String data = scanner.nextLine();
        
        try (FileWriter writer = new FileWriter(inputFileName)) {
            writer.write(data);
            System.out.println("Данные записаны во входной файл: " + inputFileName);
        }
        
        // Копирование содержимого из input.txt в output.txt
        try (FileReader reader = new FileReader(inputFileName);
             FileWriter writer = new FileWriter(outputFileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            System.out.println("Файл скопирован успешно!");
        }
        
        // Чтение и вывод содержимого выходного файла
        System.out.println("Содержимое выходного файла:");
        try (FileReader reader = new FileReader(outputFileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
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
        }
        
        scanner.close();
    }
}