package com.evan.interviews;


import com.evan.interviews.some_used_class.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 11:02
 */
public class Q36_二叉搜索树与双向链表 {
    private TreeNode head;
    private TreeNode pre;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        root.left = pre;
        if (pre != null) pre.right = root;
        pre = root;
        if (head == null) {
            head = pre;
        }
        inOrder(root.right);

    }


}
