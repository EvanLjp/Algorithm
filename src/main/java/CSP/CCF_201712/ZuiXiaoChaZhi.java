package CSP.CCF_201712;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/1.
 */
public class ZuiXiaoChaZhi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int length = scanner.nextInt();
        int[]arr=new int[length];
        for (int i = 0; i < length; i++) {
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int MIN=Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            MIN=Math.min(MIN,arr[i]-arr[i-1]);
        }
        System.out.println(MIN);
    }



}
