import java.util.Scanner;
import java.time.LocalDate;

public class Example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate now = LocalDate.now();

        System.out.println("Input age: ");
        int age = in.nextInt();

        int birthYear = now.getYear() - age;
        System.out.println("Your year of birth: " + birthYear);
        in.close();
    }
}
