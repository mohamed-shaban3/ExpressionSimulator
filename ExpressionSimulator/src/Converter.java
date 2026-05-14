public class Converter {

    static int precedence(String op){
        if(op.equals("^")) return 3;
        if(op.equals("*") || op.equals("/") || op.equals("%")) return 2;
        if(op.equals("+") || op.equals("-")) return 1;
        return 0;
    }

    public static MyQueue toPostfix(MyQueue input){

        MyStack s = new MyStack();
        MyQueue output = new MyQueue();

        while(!input.isEmpty()){

            String token = input.dequeue();

            if(token.matches("-?\\d+(\\.\\d+)?")){
                output.enqueue(token);
            }

            else if(token.equals("(")){
                s.push(token);
            }

            else if(token.equals(")")){

                while(!s.peek().equals("("))
                    output.enqueue(s.pop());

                s.pop();
            }

            else{

                while(!s.isEmpty() &&
                    precedence(s.peek()) >= precedence(token))
                    output.enqueue(s.pop());

                s.push(token);
            }
        }

        while(!s.isEmpty())
            output.enqueue(s.pop());

        return output;
    }
}