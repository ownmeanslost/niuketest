import java.util.Stack;

/**
 * @ClassName: LongestPath
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/28 13:44
 */
public class 最长路径 {
    public static int  max = 0;
    public static Stack<TreeNode> stackWhite = new Stack<TreeNode>();
    public static Stack<TreeNode> stackBlack = new Stack<TreeNode>();
    public int findPath(TreeNode root) {
        find(root);
        return max;
    }

    public static void find(TreeNode root){
        if(root != null && root.val == 0){
            stackWhite.push(root);
            int result = 0;
            for(TreeNode x : stackBlack){
                result ++;
            }
            if(result > max){
                max = result;
            }
            //遍历左子树
            find(root.left);
            //遍历右子树
            find(root.right);

            stackWhite.pop();


        }

      /*  if(root.val == 1){
            stackWhite.push(root);
        }*/
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
