package chapter1.section1.excercise;

public class Exercise16 {

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }

        return exR1(n - 3) + n + exR1(n - 2) + n;
    }
}
