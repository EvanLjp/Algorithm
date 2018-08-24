package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

/**
 * @author :evan
 * @date :2018-08-22 16:16
 **/
public class Q59二叉搜索树的第k个结点 {

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
