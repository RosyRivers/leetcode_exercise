/*
 * @lc app=leetcode.cn id=322 lang=java
 * @lcpr version=30204
 *
 * [322] 零钱兑换
 *
 * https://leetcode.cn/problems/coin-change/description/
 *
 * algorithms
 * Medium (48.52%)
 * Likes:    2898
 * Dislikes: 0
 * Total Accepted:    915.4K
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 
 * 你可以认为每种硬币的数量是无限的。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 
 * 示例 2：
 * 
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 
 * 示例 3：
 * 
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i]表示容量为i时，放满背包所需的最少硬币个数
        if (coins.length == 1) {
            if (amount % coins[0] != 0) return -1;
        }
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j] <= 0) dp[j] = dp[j - coins[i]] + 1;
                else
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                // System.out.printf("%d ", dp[j]);
            }
            // System.out.println();
            
        }
        if (dp[amount] == Integer.MAX_VALUE - 1) return -1;
        return dp[amount];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1, 2, 5]\n11\n
// @lcpr case=end

// @lcpr case=start
// [2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,5,10,1]\n27\n
// @lcpr case=end

// @lcpr case=start
// [186,419,83,408]\n6249\n
// @lcpr case=end

// @lcpr case=start
// [384,324,196,481]\n285\n
// @lcpr case=end

 */

