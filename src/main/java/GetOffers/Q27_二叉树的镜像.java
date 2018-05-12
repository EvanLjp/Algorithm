package GetOffers;

import GetOffers.some_used_class.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 20:54
 */
public class Q27_二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.right=left;
        root.left=right;
        Mirror(root.left);
        Mirror(root.right);

    }


}
