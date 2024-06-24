/*
 * @lc app=leetcode.cn id=704 lang=java
 * @lcpr version=30204
 *
 * [704] 二分查找
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 左闭右闭
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle;
        while (start <= end) {
            middle = ((end - start) >> 1) + start;
            if(target == nums[middle]) 
                return middle;
            else if(target > nums[middle]) 
                start = middle + 1;
            else if(target < nums[middle])
                end = middle - 1;
        }
        return -1 ;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,0,3,5,9,12]\n9\n
// @lcpr case=end

// @lcpr case=start
// [-1,0,3,5,9,12]\n2\n
// @lcpr case=end

 */

