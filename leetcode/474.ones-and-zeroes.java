/*
 * @lc app=leetcode.cn id=474 lang=java
 * @lcpr version=30204
 *
 * [474] 一和零
 *
 * https://leetcode.cn/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (66.22%)
 * Likes:    1177
 * Dislikes: 0
 * Total Accepted:    228.5K
 * Total Submissions: 343.2K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 
 * 
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1
 * ，大于 n 的值 3 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 类似01背包，只是背包容量的维度上了一层。
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = new int[2];
            for (int j = 0; j < strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') count[0]++;
                else count[1] ++;
            }
            
            for (int row = m; row >= count[0]; row--) {
                for (int col = n; col >= count[1]; col--) {
                    dp[row][col] = Math.max(dp[row][col], dp[row - count[0]][col - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["10", "0001", "111001", "1", "0"]\n5\n3\n
// @lcpr case=end

// @lcpr case=start
// ["10", "0", "1"]\n1\n1\n
// @lcpr case=end

// @lcpr case=start
// ["10", "0001", "111001", "1", "0"]\n1\n1\n
// @lcpr case=end

 */

