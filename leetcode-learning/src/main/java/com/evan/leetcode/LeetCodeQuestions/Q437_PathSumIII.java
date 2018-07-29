package com.evan.leetcode.LeetCodeQuestions;

import LEETCODE.StackAndQueue.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/4/17 20:52
 */
public class Q437_PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return containPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int containPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res++;
        res += containPath(root.left, sum - root.val);
        res += containPath(root.right, sum - root.val);
        return res;
    }


    @Test
    public void test() {
        Integer[] arr = {};
        System.out.println(pathSum(stringToTreeNode("10,5,-3,3,2,null,11,3,-2,null,1"), 8));
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


}
