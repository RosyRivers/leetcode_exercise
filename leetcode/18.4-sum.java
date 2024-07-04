/*
 * @lc app=leetcode.cn id=18 lang=java
 * @lcpr version=30204
 *
 * [18] 四数之和
 *
 * https://leetcode.cn/problems/4sum/description/
 *
 * algorithms
 * Medium (36.61%)
 * Likes:    1926
 * Dislikes: 0
 * Total Accepted:    600K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a],
 * nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 
 * 
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 
 * 
 * 你可以按 任意顺序 返回答案 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; k++) {
            if (nums[k] > target && nums[k] > 0) return result; // 剪枝
            if (k > 0 && nums[k] == nums[k - 1]) continue; // 去重
            System.out.println("k=" + k);
            for (int i = k + 1; i < nums.length - 2; i++) {
                int fir = nums[k] + nums[i];
                if (fir > target && fir > 0) return result; //剪枝
                if (i - 1 > k && nums[i] == nums[i-1]) continue;
                System.out.println("i=" + i);
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum > target) right -- ;
                    else if (sum < target) left ++;
                    else {
                        System.out.println("left=" + left + "\nright=" + right);
                        result.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,-1,0,-2,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,2,2]\n8\n
// @lcpr case=end

// @lcpr case=start
// [-5,-4,-3,-2,-1,0,0,1,2,3,4,5]\n0\n
// @lcpr case=end

 */

