package chapter1.section1.excercise;

public class Exercise11 {

    public static String print2D(boolean[][] arr) {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                String element = " ";
                if (arr[i][j]) {
                    element = "*";
                }
                result.append("[").append(i).append(",").append(j).append("]").append(element).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
