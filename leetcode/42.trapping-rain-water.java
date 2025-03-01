/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30204
 *
 * [42] 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (63.69%)
 * Likes:    5348
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.7M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        // 左侧最高=max(上一个状态最高，上一个最高)
        // maxLift[i] = max(maxLift[i-1],height[i-1])
        int[] maxLift = new int[height.length];
        // 右侧最高 = max(maxRight[i - 1], height[i - 1])
        int[] maxRight = new int[height.length];
        for (int i = 1; i < maxLift.length - 1; i++) {
            maxLift[i] = Math.max(maxLift[i - 1], height[i - 1]);
        }
        for (int i = maxRight.length - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < maxRight.length - 1; i++) {
            int min = Math.min(maxLift[i], maxRight[i]);
            int count = min - height[i];
            if (count > 0) sum += count;
        }
        return sum;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

