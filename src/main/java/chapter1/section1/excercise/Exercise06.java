package chapter1.section1.excercise;

public class Exercise06 {

    public static int[] fibonacci() {
        int f = 0;
        int g = 1;
        int[] result = new int[16];

        for (int i = 0; i <= 15; i++) {
            result[i] = f;
            f = f + g;
            g = f - g;
        }

        return result;
    }
}
