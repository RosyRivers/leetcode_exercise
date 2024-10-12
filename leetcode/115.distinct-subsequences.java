/*
 * @lc app=leetcode.cn id=115 lang=java
 * @lcpr version=30204
 *
 * [115] 不同的子序列
 *
 * https://leetcode.cn/problems/distinct-subsequences/description/
 *
 * algorithms
 * Hard (52.06%)
 * Likes:    1275
 * Dislikes: 0
 * Total Accepted:    197.5K
 * Total Submissions: 376.2K
 * Testcase Example:  '"rabbbit"\n"rabbit"'
 *
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * rabbbit
 * rabbbit
 * rabbbit
 * 
 * 示例 2：
 * 
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];

    }
}
// @lc code=end



/*
// @lcpr case=start
// "rabbbit"\n"rabbit"\n
// @lcpr case=end

// @lcpr case=start
// "rabbb"\n"rab"\n
// @lcpr case=end

// @lcpr case=start
// "babgbag"\n"bag"\n
// @lcpr case=end

 */

