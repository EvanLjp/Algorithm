package GetOffers;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q65_不用加减乘除做加法 {
    public int Add(int num1,int num2) {

        while (num2!=0){
            int a=num1^num2;
            int b=(num1&num2)<<1;
            num1=a;
            num2=b;
        }
        return num1;

    }



}
