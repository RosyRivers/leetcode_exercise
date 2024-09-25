import java.util.Scanner;

public class beibaowenti {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int kind = in.nextInt();
            int bagSpace = in.nextInt();
            int[] dataSize = new int[kind];
            int[] valueData = new int[kind];
            for (int i = 0; i < dataSize.length; i++) {
                dataSize[i] = in.nextInt();
            }
            for (int i = 0; i < valueData.length; i++) {
                valueData[i] = in.nextInt();
            }
            int maxValue = dynamicProcessor(bagSpace, dataSize, valueData);
            System.out.println(maxValue);
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    // dp[i][c]，i表示第i个物品，c表示背包容量
    // dp[i][c],表示在遍历到第i个物品时在最大容量限制下的背包最大价值
    public static int dynamicProcessor(int bagSpace, int[] dataSize, int[] valueData) {
        int[][] dp = new int[dataSize.length + 1][bagSpace + 1];
        // 对物品进行遍历
        for (int i = 1; i < dp.length; i++) {
            // 在容量为c的情况下
            for (int c = 1; c < dp[0].length; c++) {
                if (c >= dataSize[i - 1] )
                    dp[i][c] = Math.max(dp[i - 1][c], dp[i - 1][c - dataSize[i - 1]] + valueData[i - 1]);
                else dp[i][c] = dp[i - 1][c];
            }
        }
        return dp[dataSize.length][bagSpace];
    }
    
}
