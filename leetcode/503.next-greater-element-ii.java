/*
 * @lc app=leetcode.cn id=503 lang=java
 * @lcpr version=30204
 *
 * [503] 下一个更大元素 II
 *
 * https://leetcode.cn/problems/next-greater-element-ii/description/
 *
 * algorithms
 * Medium (67.54%)
 * Likes:    1007
 * Dislikes: 0
 * Total Accepted:    279.1K
 * Total Submissions: 409.2K
 * Testcase Example:  '[1,2,1]'
 *
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的
 * 下一个更大元素 。
 * 
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1
 * 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * nums.length - 1; i++) {
            int index = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
                int idx = stack.pop();
                result[idx] = nums[index];
            }
            stack.push(index);
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,3]\n
// @lcpr case=end

 */

