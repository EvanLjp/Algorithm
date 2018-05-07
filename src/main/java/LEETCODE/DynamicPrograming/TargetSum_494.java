package LEETCODE.DynamicPrograming;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by asus on 2018/2/22.
 */
public class TargetSum_494 {
    /**
     * 124ms 记忆化搜索
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int value = nums[0];
        int length = nums.length;
        Map<String, Integer> map = new HashMap<>();
        return getRes(nums, 0, S, map);
    }

    private int getSum(int[]nums,int index){
        int sum=0;
        for (int i = index; i <nums.length ; i++) {
            sum+=nums[i];
        }
        return sum;
    }
    private int getRes(int[] nums, int index, int target, Map<String, Integer> map) {
        if (index == nums.length) {
            if (target == 0) return 1;
            return 0;
        }
        if(Math.abs(target)>getSum(nums,index)) return 0;
        String key = String.valueOf(index) + "_" + String.valueOf(target);
        if (map.containsKey(key)) return map.get(key);
        int res = getRes(nums, index+1, target + nums[index], map) + getRes(nums, index+1, target-nums[index], map);
        map.put(key, res);
        return res;
    }

    /**
     *动态规划34ms
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays_2(int[] nums, int S) {
        int length = nums.length;
        int sum=0;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
        }
        if (sum < Math.abs(S)) {
            return 0;
        }
        int [][]map=new int[length][2*sum+1];
        if(nums[0]==0) {
            map[0][sum]=2;
        }else {
            map[0][sum-nums[0]]=1;
            map[0][sum+nums[0]]=1;
        }
        for (int i = 1; i < length; i++) {

            for (int j = 0; j <= 2*sum; j++) {
                if(j+nums[i]<=2*sum){
                    map[i][j]+=map[i-1][j+nums[i]];
                    printArr(map);
                }
                if(j-nums[i]>=0){
                    map[i][j]+=map[i-1][j-nums[i]];
                    printArr(map);
                }

            }


        }
        return map[length-1][sum+S];
    }

    private void printArr(int[][]map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("============");
    }

    @Test
    public void test() {
        int[] arr = {1,1,1,1,1};
        System.out.println(findTargetSumWays_2(arr, 3));
    }

}
