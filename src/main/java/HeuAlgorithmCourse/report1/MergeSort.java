package HeuAlgorithmCourse.report1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asus on 2017/11/29.
 */
public class MergeSort {

    /**
     * 归并排序
     *
     * @param arr
     */
    public static void mergeSort(Integer[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序
     *
     * @param arr 要排序的数组
     * @param l   数组左边界
     * @param r   数组右边界
     */
    public static void merge(Integer[] arr, int l, int r) {
        //如果左边界大于右边界，直接返回
        if (l >= r) return;
        //取中间索引
        int mid = (l + r) / 2;
        //merge左边部分
        merge(arr, l, mid);
        //merge右边部分
        merge(arr, mid + 1, r);
        //merge后如果左边部分最后一个小于右边部分第一个说明已经有序,不需要归并,如果
        if (arr[mid] > arr[mid + 1]) {
            //开额外空间,拷贝原始数组
            Integer[] range = Arrays.copyOfRange(arr, l, r + 1);
            int left = l;//左边部分起始元素
            int right = mid + 1;//右边部分起始元素
            for (int i = l; i <= r; i++) {
                if (left > mid) {
                    //如果左边都归并结束,归并右边
                    arr[i] = range[right - l];
                    right++;
                } else if (right > r) {
                    //如果右边都归并结束,归并左边
                    arr[i] = range[left - l];
                    left++;
                } else if (range[left - l] > range[right - l]) {
                    //左边元素大于右边元素,归并右边元素
                    arr[i] = range[right - l];
                    right++;
                } else {
                    //右边元素大于左边元素,归并左边元素
                    arr[i] = range[left - l];
                    left++;
                }
            }
        }
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
        TestHelper.testSort("HeuAlgorithmCourse.report1.MergeSort", "mergeSort", array);
    }

}
