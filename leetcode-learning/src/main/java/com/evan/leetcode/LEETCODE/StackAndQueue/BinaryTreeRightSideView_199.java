package com.evan.leetcode.LEETCODE.StackAndQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by asus on 2018/1/28.
 */
public class BinaryTreeRightSideView_199 {


    public List<Integer> rightSideView(TreeNode root) {
        List list = new LinkedList();
        if (root == null) return list;
        Map<Integer, Integer> map = new HashMap<>();
        getDepth(root, map, 1);
        for (int i = 1; map.containsKey(i); i++) {
            list.add(map.get(i));
        }
        return list;

    }

    private void getDepth(TreeNode root, Map<Integer, Integer> map, int depth) {
        map.put(depth, root.val);
        if (root.left != null) getDepth(root.left, map, depth + 1);
        if (root.right != null) getDepth(root.right, map, depth + 1);
    }


}
