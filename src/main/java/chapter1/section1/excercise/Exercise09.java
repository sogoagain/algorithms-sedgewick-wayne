package chapter1.section1.excercise;

public class Exercise09 {

    public static String toBinaryString(int N) {
        final StringBuilder result = new StringBuilder();

        for (int n = N; n > 0; n /= 2) {
            result.insert(0, (n % 2));
        }

        return result.toString();
    }
}
