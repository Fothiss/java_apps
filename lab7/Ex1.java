package lab7;
import java.io.File;
import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) {
        // Создаем папку
        File folder = new File("lab7/example1_folder");
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }

        // Создаем файл внутри папки
        File file = new File(folder.getAbsolutePath() + File.separator + "example_file.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл создан: " + file.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать файл: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла: " + e.getMessage());
        }

        // Удаляем файл и папку
        if (file.delete()) {
            System.out.println("Файл удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
        }

        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        } else {
            System.out.println("Не удалось удалить папку: " + folder.getAbsolutePath());
        }
    }
}
