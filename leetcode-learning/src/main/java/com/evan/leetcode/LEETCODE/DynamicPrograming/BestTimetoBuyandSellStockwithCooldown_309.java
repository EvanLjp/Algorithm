package com.evan.leetcode.LEETCODE.DynamicPrograming;

/**
 * Created by asus on 2018/2/18.
 */
public class BestTimetoBuyandSellStockwithCooldown_309 {
    /**
     * 状态:未持有,持有
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(prices==null||length==0) return 0;
        int[] sell=new int[length];
        int[] buy=new int[length];
        sell[0]=0;
        buy[0]=-prices[0];
        for (int i = 1; i < length; i++) {
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],(i>1?sell[i-2]:0)-prices[i]);
        }
        return sell[length-1];
    }





}
