package GetOffers;

/**
 * Created by asus on 2018/4/9.
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        int tempExponent;
        double cur=base,res;
        if(exponent>0){
            tempExponent=exponent;
        }else {
            if(base==0) throw new RuntimeException("分母不能为0");
            else tempExponent=-exponent;
        }
        res=PowerPostive(base,tempExponent);
        return exponent>0?res:1/res;
    }

    private double PowerPostive(double base, int exponent) {
        if(exponent==0) return 1;
        if(exponent==1) return base;
        double res=PowerPostive(base,exponent>>1);
        res*=res;
        if((exponent&1)==1) res*=base;
        return res;
    }


}
