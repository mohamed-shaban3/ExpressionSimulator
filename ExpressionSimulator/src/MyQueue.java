public class MyQueue {
    
    String[] arr = new String[200];
    int front = 0, rear = -1;

    public void enqueue(String x){
        arr[++rear] = x;
    }

    public String dequeue(){
        return arr[front++];
    }

    public boolean isEmpty(){
        return front > rear;
    }

    public int size(){
        return rear - front + 1;
    }

    public void display(){
        System.out.print("[");
        for(int i=front;i<=rear;i++){
            System.out.print(arr[i]);
            if(i<rear) System.out.print(", ");
        }
        System.out.println("]");
    }
}