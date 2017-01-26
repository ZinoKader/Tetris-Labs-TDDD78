package lab4;

public class NumberTester {

    private NumberTester() {}

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isEven(17));
        System.out.println(isEven(42));
    }

}