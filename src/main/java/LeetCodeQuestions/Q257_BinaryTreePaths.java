package LeetCodeQuestions;

import LEETCODE.StackAndQueue.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/4/16 16:38
 */
public class Q257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new LinkedList<>();
        getRes(root,list,"");
        return list;
    }

    private void getRes(TreeNode root, List<String> list, String s) {
        if(root==null) return;
        s=s.equals("")?s:s+"->";
        if(root.left==null&&root.right==null) {
            list.add(s+root.val);
        }else {

            getRes(root.left,list,s+root.val);
            getRes(root.right,list,s+root.val);
        }
    }


}
