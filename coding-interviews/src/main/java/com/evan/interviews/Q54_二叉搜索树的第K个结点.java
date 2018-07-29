package com.evan.interviews;

import GetOffers.some_used_class.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/13 10:27
 */
public class Q54_二叉搜索树的第K个结点 {

    private int cnt=0;
    private TreeNode treeNode;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inorder(pRoot,k);
        return treeNode;


    }

    private void inorder(TreeNode root, int k) {
        if(root==null||cnt>=k) return;
        inorder(root.left,k);
        cnt++;
        if(cnt==k) treeNode=root;
        inorder(root.right,k);

    }
}
