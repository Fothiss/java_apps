package lab3;

import java.util.Scanner;

public class Ex7 {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter array elements:");
        inputArray(arr, 0);
        
        System.out.print("Array elements: ");
        outputArray(arr, 0);
        
        scanner.close();
    }
    
    public static void inputArray(int[] arr, int index) {
        if (index < arr.length) {
            arr[index] = scanner.nextInt();
            inputArray(arr, index + 1);
        }
    }
    
    public static void outputArray(int[] arr, int index) {
        if (index < arr.length) {
            System.out.print(arr[index] + " ");
            outputArray(arr, index + 1);
        }
    }
}
