package com.evan.HeuAlgorithmCourse.report1;

import java.util.HashMap;
import java.util.Scanner;

import static com.evan.HeuAlgorithmCourse.report1.TestHelper.swap;


/**
 * Created by asus on 2017/11/29.
 */
public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(Integer[] arr) {
        quick(arr, 0, arr.length - 1);
    }

    /**
     * 三路快排
     *
     * @param arr 要排序的数组
     * @param l   数组左边界
     * @param r   数组右边界
     */
    private static void quick(Integer[] arr, int l, int r) {
        if (r <= l) return;
        //为了保证递归左右部分比较均匀,所以取一个随机数,之后交换
        int random = (int) (Math.random() * (r - l + 1) + l);
        swap(arr, l, random);
        //进行分隔,Partation详细介绍在TestHelper.Partation()中
        HashMap partation = TestHelper.Partation(arr, l, r);
        //对于前面小于标记数字的部分进行快排
        quick(arr, l, (Integer) partation.get("left"));
        //对于后面大于标记数字的部分进行快排
        quick(arr, (Integer) partation.get("right"), r);

    }

    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        System.out.println("请输入一个n个数(选择的元素个数),区间起始数,区间终止数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        Integer[] array = TestHelper.generateRandomArray(num, begin, end);
        //写文件路径是E:\algorithmCourse\firstCourse,由于运用反射,如果包名发生变化,被重命名,以下方法会因为找不到类而失效
        TestHelper.testSort("HeuAlgorithmCourse.report1.QuickSort", "quickSort", array);
    }
}
