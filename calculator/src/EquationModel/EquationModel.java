package EquationModel;
import java.util.Stack;

public class EquationModel {

    // Evaluate the mathematical expression
    public double evaluate(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", "");
        if (!expression.matches("[0-9+\\-*/^//().]*")) {
            throw new IllegalArgumentException("Invalid characters in expression.");
        }

        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sbuf = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sbuf.append(expression.charAt(i++));
                }
                values.push(Double.parseDouble(sbuf.toString()));
                i--;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (isOperator(c)) {
                while (!ops.empty() && hasPrecedence(c, ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Check if character is operator
    private boolean isOperator(char op) {
        return (op == '+' || op == '-' || op == '*' || op == '/' || op == '^' || op == '/');
    }

    // Check precedence of operators
    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/' || op1 == '^') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // Apply operation to two operands
    private double applyOp(char op, double b, double a) throws Exception {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            case '^':
                return Math.pow(a, b);
        }
        return 0;
    }

    // Count the number of terms in the expression
    public int countTerms(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String[] terms = expression.split("[+\\-*/^()]+");
        int count = 0;
        for (String term : terms) {
            if (!term.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
