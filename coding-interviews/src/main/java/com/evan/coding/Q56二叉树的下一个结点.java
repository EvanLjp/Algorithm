package com.evan.coding;

import com.evan.interviews.some_used_class.TreeLinkNode;

/**
 * @author :evan
 * @date :2018-08-22 15:47
 **/
public class Q56二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        } else {
            TreeLinkNode parent = pNode.next;
            while (parent!=null&&parent.left != pNode) {
                pNode = parent;
                parent = parent.next;
            }
            return parent;

        }


    }
}
