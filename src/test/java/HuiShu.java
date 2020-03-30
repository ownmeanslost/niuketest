import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: HuiShu
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/27 16:27
 */
public class HuiShu {
    public static void test(int n,int m, int[] arr, Stack<Integer> s, int index){

        if(index == n){
            return;
        }
        //遍历栈求和
        int sum = 0;
        for (int x : s){
            sum+=x;
        }
        if(sum + arr[index] <= m){
            s.push(arr[index]);
            //左子树
            test(n, m, arr, s, index+1);
            if(sum + arr[index] == m){//相等时输出
                for (int x : s){
                    System.out.print(x + " ");
                }
                System.out.print("\n");
            }
            //右子树
            s.pop();
            test(n, m, arr, s, index+1);

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for(int i=0; i< arr.length; i++){
            arr[i] = i+1;
        }

        test(n, m, arr, new Stack<Integer>(), 0);
    }

}
