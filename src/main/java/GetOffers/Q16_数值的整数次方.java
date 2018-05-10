package GetOffers;

import org.junit.Test;

/**
 * Created by asus on 2018/4/9.
 */
public class Q16_数值的整数次方 {
    /**
     * version 1 62ms
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if(exponent==0) return 1;
        if(base==0&&exponent<0) throw new IllegalArgumentException("分母不能为0");
        int realExponent=Math.abs(exponent);
        double res=getRes(base,realExponent);
        return exponent>0?res:1.0/res;
    }

    private double getRes(double base, int exponent) {
        int res=1;
        for (int i = 0; i < exponent; i++) {
           res*=base;
        }
        return res;
    }

    /**
     * version 2 42ms
     * @param base
     * @param exponent
     * @return
     */
    public double Power_2(double base, int exponent) {
        if(exponent==0) return 1;
        if(base==0&&exponent<0) throw new IllegalArgumentException("分母不能为0");
        int realExponent=Math.abs(exponent);
        double res=getRes_2(base,realExponent);
        return exponent>0?res:1.0/res;
    }

    private double getRes_2(double base, int realExponent) {
        if(realExponent==0) return 1;
        double res=getRes_2(base,realExponent>>1);
        res*=res;
        res=(realExponent&1)==1?res*base:res;
        return res;

    }

    @Test
    public void test(){
        System.out.println(Power_2(2,3));
    }


}
