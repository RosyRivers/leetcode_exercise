
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=454 lang=java
 * @lcpr version=30204
 *
 * [454] 四数相加 II
 *
 * https://leetcode.cn/problems/4sum-ii/description/
 *
 * algorithms
 * Medium (64.55%)
 * Likes:    1011
 * Dislikes: 0
 * Total Accepted:    283.1K
 * Total Submissions: 438.4K
 * Testcase Example:  '[1,2]\n[-2,-1]\n[-1,2]\n[0,2]'
 *
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l)
 * 能满足：
 * 
 * 
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) +
 * (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) +
 * (-1) + 0 = 0
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hash1 = new HashMap<>();
        int counter = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int firstsum = i + j;
                hash1.put(firstsum, hash1.getOrDefault(firstsum, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                if (hash1.containsKey((0 - i - j))) counter += hash1.get(0 - i -j);
            }
        }
        return counter;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2]\n[-2,-1]\n[-1,2]\n[0,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n[0]\n[0]\n
// @lcpr case=end

 */

