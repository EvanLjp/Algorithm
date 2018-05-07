package LEETCODE.TreeAndRecursion;


/**
 * Created by asus on 2018/2/4.
 */
public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        int maxDepth=getMaxDepth(root);
        return maxDepth;
    }

    private int getMaxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(getMaxDepth(root.left),getMaxDepth(root.right))+1;
    }


}
