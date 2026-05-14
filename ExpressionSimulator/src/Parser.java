import java.util.Stack;

public class Parser {

    public static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            // تجاهل المسافات
            if (c == ' ') continue;

            // رقم (multi-digit)
            if (Character.isDigit(c)) {
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    output.append(exp.charAt(i));
                    i++;
                }
                output.append(" ");
                i--;
            }

            // (
            else if (c == '(') {
                stack.push(c);
            }

            // )
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty()) stack.pop();
            }

            // operator
            else if (isOperator(c)) {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(c)) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }

        // تفريغ الستاك
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
}