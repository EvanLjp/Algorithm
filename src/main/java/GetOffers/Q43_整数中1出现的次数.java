package GetOffers;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 20:16
 */
public class Q43_整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;

    }


}
