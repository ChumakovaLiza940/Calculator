package EquationModel;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationModel {

    // Evaluate the mathematical expression
    public double evaluate(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", "");
        if (!expression.matches("[0-9+\\-*/^!()exp\\[\\]log.,**]+")) {
            throw new IllegalArgumentException("Invalid characters in expression.");
        }

        if (!hasMatchingBrackets(expression)) {
            throw new IllegalArgumentException("Mismatched brackets in expression.");
        }

        return evaluateExpression(expression);
    }

    private double evaluateExpression(String expression) throws Exception {
        Stack<Double> values = new Stack<>();
        Stack<String> ops = new Stack<>();

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
                ops.push(String.valueOf(c));
            } else if (c == ')') {
                while (!ops.peek().equals("(")) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (c == 'e' && expression.startsWith("exp(", i)) {
                int end = findClosingBracket(expression, i + 4);
                double val = evaluateExpression(expression.substring(i + 4, end));
                values.push(Math.exp(val));
                i = end;
            } else if (c == 'l' && expression.startsWith("log(", i)) {
                int end = findClosingBracket(expression, i + 4);
                double val = evaluateExpression(expression.substring(i + 4, end));
                values.push(Math.log(val) / Math.log(2));
                i = end;
            } else if (c == '!') {
                values.push(factorial(values.pop()));
            } else if (isOperator(c)) {
                while (!ops.empty() && hasPrecedence(String.valueOf(c), ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(String.valueOf(c));
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean hasMatchingBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private int findClosingBracket(String expression, int start) {
        int count = 1;
        for (int i = start; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') count++;
            if (expression.charAt(i) == ')') count--;
            if (count == 0) return i;
        }
        return -1;
    }

    private boolean isOperator(char op) {
        return (op == '+' || op == '-' || op == '*' || op == '/' || op == '^' || "**".equals(String.valueOf(op)));
    }
    private boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")"))
            return false;
        if ((op1.equals("*") || op1.equals("/") || op1.equals("^") || op1.equals("**")) && (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;
    }

    private double applyOp(String op, double b, double a) throws Exception {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            case "^":
            case "**":
                return Math.pow(a, b);
        }
        return 0;
    }

    private double factorial(double n) {
        if (n == 0) return 1;
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Count the number of terms in the expression
    public int countTerms(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String[] terms = expression.split("[+\\-*/^()!exp\\[\\]log.,**]+");
        int count = 0;
        for (String term : terms) {
            if (!term.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}

