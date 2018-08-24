package com.evan.interviews;

import com.evan.interviews.some_used_class.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by asus on 2018/3/21.
 */
public class Q7_重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return createTree(map, pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode createTree(Map<Integer, Integer> map, int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        Integer index = map.get(pre[preLeft]);
        int leftSize = index - inLeft;
        root.left = createTree(map, pre, in, preLeft + 1, preLeft + leftSize, inLeft, index - 1);
        root.right = createTree(map, pre, in, preLeft + leftSize + 1, preRight, index + 1, inRight);
        return root;
    }

    @Test
    public void test() {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }


}
