package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/3/21.
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (array[start]>=array[end]) {
            if(end-start==1) break;
            int mid = (start + end) / 2;
            if (array[start] == array[mid] && array[mid] == array[end]) {
                return searchMIN(array);
            }
            if (array[mid] >= array[start]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return array[end];
    }

    private int searchMIN(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }

    @Test
    public void test(){
        int []arr={1,2,3,4,5};
        System.out.println(minNumberInRotateArray(arr));


    }


}
