package lab4;

public class Ex10 {
    public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            //return 20; // Перекрывает возвращаемое значение из блока try, так делать не надо
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }

}
