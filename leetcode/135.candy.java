/*
 * @lc app=leetcode.cn id=135 lang=java
 * @lcpr version=30204
 *
 * [135] 分发糖果
 *
 * https://leetcode.cn/problems/candy/description/
 *
 * algorithms
 * Hard (48.86%)
 * Likes:    1561
 * Dislikes: 0
 * Total Accepted:    350.8K
 * Total Submissions: 719.9K
 * Testcase Example:  '[1,0,2]'
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 
 * 
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 
 * 
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 
 * 
 * 示例 2：
 * 
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * ⁠    第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == ratings.length
 * 1 <= n <= 2 * 10^4
 * 0 <= ratings[i] <= 2 * 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] leftcap = new int[ratings.length];
        int[] rightcap = new int[ratings.length];
        leftcap[0] = 1;
        for (int j = 1; j < ratings.length; j++) {
            if (ratings[j] > ratings[j - 1]) leftcap[j] = leftcap[j - 1] + 1;
            else leftcap[j] = 1;
            // System.out.println(leftcap[j]);
       }
       rightcap[ratings.length - 1] = leftcap[ratings.length - 1];
       int sum = rightcap[ratings.length - 1];
        for (int j2 = ratings.length - 2; j2 >= 0; j2--) {
            if (ratings[j2] > ratings[j2 + 1]) {
                rightcap[j2] = Math.max(rightcap[j2 + 1] + 1, leftcap[j2]);
            }
            else rightcap[j2] = Math.max(1, leftcap[j2]);
            // System.out.println(rightcap[j2]);
            sum += rightcap[j2];
       }
       return sum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,3,2,2,1]\n
// @lcpr case=end
 */

