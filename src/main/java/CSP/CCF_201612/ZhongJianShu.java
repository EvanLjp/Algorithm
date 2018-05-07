package CSP.CCF_201612;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/10.
 */
public class ZhongJianShu {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numbers = scanner.nextInt();
        int[] arr=new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        int leftIndex=0,rightIndex=numbers-1;
        boolean flag=false;
        while (arr[leftIndex]!=arr[rightIndex]) {
            if(leftIndex>rightIndex){
                flag=true;
                break;
            }

            if(arr[leftIndex+1]==arr[rightIndex]){
                leftIndex++;
            }else if(arr[rightIndex-1]==arr[leftIndex]){
                rightIndex--;
            }else{
                leftIndex++;
                rightIndex--;
            }

        }
        if (!flag&&leftIndex==numbers-1-rightIndex) System.out.println(arr[leftIndex]);
        else System.out.println(-1);

    }
}
