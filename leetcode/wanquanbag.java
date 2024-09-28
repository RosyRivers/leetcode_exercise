import java.util.Scanner;

public class wanquanbag {

    public static void main(String[] args) {
        try (// 处理输入
        Scanner in = new Scanner(System.in)) {
            int kind = in.nextInt();
            int bagSpace = in.nextInt();
            int[] weight = new int[kind];
            int[] value = new int[kind];
            for (int i = 0; i < kind; i++) {
                weight[i] = in.nextInt();
                value[i] = in.nextInt();
            }
            int[][] dp = new int[kind][bagSpace + 1];
            // 初始化
            if (weight[0] <= bagSpace)
                dp[0][weight[0]] = value[0];
            for (int i = weight[0] + 1; i <= bagSpace; i++) {
                if (i % weight[0] == 0)
                    dp[0][i] = value[0] + dp[0][i - 1];
                else dp[0][i] = dp[0][i - 1];
            }

            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j <= bagSpace; j++) {
                    // dp表示容量为j的背包，在前i个物品中的最大容量
                    // dp[i][j] = 不加入i时容量为j的背包价值 --- 加入i时容量为j的背包价值
                    if (j >= weight[i])
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
                    else dp[i][j] = dp[i - 1][j];
                    // System.out.printf("%d ", dp[i][j]);
                }
                // System.out.println();
            }
            // for (int i = 0; i < dp.length; i++) {
            //     for (int j = 0; j <= bagSpace; j++) {
            //         System.out.printf("%d ", dp[i][j]);
            //     }
            //     System.out.println();
            // }
            System.out.println(dp[kind - 1][bagSpace]);
        }

    }
}