package com.evan.HeuAlgorithmCourse.report1;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by asus on 2017/11/14.
 */
public class TestHelper {


    /**
     * 此函数要求输入的第一个元素为标记元素,最终会将数组分隔成小于,等于,大于三部分
     *
     * @param arr 进行分隔的数组
     * @param l   数组左边界
     * @param r   数组右边界
     * @return 返回map中存左边界截至位置, 右边界起始位置
     */
    public static HashMap Partation(Integer[] arr, int l, int r) {
        HashMap<String, Integer> map = new HashMap<>();
        //取第一个元素为标记
        Integer flag = arr[l];
        //left是左部分结束索引,right是右部分结束索引,index是当前比较的位置,初始化如下
        int left = l, right = r + 1, index = l + 1;
        while (index < right) {
            if (arr[index] > flag) {
                //如果大于索引就把元素放在后面部分,后部分索引right进行前移操作
                swap(arr, index, --right);
            } else if (arr[index] < arr[l]) {
                //如果小于索引就把元素放在前面部分,前部分索引left进行后移操作
                swap(arr, index++, ++left);
            } else {
                //如果等于索引就直接进行当前位置索引后移
                index++;
            }
        }
        //将第一个位置的标记调整到等于部分
        swap(arr, l, left--);
        //写入位置,存进map返回
        map.put("left", left);
        map.put("right", right);
        return map;
    }

    /**
     * copy数组
     *
     * @param arr
     * @return 与输入相同的数组
     */
    public static Integer[] copy(Integer[] arr) {
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 交换数组元素
     *
     * @param arr 数组
     * @param i   交换位置
     * @param j   交换位置
     */
    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成随机数组
     *
     * @param n      生成个数
     * @param rangeL 数字下界
     * @param rangeR 数字上界
     * @return 生成n个rangeL~rangeR之间数字的数组
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    /**
     * 判断数组是否有序
     *
     * @param arr 待测试数组
     * @return 测试结果有序返回true, 无效返回false
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        }
        return true;
    }

    /**
     * 测试排序,进行写文件操作,路径目前写死E:\algorithmCourse\firstCourse
     *
     * @param sortClassName 待测类名
     * @param methodName    待测方法名
     * @param arr           待测数组
     */
    public static void testSort(String sortClassName, String methodName, Integer[] arr) {

        Class sortClass = null;
        Method sortMethod = null;
        FileWriter beforeSort = null;
        FileWriter afterSort = null;

        try {
            //写原来数据
            beforeSort = new FileWriter("E:\\algorithmCourse\\firstCourse\\before" + methodName + ".txt");
            for (int i = 0; i < arr.length; i++) {
                beforeSort.write(arr[i].toString());
                beforeSort.write("  ");
            }
            beforeSort.close();
            //执行排序方法
            sortClass = Class.forName(sortClassName);
            sortMethod = sortClass.getMethod(methodName, Integer[].class);
            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();
            //打印执行时间
            System.out.println(methodName + ":" + (endTime - startTime) + "ms");
            //写新数据
            afterSort = new FileWriter("E:\\algorithmCourse\\firstCourse\\after" + methodName + ".txt");
            for (int i = 0; i < arr.length; i++) {
                afterSort.write(arr[i].toString());
                afterSort.write("  ");
            }
            afterSort.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
