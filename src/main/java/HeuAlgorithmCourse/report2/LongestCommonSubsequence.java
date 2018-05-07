package HeuAlgorithmCourse.report2;

import java.util.Scanner;

/**
 * Created by asus on 2017/11/22.
 */
public class LongestCommonSubsequence {
    /**
     * @param str1 输入参数1
     * @param str2 输入参数2
     * @return 返回公共子序列长度
     */
    public static String longestCommonSubsequence(String str1, String str2) {
        //求输入第一个序列的长度
        int strLength1 = str1.length();
        //求输入第二个序列的长度
        int strLength2 = str2.length();
        //如果输入序列为空或者长度为0,则直接返回0
        if (str1 == null || str2 == null || strLength1 == 0 || strLength2 == 0) return "";
        //初始化结果矩阵
        int[][] res = new int[strLength1 + 1][strLength2 + 1];
        //i的值初始化为1主要防止数组下标越界,i的结果范围是[1,strLength1]
        for (int i = 1; i < strLength1 + 1; i++) {
            //j的值初始化为1主要防止数组下标越界,j的结果范围是[1,strLength2]
            for (int j = 1; j < strLength2 + 1; j++) {
                //取字符串第i-1位置字符
                char a = str1.charAt(i - 1);
                //取字符串第j-1位置字符
                char b = str2.charAt(j - 1);
                //如果两个字符相同,说明公共子序列长度又可以原始res[i-1][j-1]上加1,
                // 比如abc和adc,前两个位置公共子序列长度是1,在比较第三个位置时,如果相同只需要在原始前两个长度上加1
                if (a == b) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                }
                //如果目前比较字符串最后一个字符不同,那么就分别看排除第一个字符串最后一个字符的序列与第二个字符串相比的子序列长度
                //再看排除第二个字符串最后一个字符的序列与第一个字符串相比的子序列长度,那个大当前位置记作哪个值
                else res[i][j] = Math.max(res[i][j - 1], res[i - 1][j]);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer print = print(res, str1, str2, strLength1, strLength2, stringBuffer);
        return print.toString();
    }

    /**
     * @param res       结果矩阵
     * @param str1      字符串1
     * @param str2      字符串2
     * @param index1    坐标1
     * @param index2    坐标2
     * @param resString 要进行拼接的字符串
     * @return 最长子序列
     */
    public static StringBuffer print(int[][] res, String str1, String str2, int index1, int index2, StringBuffer resString) {
        //如果到了坐标为0处,说明已经到了边界,进行返回
        if (index1 == 0 || index2 == 0) return resString;
        //如果该坐标点两个字符相同就说明属于最长子序列,进行拼接
        if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
            //再寻找当前子序列位置的前一个字符,需要注意为了维持原有序列顺序需要先压栈剩余子序列,把当前字符放于栈顶,以便递归结束弹栈得到正确结果
            print(res, str1, str2, index1 - 1, index2 - 1, resString);
            resString.append(str1.charAt(index1 - 1));
            //如果当前两个字符不等,那么在构件矩阵时,我们分别比较了排除第一个字符串最后一个字符的序列与第二个字符串相比的子序列长度,
            // 排除第二个字符串最后一个字符的序列与第一个字符串相比的子序列长度那个相等就打印哪个
        } else if (res[index1 - 1][index2] == res[index1][index2]) {
            print(res, str1, str2, index1 - 1, index2, resString);
        } else {
            print(res, str1, str2, index1, index2 - 1, resString);
        }
        return resString;
    }
    //NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个序列:");
        String str1 = scanner.next();
        System.out.println("请输入第二个序列:");
        String str2 = scanner.next();
        String s = longestCommonSubsequence(str1, str2);
        System.out.println("子序列长度:" + s.length());
        System.out.println("子序列" + s);
    }


}
