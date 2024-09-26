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
    boolean[] bucket;
    boolean[] used;
    int cursum;
    int target;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        bucket = new boolean[k];
        used = new boolean[nums.length];
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) return false;
        target = sum / k;
        cursum = 0;
        return backTravel(nums, k, k - 1, 0);


    }
    public boolean backTravel(int[] nums, int k, int curBucket, int startIndex) {
        // 所有的桶装满, 这个问题得到解决
        if (curBucket < 0) return true;
        if (cursum == target) {
            cursum = 0;
            // 找到一个目标和，继续寻找剩下的目标和
            // for (boolean i : used) {
            //     System.out.printf("%b ",i);
            // }
            // System.out.println();
            if(backTravel(nums, k, curBucket - 1, 0)) return true;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 同层遍历
            if (used[i] == true) continue;
            if (cursum + nums[i] > target) continue;
            used[i] = true;
            cursum += nums[i];
            // 进入下一层
            if (backTravel(nums, k, curBucket, i + 1))
                return true;
            cursum -= nums[i];
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
// [2,2,2,2,3,4,5]\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,1,1,1,2,2,2,2]\n4\n
// @lcpr case=end
 */

