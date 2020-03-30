import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: 单向有序链表合并
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/2/1 9:58
 */
public class danxaingyouxulainbiao {

    public static List<TreeNode> list = new ArrayList<TreeNode>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        //前序排列
        test1(pRootOfTree);

        //排序（从大到小）
        list.sort( new Comparator<TreeNode>() {
            public int compare(TreeNode o1, TreeNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val == o2.val){
                    return 0;
                }
                return 1;
            }
        });

        //双向链表变换
        TreeNode head = list.get(0);
        TreeNode last = list.get(list.size() -1);
        head.left = last;
        last.right = head;
        for (int i= 1; i < list.size(); i++){
            TreeNode next = list.get(i);
            head.right = next;
            next.left = head;
            head = next;
        }
        return pRootOfTree;
    }


    //前序遍历（根，左，右）
    public static void test1(TreeNode treeNode){

        list.add(treeNode);
        TreeNode leftTree = treeNode.left;
        if(leftTree != null) {
            test1(leftTree);
        }
       TreeNode rightTree = treeNode.right;
        if(rightTree != null) {
            test1(rightTree);
        }
    }

}
