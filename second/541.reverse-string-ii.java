/*
 * @lc app=leetcode.cn id=541 lang=java
 * @lcpr version=30204
 *
 * [541] 反转字符串 II
 *
 * https://leetcode.cn/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (57.46%)
 * Likes:    603
 * Dislikes: 0
 * Total Accepted:    289.9K
 * Total Submissions: 504.3K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 
 * 
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] string = s.toCharArray();
        // 左闭右开
        int left = 0, right = k;
        while (left < string.length) {
            if (right > string.length) right = string.length;
            swap(string, left, right);
            left += 2 * k;
            right += 2 * k;
        }
        return String.valueOf(string);
    }

    public void swap(char[] s, int begin, int end) {
        int sum = begin + end;
        for (int i = begin; i < sum / 2; i++) {
            char temp = s[i];
            int right = (sum) - i - 1;
            s[i] = s[right];
            s[right] = temp;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcdefg"\n2\n
// @lcpr case=end

// @lcpr case=start
// "abcd"\n2\n
// @lcpr case=end

// @lcpr case=start
// "abcd"\n4\n
// @lcpr case=end

// @lcpr case=start
// "abcdefg"\n8\n
// @lcpr case=end

 */

