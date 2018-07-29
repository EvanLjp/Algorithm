package com.evan.interviews;

import GetOffers.some_used_class.TreeLinkNode;

/**
 * Created by asus on 2018/3/25.
 */
public class Q8_二叉树的下一个节点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode cur=null;
        if(pNode.right!=null){
             cur=pNode.right;
            while (cur.left!=null){
                cur=cur.left;
            }
            return cur;
        }else{
            while (pNode.next!=null){
                TreeLinkNode parent = pNode.next;
                if(parent.left==pNode){
                    return parent;
                }
                pNode=pNode.next;
            }
            return null;
        }

    }


}
