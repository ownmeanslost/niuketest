import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: JiSuanQi
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/31 16:10
 */
public class JiSuanQi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if("".equals(str)){
            System.out.print("Error");
        }
        String[] arr = str.split(" ");
        //校验字符串有效性
        if(!check(arr)){
            System.out.print("Error");
        }else {
            System.out.print(cul(arr));
        }



    }

    /*
    *
     *功能描述  计算
     *         两个栈，一个存放符号，一个存放数字
     *         遇到）则出栈计算值
     * @author shaofan.li
     * @date
     * @param
     * @return
     */
     public static int cul(String[] arr){
         //放运算法
         Stack<String> stack1 = new Stack<String>();
         //存放数字
         Stack<Integer> stack2 = new Stack<Integer>();

         //所有元素进栈
         int i =0;
         do{
             if(arr[i].charAt(0) - '0' >= 0 && arr[i].charAt(0) - '0' <= 9){
                 stack2.push(Integer.valueOf(arr[i]));
             }else if(arr[i].charAt(0) == '+'
                     || arr[i].charAt(0) == '-'
                     || arr[i].charAt(0) == '*'
                     ||arr[i].charAt(0) == '/'
                     ||arr[i].charAt(0) == '('){
                 stack1.push(arr[i]);
             }else if(arr[i].charAt(0) == ')'){
                 while (true){
                     //计算括号里面的值
                     String fuhao1 = stack1.pop();
                     if(fuhao1.equals("+")){
                         //如果出栈的是加减号则直接计算结果，并入栈
                         int value1 = stack2.pop();
                         int value2 = stack2.pop();
                         stack2.push(value1 + value2);
                     }else if(fuhao1.equals("-")){
                         //如果出栈的是加减号则直接计算结果，并入栈
                         int value1 = stack2.pop();
                         int value2 = stack2.pop();
                         stack2.push(value2 - value1);
                     }else if(fuhao1.equals("*")){
                         if(stack1.peek().equals("+") || stack1.peek().equals("-")){
                             String fuhao2 = stack1.pop();
                             int value1 = stack2.pop();
                             int value2 = stack2.pop();
                             int value3 = stack2.pop();
                             if(fuhao2.equals("+")){
                                 stack2.push(value3 + value2);
                                 stack2.push(value1);
                                 stack1.push(fuhao1);
                             }else if(fuhao2.equals("-")){
                                 stack2.push(value3 - value2);
                                 stack2.push(value1);
                                 stack1.push(fuhao1);
                             }
                         }else{
                             int value1 = stack2.pop();
                             int value2 = stack2.pop();
                             stack2.push(value1*value2);
                         }
                     }else if(fuhao1.equals("(")){
                         break;
                     }
                 }
             }
             i++;
         }while (i < arr.length);

         while (!stack1.isEmpty()){
             String fuhao1 = stack1.pop();
             if(fuhao1.equals("+")){
                 //如果出栈的是加减号则直接计算结果，并入栈
                 int value1 = stack2.pop();
                 int value2 = stack2.pop();
                 stack2.push(value1 + value2);
             }else if(fuhao1.equals("-")){
                 //如果出栈的是加减号则直接计算结果，并入栈
                 int value1 = stack2.pop();
                 int value2 = stack2.pop();
                 stack2.push(value2 - value1);
             }else if(fuhao1.equals("*")){
                 if(stack1.isEmpty()){
                     int value1 = stack2.pop();
                     int value2 = stack2.pop();
                     stack2.push(value1*value2);
                 }else if(stack1.peek().equals("+") || stack1.peek().equals("-")){
                     String fuhao2 = stack1.pop();
                     int value1 = stack2.pop();
                     int value2 = stack2.pop();
                     int value3 = stack2.pop();
                     if(fuhao2.equals("+")){
                         stack2.push(value3 + value2);
                         stack2.push(value1);
                         stack1.push(fuhao1);
                     }else if(fuhao2.equals("-")){
                         stack2.push(value3 - value2);
                         stack2.push(value1);
                         stack1.push(fuhao1);
                     }
                 }
             }
         }

         return stack2.pop();
     }

    /*
    *
     *功能描述 1.第一个字符必须是数字或者（
     *        2.（后面必须是数字
     *        3.数字后面必须是加减乘除以及）
     *        4.加减乘除后面必须是数字以及左括号
     *        5.如果)不是最后一个字符，后面必须是加减乘除记忆）
     * @author shaofan.li
     * @date
     * @param
     * @return
     */
    public static boolean check(String[] arr){
        char first = arr[0].charAt(0);
        int leftK =0;
        int rightK =0;
        //第一个字符必须是数子或者左括号
        int count = 0;//0是数字，1表示加减乘除，2表示（  3表示）
        if(first -'0' >= 0 && first -'0' <=9){
            count = 0;
        }else if(first =='('){
            count = 2;
            leftK++;
        }else {
            return false;
        }

        //最后一个字符必须是数字或者）
        char last =  arr[arr.length -1].charAt(0);
        if((last -'0' < 0 || last -'0' > 9) && last != ')'){
            return false;
        }


        //第二个字符开始
        for (int i = 1; i < arr.length; i++){
            if(count == 0){
                if(arr[i].charAt(0) != '+' && arr[i].charAt(0) != '-' && arr[i].charAt(0) != '*' && arr[i].charAt(0) != '/' && arr[i].charAt(0) != ')'){
                    return false;
                }
                count = 1;
                if(arr[i].charAt(0) == ')'){
                    rightK++;
                    count = 3;
                }
            }else if(count == 1){//加减乘除
                if((arr[i].charAt(0) -'0' < 0 || arr[i].charAt(0) -'0' > 9) && arr[i].charAt(0)!='('){
                    return false;
                }
                count = 0;
                if(arr[i].charAt(0)=='('){
                    count = 2;
                    leftK++;
                }
            }else if(count == 2){//左括号
                if((arr[i].charAt(0) -'0' < 0 || arr[i].charAt(0) -'0' > 9) &&  arr[i].charAt(0)!='('){
                    return false;
                }
                count =0;
                if(arr[i].charAt(0)=='('){
                    count = 2;
                    leftK++;
                }
            }else if(count == 3){//右括号
                if(arr[i].charAt(0) != '+' && arr[i].charAt(0) != '-' && arr[i].charAt(0) != '*' && arr[i].charAt(0) != '/' && arr[i].charAt(0) != ')'){
                    return false;
                }
                count = 1;
                if(arr[i].charAt(0) == ')'){
                    rightK++;
                    count = 3;
                }
            }
        }

        //括号是不是对称
        return leftK == rightK;
    }
}
