/*
 * @lc app=leetcode.cn id=151 lang=java
 * @lcpr version=30204
 *
 * [151] 反转字符串中的单词
 *
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (55.58%)
 * Likes:    1226
 * Dislikes: 0
 * Total Accepted:    657.6K
 * Total Submissions: 1.2M
 * Testcase Example:  '"the sky is blue"'
 *
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    // 1. 去除多余空格
    // 2. 翻转整个字符串
    // 3. 对每个单词进行翻转
    public String reverseWords(String s) {
        StringBuffer stringBuilder = new StringBuffer(s);
        removeSpace(stringBuilder);
        reverse(stringBuilder, 0, stringBuilder.length());
        reverseWord(stringBuilder);
        return stringBuilder.toString();
        
        
    }

    public void removeSpace(StringBuffer s) {
        int begin = 0;
        // 删除前面的空格
        while (s.charAt(begin) == ' ') {
            begin ++;
        }
        if (begin > 0) s.delete(0, begin);
        // 删除后面的空格
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end --;
        }
        if (end < s.length() - 1) s.delete(end + 1, s.length());
        // 删除中间的空格
        int slow = 0;
        for (int i = 0; i <= end; i++) {
            s.setCharAt(slow, s.charAt(i));
            if (s.charAt(slow) != ' ' ||(s.charAt(slow) == ' ' && s.charAt(slow - 1) != ' ')) {
                slow++;
            }
        }
        s.setLength(slow);
    }

    public void reverse(StringBuffer s, int begin, int end) {
        int sum = begin + end;
        for (int i = begin; i < (sum) / 2; i++) {
            char temp = s.charAt(i);
            int right = sum - 1 - i;
            s.setCharAt(i, s.charAt(right));
            s.setCharAt(right, temp);
        }
    }

    public void reverseWord(StringBuffer s) {
        int begin = 0, end = begin;
        while (end < s.length()) {
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }
            reverse(s, begin, end);
            begin = end + 1;
            end = begin;
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// "the sky is blue"\n
// @lcpr case=end

// @lcpr case=start
// "  hello    nihao    "\n
// @lcpr case=end

// @lcpr case=start
// " a  good   example  "\n
// @lcpr case=end

 */

