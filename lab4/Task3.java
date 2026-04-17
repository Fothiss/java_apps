package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int n = sc.nextInt();
            byte[] arr = new byte[n];
            int sum = 0;
            
            System.out.println("Enter byte values (-128 to 127):");
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();  // читаем как int
                if (input < Byte.MIN_VALUE || input > Byte.MAX_VALUE) {
                    throw new NumberFormatException("Out of byte range");
                }
                arr[i] = (byte) input;
                sum += arr[i];
                
                if (sum > Byte.MAX_VALUE || sum < Byte.MIN_VALUE) {
                    throw new ArithmeticException("Sum overflow");
                }
            }
            
            System.out.println("Sum: " + (byte) sum);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. String instead of number.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Value out of byte range.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Sum out of byte range.");
        } finally {
            System.out.println("Program finished.");
            sc.close();
        }
    }
}
