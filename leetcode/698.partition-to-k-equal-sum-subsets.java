/*
 * @lc app=leetcode.cn id=698 lang=java
 * @lcpr version=30204
 *
 * [698] 划分为k个相等的子集
 *
 * https://leetcode.cn/problems/partition-to-k-equal-sum-subsets/description/
 *
 * algorithms
 * Medium (41.75%)
 * Likes:    1084
 * Dislikes: 0
 * Total Accepted:    129.3K
 * Total Submissions: 304.7K
 * Testcase Example:  '[4,3,2,3,5,2,1]\n4'
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 每个元素的频率在 [1,4] 范围内
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % k != 0) return false;
        Arrays.sort(nums);
        sum = sum / k;
        if(nums[nums.length - 1] > sum) return false;
        int[] buckets = new int[k];
        Arrays.fill(buckets, sum);
        return dfs(nums,nums.length - 1, buckets, k);
    }
    boolean dfs(int[] nums, int curr, int[] buckets, int k) {
        if(curr < 0) return true;
        for(int i = 0;i < buckets.length;i++) {
            if(nums[curr] == buckets[i] || (buckets[i] - nums[curr] >= nums[0])) {
                if (i > 0 && buckets[i] == buckets[i - 1]){
                    continue;
                }
                buckets[i] -= nums[curr];
                if(dfs(nums, curr - 1, buckets, k)){
                    return true;
                }
                buckets[i] += nums[curr];
            }
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4, 3, 2, 3, 5, 2, 1]\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,1,2,2,2,2]\n2\n
// @lcpr case=end

 */

