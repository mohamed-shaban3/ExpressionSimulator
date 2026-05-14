public class ExpressionTree {

    Node root;

    public Node buildTree(MyQueue postfix) {

        Node[] stack = new Node[200];
        int top = -1;

        while (!postfix.isEmpty()) {

            String token = postfix.dequeue();

            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack[++top] = new Node(token);
            } else {

                Node right = stack[top--];
                Node left = stack[top--];

                Node newNode = new Node(token);
                newNode.left = left;
                newNode.right = right;

                stack[++top] = newNode;
            }
        }

        root = stack[top];
        return root;
    }

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " ");
        }
    }
}