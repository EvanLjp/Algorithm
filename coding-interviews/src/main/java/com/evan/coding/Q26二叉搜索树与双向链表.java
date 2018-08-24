package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-21 11:29
 **/
public class Q26二叉搜索树与双向链表 {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pre = null;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        if (head == null) {
            head = root;
        }

        inOrder(root.right);

    }


}
