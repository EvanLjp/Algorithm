package CSP.CCF_201709;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/8.
 */
public class TongXinWangLuoDFS {
    private static List<List<Integer>> graph=new ArrayList<>(1005);
    private static boolean[][]know;
    private static int numbers;
    private static int now;
    private static boolean[]visisted;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numbers = scanner.nextInt();
        int lines = scanner.nextInt();
        for (int i = 0; i < numbers; i++) {
            graph.add(new ArrayList<>());
        }
        know=new boolean[numbers][numbers];
        for (int i = 0; i < lines; i++) {
            graph.get(scanner.nextInt()-1).add(scanner.nextInt()-1);
        }
        for (int i = 0; i < numbers; i++) {
            visisted=new boolean[numbers];
            now=i;
            dfs(i);
        }
        int count=0;
        for (int i = 0; i < numbers; i++) {
            for (int j = 0; j < numbers; j++) {
                if(!know[i][j]) {
                    break;
                }
                if(j==numbers-1) count++;
            }

        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        know[now][i]=know[i][now]=visisted[i]=true;
        for (int j:graph.get(i)){
            if(!visisted[j]) dfs(j);
        }
    }



}
