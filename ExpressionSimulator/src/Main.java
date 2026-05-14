import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String expression = "";

        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                expression += sc.nextLine();
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error reading input file");
            return;
        }

        if (expression.trim().equals("")) {
            System.out.println("Error: Empty input");
            return;
        }

        System.out.println("Input Expression: " + expression);

        MyQueue q = Tokenizer.tokenize(expression);

        System.out.print("Queue: ");
        q.display();

        MyQueue postfix = Converter.toPostfix(cloneQueue(q));

        System.out.print("Postfix: ");
        postfix.display();

        double result = 0;

        try {
            result = Evaluator.evaluate(cloneQueue(postfix));
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero");
            return;
        }

        // TREE
        ExpressionTree tree = new ExpressionTree();

        Node root = tree.buildTree(cloneQueue(postfix));

        System.out.println("\nPreorder:");
        tree.preorder(root);

        System.out.println("\nInorder:");
        tree.inorder(root);

        System.out.println("\nPostorder:");
        tree.postorder(root);

        // HASH TABLE
        HashTable h = new HashTable();

        String[] arr = expression.split("[+\\-*/()%^ ]+");

        for (String s : arr) {

            if (!s.equals("")) {

                int num = (int) Double.parseDouble(s);

                h.insertLinear(num);
                h.insertQuadratic(num);
                h.insertDouble(num);
                h.insertChain(num);
            }
        }

        h.display();
    }

    public static MyQueue cloneQueue(MyQueue q) {

        MyQueue temp = new MyQueue();
        MyQueue copy = new MyQueue();

        while (!q.isEmpty()) {

            String x = q.dequeue();

            temp.enqueue(x);
            copy.enqueue(x);
        }

        while (!temp.isEmpty()) {
            q.enqueue(temp.dequeue());
        }

        return copy;
    }
}