/*
 * @lc app=leetcode.cn id=494 lang=java
 * @lcpr version=30204
 *
 * [494] 目标和
 *
 * https://leetcode.cn/problems/target-sum/description/
 *
 * algorithms
 * Medium (48.30%)
 * Likes:    2011
 * Dislikes: 0
 * Total Accepted:    490.5K
 * Total Submissions: 1M
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * 
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 
 * 
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 
 * 
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1], target = 1
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (Math.abs(target) > sum) return 0;
        // l = (s + t) / 2
        if ((sum + target) % 2 != 0) return 0;
        int left = (sum + target) / 2;
        return dynamicPeorcessor(nums, left + 1);
    }
    public int dynamicPeorcessor(int[] nums, int cap) {
        // dp[i][c] 表示的是 可选数字为前i个时，放满容量为i的背包的方案。
        // dp[i][c] = dp[i - 1][c] + dp[i - 1][c - nums[i]]
        // ↑ 这个公式表示和为背包容量的方案 == 不加入新的数字的方案 + 加入新的数字使得背包满的方案
        int[][] dp = new int[nums.length][cap];
        if (nums[0] < cap)
        dp[0][nums[0]] = 1;
        // 对第一列进行初始化，表示当背包容量为0时，始终有一种方案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i == 0) dp[0][0] = 2;
            else if (i == 0 && nums[i] != 0) dp[i][0] = 1;
            else if (nums[i] == 0 && i != 0) dp[i][0] = 2 * dp[i - 1][0];
            else dp[i][0] = dp[i - 1][0];
            // System.out.println(dp[i][0]);
        }
        // 选择第一个物品时，如果背包容量正好等于第一个物品的重量，那么也有一种方案
        for (int i = 1; i < nums.length; i++) {
            for (int c = 1; c < cap; c++) {
                // 如果加入nums[i]没有超出背包容量
                if (c >= nums[i])
                    dp[i][c] = dp[i - 1][c - nums[i]] + dp[i - 1][c];
                else dp[i][c] = dp[i - 1][c];
            }
        }
        return dp[nums.length - 1][cap - 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1,1,1]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1000]\n-1000\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0,0,0,0,0,0,1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1]\n0\n
// @lcpr case=end

// @lcpr case=start
// [0,4,6,0,3,2,6,9,4,1]\n3\n
// @lcpr case=end

 */

