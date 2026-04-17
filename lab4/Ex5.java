package lab4;

public class Ex5 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            System.out.println("1");
        } catch (RuntimeException e) {        // добавили перехват
            System.out.println("Перехвачено: " + e);
        }
        System.out.println("2");
    }
}