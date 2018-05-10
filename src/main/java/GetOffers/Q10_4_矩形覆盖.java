package GetOffers;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/10 15:43
 */
public class Q10_4_矩形覆盖 {
    public int RectCover(int target) {
        if (target<=2) return target;
        int tempOne=1;
        int tempAnother=2;
        int res=0;
        for (int i = 3; i <=target; i++) {
            res=tempOne+tempAnother;
            tempOne=tempAnother;
            tempAnother=res;
        }
        return res;
    }
}
