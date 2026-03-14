package lab2;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, Charset.forName("CP866"));
        System.out.println("Введите текст для шифрования");
        String text = scanner.nextLine();
        System.out.println("Введите ключ");
        int key = scanner.nextInt();
        scanner.nextLine();

        String encrypted = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encrypted);

        while (true){
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String answer = scanner.nextLine();

            if (answer.equals("y")) {
                String decrypted = encrypt(encrypted, -key);
                System.out.println("Текст после обратного преобразования: " + decrypted);
                break;
            }
            else if (answer.equals("n")) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Введите корректный ответ");
            }
        }
        scanner.close();
    }

    public static String encrypt(String text, int key){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            result.append((char)(c + key));
        }

        return result.toString();
    }
}
