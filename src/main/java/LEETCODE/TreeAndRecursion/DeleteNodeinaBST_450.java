package LEETCODE.TreeAndRecursion;

import org.junit.Test;

/**
 * Created by asus on 2018/2/6.
 */
public class DeleteNodeinaBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.val = delMin(root.right,root,false);
        }
        return root;
    }

    private int delMin(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root.left == null) {
            if(isLeft) parent.left=root.right;
            else  parent.right=root.right;
            return root.val;
        }
        else return delMin(root.left,root,true);
    }

    @Test
    public void test() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a8 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a8;
        System.out.println(deleteNode(a1,3));


    }

}
