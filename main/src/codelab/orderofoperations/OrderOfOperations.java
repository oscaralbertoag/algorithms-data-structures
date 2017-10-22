package codelab.orderofoperations;

import java.util.Stack;

/**
 * Create a simple class that enforces order of operations for + - * / Don't worry about parenthesized expressions
 */
public class OrderOfOperations {
    private static final String DIGIT_REGEX = "\\d+";

    public int evaluateExpression(String expression) {
        if (expression == null) {
            return 0;
        }

        Stack<String> operators = new Stack<>();
        Stack<String> operands = new Stack<>();

        char current;
        boolean negative = false;
        for (int i = 0; i < expression.length(); i++) {
            current = expression.charAt(i);
            if (current == '+' || current == '-') {
                // Always push addition operators by pushing negative operands instead of subtraction operators
                negative = current == '-';
                operators.push("+");
            } else if (current == '*' || current == '/') {
                char right;
                do {
                    // Find next number
                    right = expression.charAt(++i);
                } while (right == ' ');
                String rightOperand = extractNumber(expression, i);
                i += rightOperand.length() - 1;
                String leftOperand = operands.pop();
                operands.push(String.valueOf(performOperation(current, leftOperand, rightOperand)));
            } else if (String.valueOf(current).matches(DIGIT_REGEX)) {
                String number = extractNumber(expression, i);
                i += number.length() - 1;
                String operand = negative ? "-" + number : number;
                operands.push(operand);
                negative = false;
            }
        }

        while (!operators.isEmpty()) {
            char operator = operators.pop().charAt(0);
            String right = operands.pop();
            String left = operands.pop();

            operands.push(String.valueOf(performOperation(operator, left, right)));
        }
        return Integer.parseInt(operands.pop());
    }

    protected int performOperation(char operator, String leftOperand, String rightOperand) {
        int left = Integer.parseInt(leftOperand);
        int right = Integer.parseInt(rightOperand);
        int result = 0;

        switch (operator) {
        case '+':
            result = left + right;
            break;
        case '-':
            result = left - right;
            break;
        case '*':
            result = left * right;
            break;
        case '/':
            result = left / right;
            break;
        default:
            break;
        }
        return result;
    }

    protected String extractNumber(String expression, int index) {
        if (expression == null || index >= expression.length()) {
            return "";
        }

        StringBuilder number = new StringBuilder();
        int counter = index;
        while (counter < expression.length() && String.valueOf(expression.charAt(counter)).matches(DIGIT_REGEX)) {
            number.append(expression.charAt(counter++));
        }
        return number.toString();
    }
}
