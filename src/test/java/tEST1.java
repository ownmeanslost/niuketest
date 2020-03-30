import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: tEST1
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/29 10:37
 */
public class tEST1 {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str1 = scanner.nextLine();
        int n = Integer.valueOf(str.split(" ")[0]);
        int n1 = n;
        int x = Integer.valueOf(str.split(" ")[1]);
        List<Integer> list = new LinkedList<Integer>();

        String[] arrStr = str1.split(" ");
        //List接收数组
        for(int i =0;i < arrStr.length;i++){
            list.add(Integer.valueOf(arrStr[i]));
        }

        int index1 = -1;
        int index = -1; //记录给定数字在数组中的下标
        for(Integer val : list){
            ++index1;
            if(x == val){
                index = index1;
                break;
            }
        }

        //数组中不存在X
        if(index == -1){
           list.add(x);
           n = n+1;
        }

        //排序
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return 1;
                }else if(o1 < o2){
                    return -1;
                }
                return 0;
            }
        });
        index = -1;
        index1 = -1;
        //找到list X的位置
        for(Integer val : list){
            ++index1;
            if(x == val){
                index = index1;
                break;
            }
        }

        while (true){
            Integer[] arr = list.toArray(new Integer[0]);
            if(n == 702){
                int a = 1;
            }
            if((n -1)/2 == index || arr[(n -1)/2] == x){
                break;
            }else if((n-1)/2 > index){
                n = n+1;
                index++;
                list.add(0,-1);
            }else {
                list.add(n -1,100001);
                n = n+1;

            }

        }

        System.out.println(n-n1);

    }

}
