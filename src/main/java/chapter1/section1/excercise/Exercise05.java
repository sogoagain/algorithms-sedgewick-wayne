package chapter1.section1.excercise;

public class Exercise05 {

    public static boolean isBetween0and1(double x, double y) {
        return isBetween0and1(x) && isBetween0and1(y);
    }

    private static boolean isBetween0and1(double number) {
        return number >= 0 && number <= 1;
    }
}
