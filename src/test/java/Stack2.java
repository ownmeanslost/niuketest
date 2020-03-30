import java.util.Scanner;

/**
 * @ClassName: Stack2 小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/26 18:48
 */
public class Stack2 {

    public static class CrLink{
       public CrLink next;
        public  boolean hasValue;
        public  boolean isFirst;
        public  boolean isLast;
        public int value;

        public CrLink(boolean hasValue, boolean isFirst, boolean isLast) {
            this.hasValue = hasValue;
            this.isFirst = isFirst;
            this.isLast = isLast;
        }
    }
    public static void process(CrLink crLink, int count, int n){
        while (count < n){
            if(!crLink.hasValue){
                //找到下一个空的连表，进行填数
                crLink = crLink.next;
                while (crLink.hasValue){
                    crLink = crLink.next;
                }
                crLink.value = ++count;
                crLink.hasValue = true;
                crLink = crLink.next;
            }else{
                crLink = crLink.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n != 0){
            for(int i =0; i < n; i++){
                int a = scanner.nextInt();
                if(a != 0){
                    //创建循环连表
                    CrLink crLinkFirst = new CrLink(false, true, false);
                    CrLink crLink = crLinkFirst;
                     for(int j =1; j < a; j ++){
                         CrLink crLinkCen = null;
                         if(j == a-1){
                              crLinkCen = new CrLink(false, false, true);
                         }else {
                              crLinkCen = new CrLink(false, false, false);
                         }
                         crLink.next = crLinkCen;
                         crLink = crLinkCen;
                    }
                    crLink.next = crLinkFirst;
                     if(a == 1){
                         crLinkFirst.isLast = true;
                     }
                     process(crLinkFirst, 0, a);

                     //输出
                    while (a != 0){
                        System.out.print(crLinkFirst.value + " ");
                        crLinkFirst = crLinkFirst.next;
                        a--;
                    }
                    System.out.print("\n");
                }
            }
        }
    }



}
