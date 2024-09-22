/*
 * @lc app=leetcode.cn id=738 lang=java
 * @lcpr version=30204
 *
 * [738] 单调递增的数字
 *
 * https://leetcode.cn/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (50.91%)
 * Likes:    480
 * Dislikes: 0
 * Total Accepted:    130.3K
 * Total Submissions: 255K
 * Testcase Example:  '10'
 *
 * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
 * 
 * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 10
 * 输出: 9
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 1234
 * 输出: 1234
 * 
 * 
 * 示例 3:
 * 
 * 输入: n = 332
 * 输出: 299
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 0 <= n <= 10^9
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        StringBuilder result = new StringBuilder(num);
        int start = result.length();
        for (int i = num.length() - 2; i >= 0; i--) {
            if (result.charAt(i) > result.charAt(i + 1)) {
                result.setCharAt(i, (char) (result.charAt(i) - 1));
                start = i + 1;
            }
        }
        for (int i = start; i < result.length(); i++) {
            result.setCharAt(i, '9');
        }
        return Integer.parseInt(result.toString());
    }

}
// @lc code=end



/*
// @lcpr case=start
// 10\n
// @lcpr case=end

// @lcpr case=start
// 1234\n
// @lcpr case=end

// @lcpr case=start
// 332\n
// @lcpr case=end

// @lcpr case=start
// 100\n
// @lcpr case=end

 */

