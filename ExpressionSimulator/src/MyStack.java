public class MyStack {
    String[] arr = new String[200];
    int top = -1;

    public void push(String x){
        arr[++top] = x;
    }

    public String pop(){
        return arr[top--];
    }

    public String peek(){
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
}