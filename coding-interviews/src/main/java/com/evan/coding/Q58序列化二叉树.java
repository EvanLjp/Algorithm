package com.evan.coding;

import com.evan.interviews.some_used_class.TreeNode;

import javax.swing.*;

/**
 * @author :evan
 * @date :2018-08-22 16:06
 **/
public class Q58序列化二叉树 {

    private String string;

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";

        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        string = str;
        return deserialize();

    }

    private TreeNode deserialize() {
        int index = string.indexOf(" ");
        String val = index == -1 ? string : string.substring(0, index);
        string = index == -1 ? "" : string.substring(index + 1);
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize();
        node.right = deserialize();
        return node;


    }


}
