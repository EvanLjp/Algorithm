package com.evan.interviews;

import GetOffers.some_used_class.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/3/21.
 */
public class Q7_重建二叉树 {
    private Map<Integer,Integer> map=new HashMap<>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return createTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    private TreeNode createTree(int[] pre, int[] in, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight||inLeft>inRight) return null;
        TreeNode treeNode=new TreeNode(pre[preLeft]);
        Integer index = map.get(pre[preLeft]);
        int leftSize=index-inLeft;
        treeNode.left=createTree(pre,in,preLeft+1,preLeft+leftSize,inLeft,index-1);
        treeNode.right=createTree(pre,in,preLeft+leftSize+1,preRight,index+1,inRight);
        return treeNode;
    }


    @Test
    public void test(){
        int[]pre={1,2,4,7,3,5,6,8};
        int []in={4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
    }


}
