package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter column number: ");
            int col = sc.nextInt();
            
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][col]);
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. String instead of number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Column with this number does not exist.");
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
