import java.util.Stack;

/**
 * @ClassName: Fanzhuan
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/29 12:20
 */
public class 翻转 {

    public ListNode ReverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode list = stack.pop();
        while(!stack.isEmpty()){
            list.next =stack.pop();
        }

        return list;

    }
}

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}