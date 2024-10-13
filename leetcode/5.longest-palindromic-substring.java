/*
 * @lc app=leetcode.cn id=5 lang=java
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 *
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (38.43%)
 * Likes:    7381
 * Dislikes: 0
 * Total Accepted:    1.8M
 * Total Submissions: 4.7M
 * Testcase Example:  '"babad"'
 *
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "cbbd"
 * 输出："bb"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && j == i + 1) {
                    dp[i][j] = true;
                    if (right - left <= 1) {
                        right = j;
                        left = i;
                    }
                }
                else if (s.charAt(i) == s.charAt(j) && j > i + 1 && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i >= right - left) {
                        right = j;
                        left = i;
                    }
                }
            }
        }
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         System.out.printf("%b ", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        // System.out.printf("left: %d, right: %d, sum: %d ", left,right,sum);
        return s.substring(left, right + 1);
    }
}
// @lc code=end



/*
// @lcpr case=start
// "babad"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

// @lcpr case=start
// "aacabdkacaa"\n
// @lcpr case=end

// @lcpr case=start
// "aaaba"\n
// @lcpr case=end

 */

