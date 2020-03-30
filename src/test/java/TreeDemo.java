/**
 * @ClassName: TreeDemo
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/2/26 16:07
 */
public class TreeDemo {

    static class Node{
        String value;
        Node left;
        Node right;
    }
    public static void main(String[] args){
        String[] strings = new String[]{"1", "2", "3", null ,"4", "5"};
        createTree(strings);
    }
    public static Node createTree(String[] strs){
        if(strs.length == 0){
            return null;
        }
        Node node = new Node();
        node.value = strs[0];
        digui(node, strs, 0);

        return node;
    }

    public static void digui(Node root, String[] strs, int index){
        //左子节点
        int leftIndex = 2 * index +1;
        //右子节点
        int rightIndex = 2 * (index + 1);

        //构建左子树
        if(leftIndex < strs.length && strs[leftIndex] != null){
            Node left = new Node();
            left.value = strs[leftIndex];
            root.left = left;
            digui(left, strs, leftIndex);
        }
        //构建右子树
        if(rightIndex < strs.length && strs[rightIndex] != null){
            Node right = new Node();
            right.value = strs[rightIndex];
            root.right = right;
            digui(right, strs, rightIndex);
        }
    }

}
