import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: Stack1
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/26 13:11
 */
public class Stack1 {
    public static Stack<Integer> stack1 = new Stack<Integer>();
    public static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int e){
        stack1.push(e);
       if(stack2.isEmpty()){
           stack2.push(e);
       }else {
           if(e <= stack2.peek()){
               stack2.push(e);
           }
       }
    }

    public static int pop(){
        if (stack1.peek().equals(stack2.peek())){
            stack2.pop();
            return stack1.pop();
        }
        return stack1.pop();
    }

    public static int min(){
        return stack2.peek();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = Integer.valueOf(scanner.nextLine());
        int in = -1;
        if(result != 0){
            for(int i = 0; i < result; i++){
                in = scanner.nextInt();
                switch (in){
                    case 0: System.out.println(min());
                    break;
                    case 1:  push(scanner.nextInt());
                    break;
                    case 2: System.out.println(pop());
                    break;
                    default:
                        break;
                }
            }
        }
    }
}
