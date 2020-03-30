import java.util.ArrayList;

/**
 * @ClassName: test
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/21 15:29
 */
public class test {

    public static void main(String[] args) {
        //int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(test1(new ListNode(0)));

    }

    /**
     * 返回从源字符串到目标字符串的最小操作数
     * source: 源字符串
     * target：目标字符串
     * 返回：最小操作数
     */
    public static  ArrayList<Integer> test1(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if(null == listNode) {
            return arrayList;
        }
        do {
            arrayList.add(0, listNode.val);
            listNode = listNode.next;
        }while ((null != listNode));
        return arrayList;
    }


         public static class ListNode {
             int val;
             ListNode next = null;

             ListNode(int val) {
                 this.val = val;
             }
        }

}
