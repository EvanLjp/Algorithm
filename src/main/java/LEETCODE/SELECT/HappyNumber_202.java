package LEETCODE.SELECT;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by asus on 2018/1/7.
 */
public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> map=new HashSet<>();
        while (n!=1){
            if(map.contains(n))return false;
            map.add(n);
            n = getNext(n);
        }
        return true;

    }
    private int getNext(int n){
        int sum=0;
        while (n!=0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
    /*
   Unhappy numbers follow cycle -> 4, 16, 37, 58, 89, 145, 42, 20, 4...
   */
   /* public boolean isHappy(int n){
        int sum = 0;
        while(n > 0){
            int digit = n% 10;
            sum += digit * digit;
            n = n/10;
        }

        if(sum == 1){
            return true;
        }
        if(sum == 4){
            return false;
        }

        return isHappy(sum);
    }*/


}
