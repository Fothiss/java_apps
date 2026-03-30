package lab3;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.print("Binary representation: ");
        toBinary(n);
    }
    
    public static void toBinary(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            toBinary(n / 2);
            System.out.print(n % 2);
        }
    }
}
