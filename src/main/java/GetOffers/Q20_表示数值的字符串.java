package GetOffers;

import org.junit.Test;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 11:37
 */
public class Q20_表示数值的字符串 {

    public boolean isNumeric(char[] str) {
        if(str.length==0||str==null) return false;
        String pattern="[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        return new String(str).matches(pattern);
    }

    @Test
    public void test(){
        System.out.println(isNumeric(new char[]{}));
    }
}
