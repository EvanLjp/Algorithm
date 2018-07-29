package com.evan.interviews;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q63_股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int soFarMin = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }

}
