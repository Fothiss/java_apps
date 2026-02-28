package timus;
import java.util.Scanner;

public class Timus1197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String pos = sc.next();
            char col = pos.charAt(0);
            int row = pos.charAt(1) - '0';
            int x = col - 'a' + 1;
            int y = row;
            int count = 0;
            int[][] moves = {{-2,-1}, {-2,1}, {-1,-2}, {-1,2}, {1,-2}, {1,2}, {2,-1}, {2,1}};
            for (int[] move : moves) {
                int nx = x + move[0];
                int ny = y + move[1];
                if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}