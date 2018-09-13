import java.util.Scanner;

public class Q2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int temp = 0;
        int ans = 0;
        int times = 0;
        boolean flag = false;
        for(int i = 0; i <= n; i++){
            if(i == 0){
                temp = scanner.nextInt();
            }
            else{
                int current = -1;
                if(i != n){
                    current = scanner.nextInt();
                }
                if(current > temp) {
                    ans += current - temp;
                    if (!flag) {
                        flag = true;
                    }
                }else{
                    if(flag){
                        times += 2;
                    }
                    flag = false;
                }
                temp = current;
            }
        }
        System.out.println("ans" + ans+ "times" + times);

    }
}
