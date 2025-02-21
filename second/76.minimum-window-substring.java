/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30204
 *
 * [76] 最小覆盖子串
 *
 * https://leetcode.cn/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (45.87%)
 * Likes:    3128
 * Dislikes: 0
 * Total Accepted:    712.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 。
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 
 * 
 * 示例 3:
 * 
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * ^m == s.length
 * ^n == t.length
 * 1 <= m, n <= 10^5
 * s 和 t 由英文字母组成
 * 
 * 
 * 
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return new String();
        int[] tmap = new int[58];
        int[] smap = new int[58];
        int ans = Integer.MAX_VALUE;
        String strans = new String();
        for (int i = 0; i < t.length(); i++) {
            tmap[t.charAt(i) - 'A'] ++;
            
        }
        for (int i = 0; i < t.length(); i++) {
            // 如果这个字符存在t中，就加入smap中
            if (tmap[s.charAt(i) - 'A'] != 0)
                smap[s.charAt(i)- 'A'] ++;
        }
        int left = 0, right = left + t.length();
        // 判断两个map是否相同
        if (Arrays.equals(tmap, smap)) return s.substring(left, right);
        for (; right < s.length(); right++) {
            // 窗口滑动
            // 两个map不相同，右边界右移
            // 如果右边界这个字符在t中，就在smap中+1
            if (tmap[s.charAt(right) - 'A'] != 0)
                smap[s.charAt(right) - 'A'] ++;
            // s中超出一个字符或者这个字符不在t中，左边界右移
            while (left <= right - t.length() && (smap[s.charAt(left) - 'A'] > tmap[s.charAt(left) - 'A'] 
            || tmap[s.charAt(left) - 'A'] == 0)) {
                if (smap[s.charAt(left) - 'A'] > 0)
                    smap[s.charAt(left) - 'A'] --;
                left ++;
            }
            // 如果相同则记录
            if (isEqual(smap, tmap)) {
                int len = right - left + 1;
                // System.out.printf("len:%d\n", len);
                if (len < ans) {
                    ans = len;
                    strans = s.substring(left, right + 1);
                }   
            }
            //System.out.printf("left:%d, right:%d, str:%s\n", left, right, s.substring(left, right + 1));
            
        }
        return strans;
        
    }
    // 其中的a为s，b为t
    public static boolean isEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < b.length; i++) {
            if (a[i] < b[i]) return false;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

// @lcpr case=start
// "aaaaaaaaaaaabbbbbcdd"\n"abcdd"\n
// @lcpr case=end

 */

