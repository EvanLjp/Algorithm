package com.evan.coding;

import com.evan.interviews.some_used_class.ListNode;
import com.evan.interviews.some_used_class.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :evan
 * @date :2018-08-19 22:23
 **/
public class Q4重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }

        return createTree(map, pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode createTree(Map<Integer, Integer> map, int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > preRight) {
            return null;
        }
        int val = pre[preLeft];
        TreeNode root = new TreeNode(val);
        Integer index = map.get(val);
        int size = index - inLeft;
        root.left = createTree(map, pre, in, preLeft + 1, preLeft + size, inLeft, index - 1);
        root.right = createTree(map, pre, in, preLeft + size + 1, preRight, index + 1, inRight);
        return root;

    }
}
