package GetOffers;

import GetOffers.some_used_class.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 11:31
 */
public class Q37_序列化二叉树 {
    private String deserializeStr;
    String Serialize(TreeNode root) {
        if(root==null) return "#";
        return root.val+" "+Serialize(root.left)+" "+Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        deserializeStr=str;
       return Deserialize();
    }

    private TreeNode Deserialize() {
        int index=deserializeStr.indexOf(" ");
        String val=index==-1?deserializeStr:deserializeStr.substring(0,index);
        deserializeStr=index==-1?"":deserializeStr.substring(index+1);
        if(val.equals("#"))return null;
        TreeNode treeNode=new TreeNode(Integer.parseInt(val));
        treeNode.left=Deserialize();
        treeNode.right=Deserialize();
        return treeNode;
    }


    private TreeNode getTreeNode(String string) {
        if(string.equals("#")) return null;
        return new TreeNode(Integer.parseInt(string));
    }


}
