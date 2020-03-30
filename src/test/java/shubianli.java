import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: preBInali
 * @Author: shaofan.li
 * @Description:
 * @Date: 2020/1/22 16:26
 */
public class shubianli {
  public static class TreeNode {
      String val;
      TreeNode left;
      TreeNode right;

      TreeNode(String x) {
          val = x;
      }
  }
     //前序遍历（根，左，右）
    public static void test1(TreeNode treeNode){

        System.out.print(treeNode.val+ " ");
        TreeNode leftTree = treeNode.left;
        if(leftTree != null) {
            test1(leftTree);
        }
        TreeNode rightTree = treeNode.right;
        if(rightTree != null) {
            test1(rightTree);
        }
    }

    //中序遍历（左， 根，右）
    public static void test2(TreeNode treeNode){


        TreeNode leftTree = treeNode.left;
        if(leftTree != null) {
            test2(leftTree);
        }

        System.out.print(treeNode.val+" ");

        TreeNode rightTree = treeNode.right;
        if(rightTree != null) {
            test2(rightTree);
        }
    }

    //后序遍历（左，右， 根）
    public static void test3(TreeNode treeNode){


        TreeNode leftTree = treeNode.left;
        if(leftTree != null) {
            test3(leftTree);
        }

        TreeNode rightTree = treeNode.right;
        if(rightTree != null) {
            test3(rightTree);
        }

        System.out.print(treeNode.val+" ");
    }

    //层次遍历
    public void cengci(TreeNode root, List list){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        if(queue.size() != 0){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left != null){
                queue.offer(left);
            }
            if(right != null){
                queue.offer(right);
            }
            list.add(node);
        }


    }

    //前序，中序解树
    public static TreeNode resoluteByPreAndIn(int [] pre,int [] in){
      if(in.length == 0){
          return null;
      }
      int root = pre[0];
      TreeNode treeNode1 = new TreeNode(root + "");

      //寻找左子树以及右子树
      int index = 0;
      for(int i = 0; i< pre.length; i++){
          if(in[i] == root){
               index = i;
          }
      }
      //子树中序遍历i
        int[] leftTreeIn = new int[0];
        int[] leftTreePre =  new int[0];
        if(index != 0){
            leftTreeIn = new int[index];
            for(int i = 0; i< index; i++){
                leftTreeIn[i] = in[i];
            }
            //子树前序遍历
            leftTreePre= new int[index];

            for(int i = 1; i< index + 1; i++){
                leftTreePre[i - 1] = pre[i];
            }
        }

        int[] rightTreeIn = new int[0];;
        int[] rightTreePre = new int[0];;
        if(index != pre.length -1){
            rightTreeIn = new int[pre.length - index -1];

            for(int i = index + 1; i< pre.length; i++){
                rightTreeIn[i- index -1] = in[i];
            }
            rightTreePre = new int[pre.length - index -1];
            for(int i = index + 1; i< pre.length; i++){
                rightTreePre[i - 1 - index] = pre[i];
            }
        }
        TreeNode left = resoluteByPreAndIn(leftTreePre, leftTreeIn);
        if(null != left){
            treeNode1.left = left;
        }
        TreeNode right = resoluteByPreAndIn(rightTreePre, rightTreeIn);
        if(null != right){
            treeNode1.right = right;
        }
        return treeNode1;
    }

    //前序，后序解树无法到

    //中序后序解树
    public static TreeNode resoluteByBehindAndIn(int [] beh,int [] in){
        if(in.length == 0){
            return null;
        }
        int root = beh[in.length -1];
        TreeNode treeNode1 = new TreeNode(root + "");

        //寻找左子树以及右子树
        int index = 0;
        for(int i = 0; i< in.length; i++){
            if(in[i] == root){
                index = i;
            }
        }
        //子树中序遍历i
        int[] leftTreeIn = new int[0];
        int[] leftTreePre =  new int[0];
        if(index != 0){
            leftTreeIn = new int[index];
            for(int i = 0; i< index; i++){
                leftTreeIn[i] = in[i];
            }
            //子树后序遍历
            leftTreePre= new int[index];

            for(int i = 0; i< index; i++){
                leftTreePre[i] = beh[i];
            }
        }

        int[] rightTreeIn = new int[0];;
        int[] rightTreePre = new int[0];;
        if(index != in.length -1){
            rightTreeIn = new int[in.length - index -1];

            for(int i = index + 1; i< in.length; i++){
                rightTreeIn[i- index -1] = in[i];
            }
            rightTreePre = new int[in.length - index -1];
            for(int i = index ; i< beh.length - 1; i++){
                rightTreePre[i - index] = beh[i];
            }
        }
        TreeNode left = resoluteByBehindAndIn(leftTreePre, leftTreeIn);
        if(null != left){
            treeNode1.left = left;
        }
        TreeNode right = resoluteByBehindAndIn(rightTreePre, rightTreeIn);
        if(null != right){
            treeNode1.right = right;
        }
        return treeNode1;
    }

    //层次遍历与中序求树
    public static TreeNode resoluteByC(int root, int[] cInt, int[] inInt){
      TreeNode treeNode = new TreeNode(root+ "");

      //找到跟节点
      int index = 0;
      for(int i = 0; i < inInt.length; i++){
          if(root == inInt[i]){
              index =i;
              break;
          }
      }
      //分出左右树
        int[] leftInt = new int[0];
        int[] rightInt = new int[0];
        if(index != 0){
            leftInt = new int[index];
            for (int i = 0; i< index; i++){
                leftInt[i] = inInt[i];
            }
        }

        if(index != inInt.length -1){
            rightInt = new int[inInt.length - index -1];
            for (int i =index + 1; i< inInt.length; i++){
                rightInt[i - index -1] = inInt[i];
            }
        }

        //找到左孩子
        int leftChild = 0;
        TreeNode left = null;
        if(leftInt.length > 0){
            for (int i = 0; i< cInt.length; i++){
                for (int j = 0; j< leftInt.length; j++){
                    if(cInt[i] == leftInt[j]){
                        leftChild = cInt[i];
                                break;
                    }
                }
                if(leftChild != 0){
                    break;
                }
            }
            left = resoluteByC(leftChild, cInt, leftInt);
            if(left != null){
                treeNode.left = left;
            }
        }


        //找到右孩子节点
        int rightChild = 0;
        TreeNode right = null;
        if(rightInt.length > 0){
            for (int i = 0; i< cInt.length; i++){
                for (int j = 0; j< rightInt.length; j++){
                    if(cInt[i] == rightInt[j]){
                        rightChild = cInt[i];
                        break;
                    }
                }
                if(rightChild != 0){
                    break;
                }
            }
            right = resoluteByC(rightChild, cInt, rightInt);
            if(right != null){
                treeNode.right = right;
            }
        }
        return treeNode;
    }


    //输入叶子节点
    public static void leafPrint(TreeNode treeNode){
        TreeNode treeNode1 = treeNode.left;
        TreeNode treeNode2 = treeNode.right;
        if(treeNode1 == null && treeNode2 == null){
            System.out.print(treeNode.val + " ");
        }
        if(treeNode1 != null){
            leafPrint(treeNode1);
        }
        if(treeNode2 != null){
            leafPrint(treeNode2);
        }
    }
    public static void main(String[] args) {
        /*TreeNode treeNode1 = new TreeNode("G");

        TreeNode treeNode2 = new TreeNode("D");

        TreeNode treeNode3 = new TreeNode("A");

        TreeNode treeNode4 = new TreeNode("F");

        TreeNode treeNode5 = new TreeNode("E");

        TreeNode treeNode6 = new TreeNode("M");

        TreeNode treeNode7 = new TreeNode("H");

        TreeNode treeNode8 = new TreeNode("Z");

        treeNode1.left = treeNode2;

        treeNode1.right = treeNode6;

        treeNode2.left = treeNode3;

        treeNode2.right = treeNode4;

        treeNode4.left = treeNode5;

        treeNode6.left = treeNode7;

        treeNode6.right = treeNode8;

        //test1(treeNode1);

        //test2(treeNode1);

        test3(treeNode1);*/


        /*int[] pre = new int[]{1,2,4,7,3,5,6,8};

        int[] in = new int[]{4,7,2,1,5,3,8,6};

        int[] beh = new int[]{7,4,2,5,8,6,3,1};
        //TreeNode  treeNode = resoluteByPreAndIn(pre, in);
        TreeNode  treeNode = resoluteByBehindAndIn(beh, in);
        test3(treeNode);*/

        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] preStr = new String[0];
        if(null != str1 && str1.length() != 0){
            preStr = str1.split(" ");
        }

        String str2 = scanner.nextLine();
        String[] inStr = new String[0];
        if(null != str1 && str1.length() != 0){
            inStr = str2.split(" ");
        }

        int[] preInt = new int[preStr.length];
        int i = 0;
        for(String s : preStr){
            preInt[i++] = Integer.valueOf(s);
        }
        int[] inInt = new int[inStr.length];
        int j = 0;
        for(String s : inStr){
            inInt[j++] = Integer.valueOf(s);
        }
       /* TreeNode treeNode = resoluteByPreAndIn(preInt, inInt);

        inSum(treeNode);

        test2(treeNode);*/

        TreeNode treeNode  = resoluteByC(preInt[0], preInt, inInt);
        leafPrint(treeNode);
        System.out.print("\n");
        test1(treeNode);
        System.out.print("\n");
        test3(treeNode);

  }
    //中序遍历求和
    public static int inSum(TreeNode treeNode){

        TreeNode leftTree = treeNode.left;
        int leftValue = 0;
        if(leftTree != null) {
           leftValue = inSum(leftTree);
        }

        int rightValue = 0;
        TreeNode rightTree = treeNode.right;
        if(rightTree != null) {
            rightValue = inSum(rightTree);
        }
        int sum = leftValue + rightValue + Integer.valueOf(treeNode.val);
        treeNode.val = (leftValue + rightValue) + "";
        return  sum;
    }


}


