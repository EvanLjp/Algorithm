package GetOffers;

/**
 * Created by 荣德水 on 2018/5/13.
 */
public class Q56_数组中只出现一次的数字 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int flag=0;
        for (int a:array){
            flag^=a;
        }
        flag&=-flag;
        for (int a:array){
            if((a&flag)==0)
                num1[0]^=a;
            else
                num2[0]^=a;
        }
    }



}
