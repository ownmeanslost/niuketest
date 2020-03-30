import java.util.Scanner;

/**
 * @ClassName: LianbiaoFanzhaun
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/29 16:04
 */

public class lianbiaofanzhaun {
    public static ListNode listNodePre = null;
    //两段翻转之间的衔接尾巴衔接点
    public static ListNode listNodeLast = null;
    public static void fanzhaun(ListNode begin, int k){
        if(begin == null){
            return;
        }
        ListNode head = begin;
        ListNode nodeTest = begin;
        //连表长度是否满足K值
        int i = 0;
        while (nodeTest != null){
            i++;
            if(i == k ){
                break;
            }
            nodeTest = nodeTest.next;

        }
        //有K个值则旋转
        if(i == k && k !=1){
            int m =0;
            //尾巴衔接点
            listNodeLast = nodeTest.next;
            //倒数第二个
            ListNode node = begin.next;
            begin.next = listNodeLast;
            while(node!= null){
                ListNode nextNode = null;
                if(m < k -2){
                    nextNode = node.next;
                }

                node.next =begin;
                begin = node;
                node = nextNode;
                m++;
            }
            //
            if(listNodePre != null){
                listNodePre.next = begin;
            }
            listNodePre = head;
            fanzhaun(listNodeLast, k);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String aa = scanner.nextLine();
        if("".equals(aa)){
            System.out.print("");
        }
        String[] str =aa.split(" ");
        int k = Integer.valueOf(scanner.nextLine());
        ListNode head = new ListNode(Integer.valueOf(str[0]));

        ListNode headNext = head;
        for(int i =1; i< str.length; i++){
            ListNode next =  new ListNode(Integer.valueOf(str[i]));
            headNext.next = next;
            headNext = next;
        }

        ListNode headText = head;
        //寻找跟节点
        int i = 0;
        while (headText != null){
            i++;
            if(i == k){
                break;
            }
            headText = headText.next;
        }
        ListNode root = null;
        if(i == k){
            root = headText;
        }else {
            root =head;
        }
        fanzhaun(head, k);

        while (root != null){
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}

