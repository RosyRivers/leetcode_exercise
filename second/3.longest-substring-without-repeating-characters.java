/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.89%)
 * Likes:    10187
 * Dislikes: 0
 * Total Accepted:    2.9M
 * Total Submissions: 7.3M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;

        // hash集合
        byte[] map = new byte[128];
        int max = 0;
        char[] str = s.toCharArray();
        for (right = 0; right < s.length(); right++) {
            // 这个字母不重复
            if (map[str[right]] == 0) {
                // map 置1：
                map[str[right]] = 1;
            }
            // 字母重复
            else {
                // 滑动窗口向右收缩
                while (str[left] != str[right]) { 
                    map[str[left]] = 0;
                    left ++;
                }
                left ++;
            }
            int curL = 1 + right - left;
            max = curL > max ? curL : max;
            
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

