package HeuAlgorithmCourse.report2;

import HeuAlgorithmCourse.report1.TestHelper;

import java.util.Scanner;

/**
 * Created by asus on 2017/11/22.
 */
public class Package_DynamicProgramming {

    /**
     * 动态规划求0-1背包问题
     *
     * @param val    价值数组
     * @param weight 重量数组
     * @param C      容量
     * @return
     */
    public static int[][] packageForChoose(Integer val[], Integer weight[], int C) {
        //取元素个数
        int num = weight.length;
        //初始化矩阵,注意java初始化为0
        int[][] res = new int[num + 1][C + 1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= C; j++) {
                //如果装不进去,就取相同重量时少一个物品的最优解
                if (j < weight[i - 1]) res[i][j] = res[i - 1][j];
                else {
                    //如果装的进取,就分别比较不装和装哪个更好,不装取相同重量下少一个元素的最优解,装取少一个元素能装的进的最优解加上此物价值
                    res[i][j] = Math.max(res[i - 1][j - weight[i - 1]] + val[i - 1], res[i - 1][j]);
                }

            }

        }
        return res;
    }

    /**
     * res结果反推选择结果
     *
     * @param res    结果矩阵
     * @param choose 选择矩阵
     * @param weight 重量矩阵
     */
    public static void printPlan(int[][] res, boolean[] choose, Integer[] weight) {
        int j = res[1].length - 1;
        for (int i = res.length - 1; i > 0; ) {
            if (res[i][j] == res[i - 1][j]) {
                i--;
            } else {
                choose[i] = true;
                j = j - weight[i - 1];
                i--;
            }
        }
    }

//NOTICE:下面主函数用到了TestHelper类,如果实验包结构发生变化,可能下方代码会报错
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入元素个数");
        int num = sc.nextInt();
        System.out.println("请输入重量范围");
        int weightL = sc.nextInt();
        int weightR = sc.nextInt();
        System.out.println("请输入价值范围");
        int valL = sc.nextInt();
        int valR = sc.nextInt();
        System.out.println("请输入容量");
        int C = sc.nextInt();
        System.out.println("我们将为你生成" + num + "个价值在" + valL + "~" + valR + "之间,重量在" + weightL + "~" + weightR + "之间的元素");
        Integer[] weight = TestHelper.generateRandomArray(num, weightL, weightR);
        Integer[] value = TestHelper.generateRandomArray(num, valL, valR);
        long start = System.currentTimeMillis();
        int[][] res = packageForChoose(value, weight, C);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
        System.out.println("最大价值是" + res[num][C]);
        //下方代码为打印存在,如测试时间建议注掉
        boolean[] choose = new boolean[num + 1];
        printPlan(res, choose, weight);
        for (int i = 1; i <= num; i++) {
            if (choose[i] == true) {
                System.out.print("重量:"+weight[i - 1] + "---价值:" + value[i - 1] + "   ");
            }
            if(i%5==0){
                System.out.println();
            }
        }


    }
}
