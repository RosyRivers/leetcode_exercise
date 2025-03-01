/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30204
 *
 * [22] 括号生成
 *
 * https://leetcode.cn/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (77.77%)
 * Likes:    3668
 * Dislikes: 0
 * Total Accepted:    896.6K
 * Total Submissions: 1.1M
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 1
 * 输出：["()"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static StringBuffer path;
    private static List<String> ans;
    private static final char[] cha = new char[]{'(', ')'};
    public List<String> generateParenthesis(int n) {
        path = new StringBuffer();
        ans = new ArrayList<>();
        generateK(n, 0, 0);
        return ans;
        
    }
    // flag = false 表示无法输入) cur = n && flag = true表示无法输入(
    public static void generateK(int n, int lcur, int rcur) {
        // 递归推出条件
        if (lcur == n && rcur == n) {
            ans.add(path.toString());
            return;
        }

        // 回溯
        if (lcur < n) {
            path.append(cha[0]);
            generateK(n, lcur + 1, rcur);
            path.deleteCharAt(path.length() - 1);
        }
        if (rcur < lcur) {
            path.append(cha[1]);
            generateK(n, lcur, rcur + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

