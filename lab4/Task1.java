package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter array size: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0, count = 0;

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] > 0) {
                    sum += arr[i];
                    count++;
                }
            }

            if (count == 0) {
                throw new ArithmeticException("No positive elements");
            }
            
            double average = (double) sum / count;
            System.out.println("Average: " + average);

        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. String or decimal instead of integer.");
        } catch (ArithmeticException e) {
            System.out.println("Error: No positive elements found.");
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}