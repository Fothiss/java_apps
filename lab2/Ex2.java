package lab2;

public class Ex2 {
    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        int[][] array = new int[rows][cols];
        int start_value = 1;

        boolean leftRigth = true;

        for (int i = 0; i < rows; i++){
            if (leftRigth) {
                for (int j = 0; j < cols; j++){
                    array[i][j] = start_value++;
                    System.out.println("array" + "[" + i + "]" + "[" + j + "] = " +array[i][j]);
                }
            }
            else {
                for (int j = cols - 1; j >= 0; j--){
                    array[i][j] = start_value++;
                    System.out.println("array" + "[" + i + "]" + "[" + j + "] = " +array[i][j]);
                }
            }
            leftRigth = !leftRigth;
            }

        System.out.println("\nИтоговый массив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println();
        }
    }
}