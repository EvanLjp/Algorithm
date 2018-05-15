package GetOffers;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/12 20:34
 */
public class Q44_数字序列中的某一位数字 {
    public int digitAtIndex(int index) {
        if (index < 0)
            return -1;
        int digit = 1;
        while (true) {
            int amount = getAmountOfDigit(digit);
            int totalAmount = amount * digit;
            if (index < totalAmount)
                return digitAtIndex(index, digit);
            index -= totalAmount;
            digit++;
        }
    }

    /**
     * digit 位数的数字组成的字符串长度
     * 例如 digit = 2，return 90
     */
    private int getAmountOfDigit(int digit) {
        if (digit == 1)
            return 10;
        return (int) Math.pow(10, digit - 1) * 9;
    }

    /**
     * 在 digit 位数组成的字符串中，第 index 个数
     */
    private int digitAtIndex(int index, int digit) {
        int number = beginNumber(digit) + index / digit;
        int remain = index % digit;
        return (number + "").charAt(remain) - '0';
    }

    /**
     * digit 位数的起始数字
     * 例如 digit = 2 return 10
     */
    private int beginNumber(int digit) {
        if (digit == 1)
            return 0;
        return (int) Math.pow(10, digit - 1);
    }
}
