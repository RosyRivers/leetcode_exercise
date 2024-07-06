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
        int len = s.length();
        char[] ori = s.toCharArray();
        int step = 2 * k;
        for (int i = 0; i < len; i += step) {
            int left = i;
            int right = Math.min(left + k - 1, len - 1);
            
            // 进行交换
            while(left < right) {
                char temp = ori[left];
                ori[left] = ori[right];
                ori[right] = temp;
                left ++; right --;
            }
            
        }
        String res = String.valueOf(ori);
        return res;
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
// "a"\n2\n
// @lcpr case=end

 */

