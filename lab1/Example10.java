import java.util.Scanner;
import java.time.LocalDate;

public class Example10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate now = LocalDate.now();

        System.out.println("Input year of birth: ");
        int birthYear = in.nextInt();

        int age = now.getYear() - birthYear;
        System.out.println("Your age: " + age);
        in.close();
    }
}
