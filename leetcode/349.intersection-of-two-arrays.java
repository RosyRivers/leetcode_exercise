
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 * @lcpr version=30204
 *
 * [349] 两个数组的交集
 *
 * https://leetcode.cn/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (74.66%)
 * Likes:    914
 * Dislikes: 0
 * Total Accepted:    581.5K
 * Total Submissions: 778.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        var res = new ArrayList<Integer>();
        // if (len1 < len2) return subfunc(nums1, nums2);
        // else return subfunc(nums2, nums1);
        if (len1 < len2) len2 = len1;
        HashSet<Integer> hash = new HashSet<>((int)(len1 * 1.5));
        for (int num : nums1) {
            hash.add(num);
        }

        for (int num : nums2) {
            if (hash.contains(num)) {
                hash.remove(num);
                res.add(num);
            }
            
        }
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    // public int[] subfunc(int[] subnum, int[] num)
    // {
    //     byte[] hash = new byte[1001];
    //     ArrayList<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < num.length; i++) {
    //         int index = num[i];
    //         hash[index] = 1;
    //     }

    //     for (int i = 0; i < subnum.length; i++) {
    //         int index = subnum[i];
    //         if (hash[index] == 1) {
    //             hash[index] = 0;
    //             res.add(index);
    //         }
    //     }
    //     int[] result = new int[res.size()];
    //     for (int i = 0; i < result.length; i++) {
    //         result[i] = res.get(i);
    //     }
    //     return result;
    // }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,1]\n[2,2]\n
// @lcpr case=end

// @lcpr case=start
// [4,9,5]\n[9,4,9,8,4]\n
// @lcpr case=end

 */

