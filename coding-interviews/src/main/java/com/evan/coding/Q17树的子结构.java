package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-20 11:38
 **/
public class Q17树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }


}
