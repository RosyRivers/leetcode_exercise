/*
 * @lc app=leetcode.cn id=242 lang=java
 * @lcpr version=30204
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode.cn/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (66.64%)
 * Likes:    928
 * Dislikes: 0
 * Total Accepted:    802K
 * Total Submissions: 1.2M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 * 
 * 
 * 
 * 
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            hash[index] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            hash[index] --;
        }
        for (int i : hash) {
            if (i != 0) return false;
        }
        return true;

    }
}
// @lc code=end



/*
// @lcpr case=start
// "anagram"\n"nagaram"\n
// @lcpr case=end

// @lcpr case=start
// "rat"\n"car"\n
// @lcpr case=end

 */

