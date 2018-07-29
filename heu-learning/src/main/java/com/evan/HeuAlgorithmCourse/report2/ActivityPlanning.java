package com.evan.HeuAlgorithmCourse.report2;

import HeuAlgorithmCourse.report1.TestHelper;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by asus on 2017/12/5.
 */
public class ActivityPlanning {

    /**
     * @param n          活动安排个数
     * @param strartTime 活动开始时间数组
     * @param endTime    活动结束时间数组(排序后)
     * @param choose     选择数组
     */
    public static void getBestPlan(int n, Integer[] strartTime, Integer[] endTime, boolean[] choose) {
        choose[0] = true;
        int j = 0;
        //选择第一个结束时间后相容,且最早结束的活动
        for (int i = 1; i < n; i++) {
            //相容
            if (strartTime[i] >= endTime[j]) {
                choose[i] = true;
                j = i;
            } else {
                //不相容
                choose[i] = false;
            }
        }
    }


    /**
     * 对结束时间排序,为了保证每个活动的开始时间结束时间,对于开始时间一并交换,最终得到排序后的数组
     *
     * @param startTime 开始时间数组
     * @param endTime   结束时间数组
     */
    public static void sort(Integer[] startTime, Integer[] endTime, int l, int r) {
        //如果左边界大于右边界，直接返回
        if (l >= r) return;
        //取中间索引
        int mid = (l + r) / 2;
        //merge左边部分
        sort(startTime, endTime, l, mid);
        //merge右边部分
        sort(startTime, endTime, mid + 1, r);
        //merge后如果左边部分最后一个小于右边部分第一个说明已经有序,不需要归并,如果
        if (endTime[mid] > endTime[mid + 1]) {
            //开额外空间,拷贝原始数组
            Integer[] range = Arrays.copyOfRange(endTime, l, r + 1);
            Integer[] range2 = Arrays.copyOfRange(startTime, l, r + 1);
            int left = l;//左边部分起始元素
            int right = mid + 1;//右边部分起始元素
            for (int i = l; i <= r; i++) {
                if (left > mid) {
                    //如果左边都归并结束,归并右边
                    endTime[i] = range[right - l];
                    startTime[i] = range2[right - l];
                    right++;
                } else if (right > r) {
                    //如果右边都归并结束,归并左边
                    endTime[i] = range[left - l];
                    startTime[i] = range2[left - l];
                    left++;
                } else if (range[left - l] > range[right - l]) {
                    //左边元素大于右边元素,归并右边元素
                    endTime[i] = range[right - l];
                    startTime[i] = range2[right - l];
                    right++;
                } else {
                    //右边元素大于左边元素,归并左边元素
                    endTime[i] = range[left - l];
                    startTime[i] = range2[left - l];
                    left++;
                }
            }
        }

    }

    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入活动数");
        int num = sc.nextInt();
        System.out.println("请输入开始时间的范围");
        int startL = sc.nextInt();
        int startR = sc.nextInt();
        System.out.println("请输入每个活动的最长时间");
        int len = sc.nextInt();
        //测试的数据对于开始时间随机生成,结束时间数组是在输入的最长时间范围内随机色一个数与开始时间相加
        Integer[] startTime = TestHelper.generateRandomArray(num, startL, startR);
        //结束时间生成规则的在开始时间的基础上加上0到用户输入的最长活动时间之间任意值作为结束时间
        Integer[] endTime = new Integer[num];
        for (int i = 0; i < num; i++) {
            endTime[i] = startTime[i] + (int) (Math.random() * len);
        }
        //活动选择数组
        boolean[] choose = new boolean[num];
        long time1 = System.currentTimeMillis();
        //对结束时间排序
        sort(startTime, endTime, 0, startTime.length - 1);

        //打印生成的所有活动,如测试影响时间,建议注释掉
        for (int i = 0; i < num; i++) {
            System.out.print(startTime[i] + "--->" + endTime[i] + "   ");
            if ((i + 1) % 5 == 0) System.out.println();
        }
        //活动规划
        long time2 = System.currentTimeMillis();
        getBestPlan(num, startTime, endTime, choose);
        long time3 = System.currentTimeMillis();
        System.out.println("======================================");
        System.out.println("活动安排:");
        int sum = 0;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (choose[i]) {
                count++;
                sum += endTime[i] - startTime[i];
                //打印安排的所有活动,如测试影响时间,建议注释掉
                System.out.print(startTime[i] + "--->" + endTime[i] + "   ");
                if (count % 5 == 0) System.out.println();
            }
        }
        System.out.println();
        System.out.println("安排活动总时间" + sum);
        System.out.println("安排活动总个数" + count);
        System.out.println("包含排序花费时间" + (time3 - time1) + "ms");
        System.out.println("不包含排序花费时间" + (time3 - time2) + "ms");
    }


}
