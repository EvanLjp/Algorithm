package GetOffers;

import LEETCODE.LINK.SwapNodesinPairs_24;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 8:13
 */
public class Q33_二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0) return false;
        return verify(sequence,0,sequence.length-1);

    }

    private boolean verify(int[] sequence, int first, int last) {
        if(last==first||first>last) return true;

        int root=sequence[last];
        int cur=first;

        while (sequence[cur]<root){
            cur++;
        }
        for (int i = cur; i < last; i++) {
            if(sequence[i]<root) return false;
        }
        return verify(sequence,first,cur-1)&&verify(sequence,cur,last-1);




    }


}
