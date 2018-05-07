package LEETCODE.StackAndQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/1/27.
 */
public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        traversal(root,list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root==null) return;
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }

}
