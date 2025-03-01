/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.12%)
 * Likes:    2618
 * Dislikes: 0
 * Total Accepted:    624.1K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,1,1]\n2'
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 
 * 子数组是数组中元素的连续非空序列。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        preSum.put(sum, 1);
        for (int start = 0; start < nums.length; ++start) {
            sum += nums[start];
            int diff = sum - k;
            if (preSum.containsKey(diff)) {
                count += preSum.get(diff);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            
        }
        return count;
    }
}

// @lc code=end



/*
// @lcpr case=start
// [1,1,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n3\n
// @lcpr case=end

 */

