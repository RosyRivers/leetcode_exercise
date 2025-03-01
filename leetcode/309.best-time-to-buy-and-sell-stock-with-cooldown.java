/*
 * @lc app=leetcode.cn id=309 lang=java
 * @lcpr version=30204
 *
 * [309] 买卖股票的最佳时机含冷冻期
 *
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (64.81%)
 * Likes:    1769
 * Dislikes: 0
 * Total Accepted:    344.6K
 * Total Submissions: 530.5K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 * 示例 2:
 * 
 * 输入: prices = [1]
 * 输出: 0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start


class Solution {
    public int maxProfit(int[] prices) {
        /**
         * dp数组第一列表示买入状态
         * 第二列表示卖出状态且不处于冷静期
         * 第三列表示今天卖出
         * 第四列表示前一天卖出，即为冷静期状态
         */
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 买入状态，为保持买入和在卖出状态中选最大值
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1] - prices[i], dp[i - 1][3] - prices[i]));
            // 卖出状态，保持卖出或者由冷静期转入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            // 今天卖出
            dp[i][2] = dp[i - 1][0] + prices[i];
            // 冷静期状态继承昨日的今天卖出状态
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1],Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

