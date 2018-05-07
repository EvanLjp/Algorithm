package LeetCodeQuestions;

import LEETCODE.StackAndQueue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/4/16 16:52
 */
public class Q113_PathSumII {
    List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getRes(root, sum, new LinkedList<Integer>());
        return list;
    }

    private void getRes(TreeNode root, int sum, LinkedList<Integer> integers) {
        if(root==null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                integers.add(root.val);
                list.add(new ArrayList<>(integers));
                integers.remove(integers.size() - 1);
            }
            return;
        }
        integers.add(root.val);
        getRes(root.left, sum - root.val, integers);
        getRes(root.right, sum - root.val, integers);
        integers.remove(integers.size() - 1);

    }


}
