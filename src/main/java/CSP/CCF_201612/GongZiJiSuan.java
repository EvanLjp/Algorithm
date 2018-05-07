package CSP.CCF_201612;

import java.util.Scanner;

/**
 * Created by asus on 2018/3/10.
 */
public class GongZiJiSuan {


    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        double money = scanner.nextDouble();
        /*if (money<=3500) System.out.println(money);
        else {
            int pay=money-3500;
            if(pay<=1455){
                System.out.println();
            }


        }*/
        double realMoney=0;
       money-=3500;
       if(money<=0){
           realMoney=money+3500;
       }else {
           if(money<=1455){
               realMoney+=3500+money/0.97;
           }else if(money<=4155){
               realMoney+=3500+1500+(money-1455)/0.9;
           }else if(money<=7755){
               realMoney+=3500+4500+(money-4155)/0.8;
           }else if(money<=27255){
                realMoney+=3500+9000+(money-7755)/0.75;
           }else if(money<=41255){
               realMoney+=3500+35000+(money-27255)/0.7;
           }else if(money<=57505){
               realMoney+=3500+55000+(money-41255)/0.65;
           }else {
               realMoney+=3500+80000+(money-57505)/0.55;
           }
       }
        System.out.println((int)realMoney);
    }

}
