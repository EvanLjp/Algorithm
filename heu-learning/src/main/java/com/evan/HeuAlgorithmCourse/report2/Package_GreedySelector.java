package com.evan.HeuAlgorithmCourse.report2;

import HeuAlgorithmCourse.report1.TestHelper;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asus on 2017/12/5.
 */
public class Package_GreedySelector {
    /**
     * 背包问题
     *
     * @param val    价值矩阵
     * @param weight 重量矩阵
     * @param C      背包容量
     * @param price  单价(已经从小到大排序)
     * @return 最大价值
     */
    public static double GreedySelector(Integer[] val, Integer[] weight, int C, Double[] price) {
        int i = val.length - 1;
        double totalValue = 0;
        while (C > 0) {
            if (weight[i] < C) {
                totalValue += val[i];
                C -= weight[i];
                i--;
            } else {
                totalValue += C * price[i];
                C = 0;
            }
        }
        return totalValue;
    }


    /**
     * 排序函数,对单价排序等同时交换另外两个数组,保证顺序
     *
     * @param weight 重量数组
     * @param value  价值数组
     * @param price  单价数组
     */
    public static void sort(Integer[] weight, Integer[] value, Double[] price, int l, int r) {
        //如果左边界大于右边界，直接返回
        if (l >= r) return;
        //取中间索引
        int mid = (l + r) / 2;
        //merge左边部分
        sort(weight, value, price, l, mid);
        //merge右边部分
        sort(weight, value, price, mid + 1, r);
        //merge后如果左边部分最后一个小于右边部分第一个说明已经有序,不需要归并,如果
        if (price[mid] > price[mid + 1]) {
            //开额外空间,拷贝原始数组
            Double[] range = Arrays.copyOfRange(price, l, r + 1);
            Integer[] range2 = Arrays.copyOfRange(weight, l, r + 1);
            Integer[] range3 = Arrays.copyOfRange(value, l, r + 1);
            int left = l;//左边部分起始元素
            int right = mid + 1;//右边部分起始元素
            for (int i = l; i <= r; i++) {
                if (left > mid) {
                    //如果左边都归并结束,归并右边
                    price[i] = range[right - l];
                    weight[i] = range2[right - l];
                    value[i] = range3[right - l];
                    right++;
                } else if (right > r) {
                    //如果右边都归并结束,归并左边
                    price[i] = range[left - l];
                    weight[i] = range2[left - l];
                    value[i] = range3[left - l];
                    left++;
                } else if (range[left - l] > range[right - l]) {
                    //左边元素大于右边元素,归并右边元素
                    price[i] = range[right - l];
                    weight[i] = range2[right - l];
                    value[i] = range3[right - l];
                    right++;
                } else {
                    //右边元素大于左边元素,归并左边元素
                    price[i] = range[left - l];
                    weight[i] = range2[left - l];
                    value[i] = range3[left - l];
                    left++;
                }
            }
        }

    }

    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入元素个数");
        int num = sc.nextInt();
        System.out.println("请输入重量范围");
        int weightL = sc.nextInt();
        int weightR = sc.nextInt();
        System.out.println("请输入价值范围");
        int valL = sc.nextInt();
        int valR = sc.nextInt();
        System.out.println("请输入容量");
        int C = sc.nextInt();
        System.out.println("我们将为你生成" + num + "个价值在" + valL + "~" + valR + "之间,重量在" + weightL + "~" + weightR + "之间的元素");
        //生成重量,价值数组
        Integer[] weight = TestHelper.generateRandomArray(num, weightL, weightR);
        Integer[] value = TestHelper.generateRandomArray(num, valL, valR);
        Double[] price = new Double[num];
        //为单价数组赋值
        for (int i = 0; i < num; i++) {
            price[i] = (double) value[i] / weight[i];
            //打印原始结果,如测试,建议注释影响时间
            System.out.print("NO."+(i+1)+":重量是"+weight[i]+",总价值是"+value[i]+",单价是"+price[i]+"            ");
            if((i+1)%3==0) System.out.println();
        }
        //执行排序
        long time1 = System.currentTimeMillis();
        sort(weight, value, price, 0, weight.length - 1);
        long time2 = System.currentTimeMillis();
        //下方代码为打印排序后数组,如测试,影响时间精度,建议注掉
        System.out.println();
        System.out.println("排序后");
        for (int i = 0; i <num ; i++) {
            System.out.print("NO."+(i+1)+":重量是"+weight[i]+",总价值是"+value[i]+",单价是"+price[i]+"            ");
            if((i+1)%3==0) System.out.println();
        }
        System.out.println();

        double totalVal = GreedySelector(value, weight, C, price);
        long time3 = System.currentTimeMillis();
        System.out.println("能装的最大价值是" + totalVal);
        System.out.println("包含排序花费时间" + (time3 - time1) + "ms");
        System.out.println("不包含排序花费时间" + (time3 - time2) + "ms");

    }


}
