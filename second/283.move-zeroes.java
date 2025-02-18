/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30204
 *
 * [283] 移动零
 *
 * https://leetcode.cn/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (63.56%)
 * Likes:    2548
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 2.6M
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [0]
 * 输出: [0]
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：你能尽量减少完成的操作次数吗？
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针
        int zero = 0, non_zero = 0;
        while (non_zero < nums.length) {

            if (nums[zero] == 0 && nums[non_zero] == 0) 
               zero --;
            else if (nums[zero] == 0 && nums[non_zero] != 0) {
                nums[zero] = nums[non_zero];
                nums[non_zero] = 0;
            }
            zero ++;
            non_zero ++;
        }
        
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

