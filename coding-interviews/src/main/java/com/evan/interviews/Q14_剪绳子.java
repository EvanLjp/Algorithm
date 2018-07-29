package com.evan.interviews;

/**
 * DP方程:f(n)=max(f(i)*f(n-i))
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/10 19:51
 */
public class Q14_剪绳子 {
    public int integerBreak(int n) {
        if(n<=3) return n-1;
        int[]arr=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                arr[i]=Math.max(arr[i],arr[j]*arr[i-j]);
            }
        }
        return arr[n];
    }

}
