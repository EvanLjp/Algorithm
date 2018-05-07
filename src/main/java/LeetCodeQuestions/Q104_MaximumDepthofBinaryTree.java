package LeetCodeQuestions;

import LEETCODE.TreeAndRecursion.TreeNode;

/**
 * @Auther:Evan
 * @Description: 查找二叉树最大深度
 * @CreateDate: 2018/4/16 10:29
 */
public class Q104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
