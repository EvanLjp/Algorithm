package GetOffers;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 14:42
 */
public class Q39_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int [] array) {
        int store=array[0];
        for (int i = 0,times=0; i < array.length; i++) {
            if(times==0){
                store=array[i];
                times=1;
                continue;
            }
            times=array[i]==store?times+1:times-1;
        }
        int times=0;
        for (int val:array){
            if(val==store) times++;
        }

        return times>array.length/2?store:0;



    }
}
