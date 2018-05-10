package GetOffers;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/8 20:21
 */
public class Q10_2_跳台阶 {
    public int JumpFloor(int target) {
        if(target<=2) return target;
        int one=1;
        int two=2;
        int times=0;
        for (int i = 3; i <= target; i++) {
            times=one+two;
            one=two;
            two=times;
        }
        return times;
    }

}
