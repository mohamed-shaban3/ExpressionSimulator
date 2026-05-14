public class Tokenizer {

    public static MyQueue tokenize(String exp) {

        MyQueue q = new MyQueue();
        String num = "";

        for (int i = 0; i < exp.length(); i++) {

            char c = exp.charAt(i);

            // لو رقم أو decimal point
            if (Character.isDigit(c) || c == '.') {
                num += c;
            }

            // لو سالب ويمثل negative number
            else if (c == '-') {

                if (i == 0 ||
                    exp.charAt(i - 1) == '(' ||
                    exp.charAt(i - 1) == '+' ||
                    exp.charAt(i - 1) == '-' ||
                    exp.charAt(i - 1) == '*' ||
                    exp.charAt(i - 1) == '/' ||
                    exp.charAt(i - 1) == '%' ||
                    exp.charAt(i - 1) == '^') {

                    num += c;   // جزء من الرقم
                } else {

                    if (!num.equals("")) {
                        q.enqueue(num);
                        num = "";
                    }

                    q.enqueue("-");
                }
            }

            else {

                if (!num.equals("")) {
                    q.enqueue(num);
                    num = "";
                }

                if (c != ' ')
                    q.enqueue(String.valueOf(c));
            }
        }

        if (!num.equals("")) {
            q.enqueue(num);
        }

        return q;
    }
}