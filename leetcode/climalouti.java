import java.util.Scanner;

public class climalouti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int top = in.nextInt();
        int m = in.nextInt();
        // dp[j] 表示爬到阶数为i的楼梯时所需要的方法数
        // j表示楼梯阶数
        // i表示一次爬几个台阶
        int[] dp = new int[top + 1];
        dp[0] = 1;
        for (int j = 0; j <= top; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i)
                    dp[j] += dp[j - i];
            }
        }
        System.out.println(dp[top]);
    }
}
