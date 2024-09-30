/*
 * @lc app=leetcode.cn id=213 lang=java
 * @lcpr version=30204
 *
 * [213] 打家劫舍 II
 *
 * https://leetcode.cn/problems/house-robber-ii/description/
 *
 * algorithms
 * Medium (45.06%)
 * Likes:    1626
 * Dislikes: 0
 * Total Accepted:    451K
 * Total Submissions: 995.6K
 * Testcase Example:  '[2,3,2]'
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 
 * 示例 3：
 * 
 * 输入：nums = [1,2,3]
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int res1 = robRange(0, nums);
        int res2 = robRange(1, nums);
        return res1 > res2 ? res1 : res2;

        

    }
    // 根据其实位置决定考虑首部还是尾部
    public int robRange(int start, int[] nums) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        if (dp.length > start + 1) dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < nums.length - 1 + start; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        if (start == 0) return dp[nums.length - 2];
        return dp[nums.length - 1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,0]\n
// @lcpr case=end
 */

