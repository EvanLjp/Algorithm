package InterviewCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 19:51
 */
public class Alibaba_2 {




    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N = scanner.nextInt();
        int num = scanner.nextInt();
        int[] arr=new int[num];
        for (int i = 0; i < num; i++) {
            arr[i]=scanner.nextInt();
        }
        int[] sell=new int[num];
        int[] buy=new int[num];
        for (int i = 0; i < N; i++) {
            sell[i]=0;
            buy[i]=-arr[i];
        }

        for (int i = N; i < num; i++) {
            sell[i]=Math.max(sell[i-N],buy[i-N]+arr[i]);
            buy[i]=Math.max(buy[i-N],(i>N?sell[i-N-1]:0)-arr[i]);
        }

        System.out.println(sell[num-1]);



    }



}
