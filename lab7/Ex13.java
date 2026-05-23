package lab7;

import java.io.*;
import java.util.Scanner;

public class Ex13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example13_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        }
        
        // Ввод данных объекта из консоли
        System.out.println("Введите данные студента:");
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Возраст: ");
        int age = scanner.nextInt();
        System.out.print("Средний балл: ");
        double gpa = scanner.nextDouble();
        
        Student student = new Student(name, age, gpa);
        
        // Сохранение объекта в файл (сериализация)
        String fileName = folder.getAbsolutePath() + File.separator + "student.ser";
        
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(student);
            System.out.println("\nОбъект сериализован в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Восстановление объекта из файла (десериализация)
        System.out.println("\nВосстановление объекта из файла:");
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            Student restoredStudent = (Student) in.readObject();
            System.out.println("Восстановлен объект: " + restoredStudent);
            
            // Вывод значений полей на экран через геттеры
            System.out.println("\nЗначения полей:");
            System.out.println("Имя: " + restoredStudent.getName());
            System.out.println("Возраст: " + restoredStudent.getAge());
            System.out.println("Средний балл: " + restoredStudent.getGpa());
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        // Удаление файла и папки
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("\nФайл удален: " + fileName);
        }
        if (folder.delete()) {
            System.out.println("Папка удалена: " + folder.getAbsolutePath());
        }
        
        scanner.close();
    }
}

// Класс с полями, реализующий Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private double gpa;
    
    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }
    
    // Геттеры для доступа к приватным полям
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }
    
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
}