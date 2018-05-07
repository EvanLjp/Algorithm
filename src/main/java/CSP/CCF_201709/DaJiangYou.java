package CSP.CCF_201709;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/6.
 */
public class DaJiangYou {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int money = scanner.nextInt();
        int a=money/50*7;
        int b=(money%50)/30*4;
        int c=money%50%30/10;
        System.out.println(a+b+c);
    }

}
