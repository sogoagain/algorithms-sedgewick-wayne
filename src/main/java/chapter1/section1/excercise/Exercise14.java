package chapter1.section1.excercise;

public class Exercise14 {

    public static int lg(int N) {
        int count = 0;
        for(int n = N; n >= 2; n /= 2) {
            count++;
        }
        return count;
    }
}
