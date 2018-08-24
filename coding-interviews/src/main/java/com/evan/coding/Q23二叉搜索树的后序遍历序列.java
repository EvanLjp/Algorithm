package com.evan.coding;

/**
 * @author :evan
 * @date :2018-08-20 15:56
 **/
public class Q23二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {

        if (last - first <= 1) {
            return true;
        }
        int root = sequence[last];
        int cur = first;
        while (cur < last && sequence[cur] <= root) {
            cur++;
        }
        for (int i = cur; i < last; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return verify(sequence, first, cur - 1) && verify(sequence, cur, last - 1);
    }


}
