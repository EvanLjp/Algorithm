package com.evan.interviews;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/8 20:21
 */
public class Q10_3_变态跳台阶 {
    public int JumpFloorII(int target) {
        if(target<=2) {
            return target;
        }
        int[]arr=new int[target+1];
        arr[1]=1;
        arr[2]=2;
        for (int i = 3; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                arr[i]+=arr[j];
            }
            arr[i]++;
        }
        return arr[target];
    }
}
