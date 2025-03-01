public class tubuTravel {
    public static void main(String[] args) {
        System.out.println(solution(5, 2, new int[]{1, 2, 3, 3, 2}) == 9);
        System.out.println(solution(6, 3, new int[]{4, 1, 5, 2, 1, 3}) == 9);
        System.out.println(solution(4, 1, new int[]{3, 2, 4, 1}) == 10);
        System.out.println(solution(5, 3, new int[]{1, 2, 3, 3, 2}) == 7);
    }

    public static int solution(int n, int k, int[] data) {
        int[] dp = new int[data.length];
        // 初始化
        dp[0] = data[0];

        for (int i = 1; i < dp.length; i++) {
            int val = getMinInteger(i - k + 1, i, data);
            dp[i] = dp[i - 1] + val;
        }
        return dp[n - 1];
    }

    // 左闭右闭
    public static int getMinInteger(int begin, int end, int[] data) {
        if (begin < 0) begin = 0;
        int min = data[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (min > data[i]) min = data[i];
        }
        return min;
    }
}
