package LeetCodeQuestions;

import LEETCODE.StackAndQueue.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther:Evan
 * @Description:
 * @CreateDate: 2018/4/16 14:43
 */
public class Q222_CountCompleteTreeNodes {
    /**
     * version 1 :利用满二叉树性质;
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int height = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null && right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null) {
            return (1 << height) - 1;
        } else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * version 2 广度优先遍历
     * @param root
     * @return
     */
    public int countNodes_2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                    count++;
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    count++;
                }

        }
        return count;
    }



}
