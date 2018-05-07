package GetOffers;

/**
 * Created by asus on 2018/4/8.
 */
public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            count++;
            n=(n-1)&n;
        }
        return count;
    }
}
