package GetOffers;

import org.apache.log4j.lf5.LF5Appender;
import org.junit.Test;

/**
 * Created by asus on 2018/3/21.
 */
public class Q11_旋转数组的最小数字 {
    /**
     * 顺序寻找,发现第一个小于前一个数字的数就是要找的最小的,如果找不到,就说明数组元素相同,或者最小的就是第一个,那么就返回第一个
     * 时间:O(n)
     * 空间:O(1)
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("无法找到最小元素");
        int target = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                target = array[i];
                break;
            }
        }
        return target;
    }

    /**
     * @param array
     * @return
     */
    public int minNumberInRotateArray_2(int[] array) {
        if (array == null || array.length == 0) throw new IllegalArgumentException("无法找到最小元素");
        int left = 0, right = array.length - 1;
        while (array[left] >= array[right]) {
            if (right - left == 1) break;
            int mid = left + (right - left) / 2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                return searchMIN(array,left,right);
            } else if (array[mid] >= array[left])
                left = mid;
            else right = mid;
        }
        return array[right];
    }

    private int searchMIN(int[] array ,int left,int right) {
        int target = array[left];
        for (int i = left+1; i <=right; i++) {
            if (array[i] < array[i - 1]) {
                target = array[i];
                break;
            }
        }
        return target;
    }


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minNumberInRotateArray(arr));


    }


}
