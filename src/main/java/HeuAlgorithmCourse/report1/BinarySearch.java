package HeuAlgorithmCourse.report1;

import java.util.Scanner;

/**
 * Created by asus on 2017/11/29.
 */
public class BinarySearch {
    /**
     * 二分查找
     *
     * @param arr   有序的数组
     * @param key   选择的元素
     * @param start 数组起始索引
     * @param end   数组结束索引
     * @return 要选择元素所在位置
     */
    public static int binarySearch(Integer[] arr, int key, int start, int end) {
        //取中间索引
        int mid = (end - start) / 2 + start;
        //如果起始值大于结束值,说明没有找到,返回-1
        if (start > end) return -1;
            //如果key大于中间位置值说明在后半段,于是递归后半段
        else if (arr[mid] == key) return mid;
        else if (key > arr[mid]) return binarySearch(arr, key, mid + 1, end);
            //如果key小于中间位置值说明在前半段,于是递归前半段
        else if (key < arr[mid]) return binarySearch(arr, key, start, mid - 1);
        //中间索引元素值等于key返回,当前索引位置
        return 0;

    }

    /**
     * 打印数组,5个一换行
     *
     * @param arr 要打印的数组
     */
    public static void print(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "     ");
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        System.out.println("请输入一个n个数(选择的元素个数),区间起始数,区间终止数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int begin = scanner.nextInt();
        int end = scanner.nextInt();
        Integer[] array = TestHelper.generateRandomArray(num, begin, end);
        System.out.println("================================================");
        //打印生成数组
        print(array);
        System.out.println("================================================");
        QuickSort.quickSort(array);
        //打印排序后数组
        print(array);
        System.out.println("================================================");
        System.out.println("请输入查找的数字");
        int val = scanner.nextInt();
        long starttime = System.currentTimeMillis();
        int index = binarySearch(array, val, 0, array.length - 1);
        long endtime = System.currentTimeMillis();
        System.out.println("你要找的数字在第" + (index + 1) + "个");
        System.out.println("花费:" + (endtime - starttime) + "ms");

    }
}
