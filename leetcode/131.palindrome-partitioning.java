/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30204
 *
 * [131] 分割回文串
 *
 * https://leetcode.cn/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (73.60%)
 * Likes:    1842
 * Dislikes: 0
 * Total Accepted:    452.3K
 * Total Submissions: 611.4K
 * Testcase Example:  '"aab"'
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "a"
 * 输出：[["a"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;
    List<String> path;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        return result;
    }

    public boolean ishuiwen(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public void backtracking(String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String temp = s.substring(start,i + 1);
            if (!ishuiwen(temp)) {
                continue;
            }
            path.add(temp);
            backtracking(s, i + 1);
            path.removeLast();
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n
// @lcpr case=end

 */

