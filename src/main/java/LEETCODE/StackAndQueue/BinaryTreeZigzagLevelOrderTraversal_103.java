package LEETCODE.StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asus on 2018/1/28.
 */
public class BinaryTreeZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List list=new LinkedList();
        if(root==null) return list;
        Stack<TreeNode> cur=new Stack<>();
        Stack<TreeNode> next=new Stack<>();
        cur.push(root);
        boolean order=false;
        while (!cur.isEmpty()){
            List<Integer> res=new LinkedList<>();
            int size = cur.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = cur.pop();
                res.add(pop.val);
                if(order){
                    if(pop.right!=null) next.push(pop.right);
                    if(pop.left!=null) next.push(pop.left);
                }else {
                    if(pop.left!=null) next.push(pop.left);
                    if(pop.right!=null) next.push(pop.right);
                }
            }
            if (res.size() == 0) break;
            list.add(res);
            Stack temp = cur;
            cur = next;
            next = temp;
            order = !order;

        }
        return list;
    }







}
