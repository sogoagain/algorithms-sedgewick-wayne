package chapter1.section3;

import java.util.Stack;

public class Evaluate {

    public static double calculate(String expression) {
        final String[] tokens = expression.split(" ");
        final Stack<String> operators = new Stack<>();
        final Stack<Double> operands = new Stack<>();

        for (final String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token) || "sqrt".equals(token)) {
                operators.push(token);
            } else if ("(".equals(token)) {
            } else if (")".equals(token)) {
                final String operator = operators.pop();
                double right = operands.pop();
                double result = right;

                if ("+".equals(operator)) {
                    result = operands.pop() + right;
                } else if ("-".equals(operator)) {
                    result = operands.pop() - right;
                } else if ("*".equals(operator)) {
                    result = operands.pop() * right;
                } else if ("/".equals(operator)) {
                    result = operands.pop() / right;
                } else if ("sqrt".equals(operator)) {
                    result = Math.sqrt(right);
                }
                operands.push(result);
            } else {
                operands.push(Double.parseDouble(token));
            }
        }

        return operands.pop();
    }
}
