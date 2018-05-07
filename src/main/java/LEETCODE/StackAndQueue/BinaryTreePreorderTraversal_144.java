package LEETCODE.StackAndQueue;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/1/27.
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        traversal(root,list);
        return list;


    }

    private void traversal(TreeNode root, List<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }




}
