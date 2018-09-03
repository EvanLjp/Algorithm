package com.evan.leetcode.algorithm.treerecursion;

import com.evan.leetcode.algorithm.stack_queue.classes.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/5.
 */
public class Q257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> list = binaryTreePaths(root.left);
        for (String str : list) {
            res.add(root.val + "->" + str);
        }
        List<String> list2 = binaryTreePaths(root.right);
        for (String str : list2) {
            res.add(root.val + "->" + str);
        }
        return res;


    }


}
