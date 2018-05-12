package GetOffers;

import GetOffers.some_used_class.TreeNode;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 21:06
 */
public class Q28_对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val) return false;
        return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
    }


}
