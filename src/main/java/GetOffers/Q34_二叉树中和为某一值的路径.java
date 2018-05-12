package GetOffers;

import GetOffers.some_used_class.TreeNode;

import java.util.ArrayList;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 9:25
 */
public class Q34_二叉树中和为某一值的路径 {

    private ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null) return lists;
        findContainPath(root,target,new ArrayList<Integer>());
        return lists;
    }

    private void findContainPath(TreeNode root, int target, ArrayList<Integer> integers) {
        if(root==null) return;
        integers.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null) {
            lists.add(new ArrayList<>(integers));
        }
        findContainPath(root.left,target,integers);
        findContainPath(root.right,target,integers);
        integers.remove(integers.size()-1);
    }


}
