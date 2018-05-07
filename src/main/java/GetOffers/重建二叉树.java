package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/3/21.
 */
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return createTree(pre,in,0,pre.length-1,0,pre.length-1);



    }

    private TreeNode createTree(int[] pre, int[] in, int preLeft, int preEnd, int inLeft, int inEnd) {
        if(preLeft>preEnd) return null;
        int rootVal=pre[preLeft];
        int leftCount=0;
        for (int i = inLeft; i <=inEnd; i++) {
            if(in[i]!=rootVal) leftCount++;
            else break;
        }

        TreeNode root=new TreeNode(rootVal);
        root.left=createTree(pre,in,preLeft+1,preLeft+leftCount,inLeft,inLeft+leftCount-1);
        root.right=createTree(pre,in,preLeft+leftCount+1,preEnd,inLeft+leftCount+1,inEnd);
        return root;
    }
    @Test
    public void test(){
        int[]pre={1,2,4,7,3,5,6,8};
        int []in={4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
    }


}
