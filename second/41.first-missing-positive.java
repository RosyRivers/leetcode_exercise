/*
 * @lc app=leetcode.cn id=41 lang=java
 * @lcpr version=30204
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode.cn/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (44.86%)
 * Likes:    2281
 * Dislikes: 0
 * Total Accepted:    487.7K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,0]'
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 * 
 * 示例 2：
 * 
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 * 
 * 示例 3：
 * 
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        byte[] flag = new byte[100001];
        for (int i : nums) {
           if (i > nums.length || i < 1) continue;
           else flag[i] = 1; 
        }
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == 0) return i;
        }
        return nums.length + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,-1,1]\n
// @lcpr case=end

// @lcpr case=start
// [7,8,9,11,12]\n
// @lcpr case=end

 */

