/*
 * @lc app=leetcode.cn id=139 lang=java
 * @lcpr version=30204
 *
 * [139] 单词拆分
 *
 * https://leetcode.cn/problems/word-break/description/
 *
 * algorithms
 * Medium (55.74%)
 * Likes:    2592
 * Dislikes: 0
 * Total Accepted:    658.9K
 * Total Submissions: 1.2M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 
 * 
 * 示例 2：
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 字符串为背包, 字典为物品
        // dp[i] 为true表示字符串s[0,i]出现在字典中
        // dp[j] = if s[i,j] in wordDict and dp[i] == true
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> dict = new HashSet<>(wordDict.size() * 2);
        for (String string : wordDict) {
            dict.add(string);
        }
        dp[0] = true;
        // 先遍历背包
        // i 表示末尾位置
        for (int i = 1; i <= s.length(); i++) {
            // j表示起始位置
            for (int j = 0; j < i; j++) {
                if (dict.contains(s.substring(j, i)) && dp[j] == true) {
                    dp[i] = true;
                }
            }
            
        }
        return dp[s.length()];

    }
}
// @lc code=end



/*
// @lcpr case=start
// "leetcode"\n["leet", "code"]\n
// @lcpr case=end

// @lcpr case=start
// "applepenapple"\n["apple", "pen"]\n
// @lcpr case=end

// @lcpr case=start
// "catsandog"\n["cats", "dog", "sand", "and", "cat"]\n
// @lcpr case=end

// @lcpr case=start
// "ab"\n["a", "b"]\n
// @lcpr case=end

// @lcpr case=start
// "aaaaaaa"\n["aaaa","aaa"]\n
// @lcpr case=end

 */

