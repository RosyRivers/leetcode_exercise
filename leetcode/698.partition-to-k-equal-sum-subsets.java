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



class Solution {
    int sumArray;
    int[] bucket;
    boolean[] used;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 计算和
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) return false;
        used = new boolean[nums.length];
        sumArray = sum / k;
        // 用来存放分组结果和组内数字
        // 对数组排序
        bucket = new int[k + 1];
        return backTrack(nums, 0, k);
    }
    public boolean backTrack(int[] nums, int start, int idx) {
        if (idx == 0) return true;
        if (bucket[idx] == sumArray) {
            return backTrack(nums, 0, idx - 1);
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] == true) continue;
            if (bucket[idx] + nums[i] > sumArray) continue;
            bucket[idx] += nums[i];
            used[i] = true;
            if (backTrack(nums, i + 1, idx)) {
                return true;
            }
            bucket[idx] -= nums[i];
            used[i] = false;
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

