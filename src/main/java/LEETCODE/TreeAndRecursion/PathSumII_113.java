package LEETCODE.TreeAndRecursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by asus on 2018/2/5.
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> solution = new LinkedList<>();
        getPathSum(res, solution, root, sum);
        return res;
    }

    private void getPathSum(List<List<Integer>> res, List<Integer> solution, TreeNode root, int sum) {

        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                solution.add(root.val);
                res.add(new ArrayList<>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }
        solution.add(root.val);
        getPathSum(res, solution, root.left, sum - root.val);
        getPathSum(res, solution, root.right, sum - root.val);
        solution.remove(solution.size() - 1);


    }


}
