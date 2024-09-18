/*
 * @lc app=leetcode.cn id=55 lang=java
 * @lcpr version=30204
 *
 * [55] 跳跃游戏
 *
 * https://leetcode.cn/problems/jump-game/description/
 *
 * algorithms
 * Medium (43.33%)
 * Likes:    2865
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 2.4M
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 1;
        for (int i = 0; i < cover; i++) {
            // 如果零位于覆盖区间且不在区间末尾,就跳过
            // 获取覆盖范围
            if (cover < i + nums[i] + 1) cover = i + nums[i] + 1;
            if (cover >= nums.length) return true;
        }
        return false;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,1,1,4]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1,0,4]\n
// @lcpr case=end

// @lcpr case=start
// [2,5,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,0,8,2,0,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [5,9,3,2,1,0,2,3,3,1,0,0]\n
// @lcpr case=end

 */

