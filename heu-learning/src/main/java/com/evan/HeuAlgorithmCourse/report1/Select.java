package com.evan.HeuAlgorithmCourse.report1;

import java.util.HashMap;
import java.util.Scanner;

import static HeuAlgorithmCourse.report1.MergeSort.merge;
import static HeuAlgorithmCourse.report1.TestHelper.Partation;
import static HeuAlgorithmCourse.report1.TestHelper.swap;

/**
 * Created by asus on 2017/11/29.
 */
public class Select {
    /**
     * 线性时间选择
     *
     * @param arr 待选数组
     * @param k   选择序数
     * @return 选择元素
     */
    public static int select(Integer[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    /**
     * 线性时间选择
     *
     * @param arr 待选数组
     * @param p   左边界
     * @param r   右边界
     * @param k   选择序数
     * @return 选择元素
     */
    private static int select(Integer[] arr, int p, int r, int k) {
        //剩余元素小于75,进行正常排序,取值,返回
        if (r - p < 75) {
            merge(arr, p, r);
            return arr[p + k - 1];
        }
        //进行五个一组排序,并且把中位数调整到数组起始位置部分
        for (int i = 0; i <= (r - p - 4) / 5; i++) {
            merge(arr, p + i * 5, p + i * 5 + 4);
            swap(arr, p + i, p + i * 5 + 2);
        }
        //取中位数的中位数
        int index = select(arr, p, p + (r - p - 4) / 5, (r - p - 4) / 10);
        int i = p;
        while (arr[i] != index) i++;
        swap(arr, p, i);
        //按照中位数的中位数进行划分,小于等于,大于三部分
        HashMap partation = Partation(arr, p, r);
        int leftIndex = (int) partation.get("left");
        int rightIndex = (int) partation.get("right");
        //如果要找的数字处于小于部分,接着递归在前部分找
        if (k <= leftIndex - p + 1) return select(arr, p, leftIndex, k);
            //如果要找的数字处于大于部分,接着递归在后部分找
        else if (k >= rightIndex - p + 1) return select(arr, rightIndex, r, p + k - rightIndex);
            //如果要找的部分在等于部分,就在这个部分随意取一个返回就可以
        else return arr[leftIndex + 1];

    }

    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        System.out.println("请输入一个n个数(选择的元素个数),区间起始数,区间终止数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        Integer[] array = TestHelper.generateRandomArray(num, begin, end);
        System.out.println("请输入你要选择第几个数字");
        int index = scanner.nextInt();
        long starttime = System.currentTimeMillis();
        int select = select(array, index);
        long endtime = System.currentTimeMillis();
        System.out.println("你选择的数字是:" + select);
        System.out.println("花费:" + (endtime - starttime) + "ms");
    }
}
