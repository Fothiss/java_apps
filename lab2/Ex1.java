package lab2;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.print("Min value: " + min + "; индексы: ");

        for (int i = 0; i < array.length; i++){
            if (array[i] == min){
                System.out.print(i);
            }
        }
    }
}
