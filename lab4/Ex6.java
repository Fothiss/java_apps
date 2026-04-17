package lab4;

public class Ex6 {
    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            System.out.println("1");
        } catch (RuntimeException e) {      // поменяли порядок и этот catch отловит исключение
            System.out.println("3");
        } catch (Exception e) {             // Exception должен быть последним
            System.out.println("2");
        }
        System.out.println("4");
    }
}