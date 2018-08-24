package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;
import com.sun.accessibility.internal.resources.accessibility;

import java.util.ArrayList;

/**
 * @author :evan
 * @date :2018-08-20 16:08
 **/
public class Q24二叉树中和为某一值的路径 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList arrayList = new ArrayList();
        getRes(arrayList, new ArrayList<Integer>(), root, target);
        return arrayList;
    }

    private void getRes(ArrayList list, ArrayList temp, TreeNode root, int target) {
        if (root == null) {
            return;
        }

        target -= root.val;
        temp.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(temp));
        }
        getRes(list, temp, root.left, target);
        getRes(list, temp, root.right, target);
        temp.remove(temp.size() - 1);


    }


}
