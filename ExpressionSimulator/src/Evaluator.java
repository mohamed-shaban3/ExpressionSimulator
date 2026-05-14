public class Evaluator {

    public static double evaluate(MyQueue q){

        double[] st = new double[200];
        int top = -1;

        while(!q.isEmpty()){

            String token = q.dequeue();

            if(token.matches("-?\\d+(\\.\\d+)?")){
                st[++top] = Double.parseDouble(token);
            }else{

                double b = st[top--];
                double a = st[top--];

                switch(token){

                    case "+": st[++top]=a+b; break;
                    case "-": st[++top]=a-b; break;
                    case "*": st[++top]=a*b; break;

                    case "/":
                        if(b==0) throw new ArithmeticException();
                        st[++top]=a/b;
                        break;
                }
            }
        }

        return st[top];
    }
}