/*
 * @lc app=leetcode.cn id=27 lang=java
 * @lcpr version=30204
 *
 * [27] 移除元素
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int i = 0;
        for (i = 0; index < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i --;
            }
        index ++;
        }
        return i;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,2,3]\n3\n
// @lcpr case=end

// @lcpr case=start
// [0,1,2,2,3,0,4,2]\n2\n
// @lcpr case=end

 */

