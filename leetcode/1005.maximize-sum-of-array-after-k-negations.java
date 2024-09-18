/*
 * @lc app=leetcode.cn id=1005 lang=java
 * @lcpr version=30204
 *
 * [1005] K 次取反后最大化的数组和
 *
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 *
 * algorithms
 * Easy (51.21%)
 * Likes:    464
 * Dislikes: 0
 * Total Accepted:    184.8K
 * Total Submissions: 359.1K
 * Testcase Example:  '[4,2,3]\n1'
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 
 * 
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 
 * 
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 
 * 
 * 示例 3：
 * 
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -100 <= nums[i] <= 100
 * 1 <= k <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;


class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序：先把负数处理了
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length && k > 0; i++) { // 贪心点, 通过负转正, 消耗尽可能多的k
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 退出循环, k > 0 || k < 0 (k消耗完了不用讨论)
        if (k % 2 == 1) { // k > 0 && k is odd：对于负数：负-正-负-正
            Arrays.sort(nums); // 再次排序得到剩余的负数，或者最小的正数
            nums[0] = -nums[0];
        }
        // k > 0 && k is even，flip数字不会产生影响: 对于负数: 负-正-负；对于正数：正-负-正 

        int sum = 0;
        for (int num : nums) { // 计算最大和
            sum += num;
        }
        return sum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,3]\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,-1,0,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [2,-3,-1,5,-4]\n2\n
// @lcpr case=end

// @lcpr case=start
// [4,-5,4,-5,9,4,5]\n1\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n1\n
// @lcpr case=end
 */

