package lab7;

import java.io.*;
import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Создание папки
        File folder = new File("lab7/example7_folder");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Папка создана: " + folder.getAbsolutePath());
            } else {
                System.out.println("Не удалось создать папку: " + folder.getAbsolutePath());
            }
        } else {
            System.out.println("Папка уже существует: " + folder.getAbsolutePath());
        }
        
        // Ввод данных из консоли
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        
        Person person = new Person(name, age);
        
        // Сериализация
        String fileName = folder.getAbsolutePath() + File.separator + "person.ser";
        
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(person);
            System.out.println("Объект сериализован в файл: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Десериализация
        System.out.println("\nДесериализация:");
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            Person deserializedPerson = (Person) in.readObject();
            System.out.println("Прочитан объект: " + deserializedPerson);
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

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}