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
 * Likes:    1170
 * Dislikes: 0
 * Total Accepted:    595.8K
 * Total Submissions: 1.1M
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
    public String reverseWords(String s) {
        StringBuilder ori = new StringBuilder(s);
        removeSpace(ori);
        System.out.println(ori);
        reverse(ori, 0, ori.length() - 1);
        int start = 0, end = 0;
        for (; end < ori.length(); end++) {
            if (ori.charAt(end) == ' ' || end == ori.length() - 1) {
                if (end == ori.length() - 1) reverse(ori, start, end);
                else reverse(ori, start, end - 1);
                start = end + 1;
            }
            
        }
        return ori.toString();

    }

    public static void removeSpace(StringBuilder ori) {
        int left = 0;
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) != ' ') {
                if (left != 0) ori.setCharAt(left++, ' '); // 手动添加空格
                while (i < ori.length() && ori.charAt(i) != ' ') // 使用双指针移除数组中的指定元素
                    ori.setCharAt(left++, ori.charAt(i++));
            }
        }
        ori.setLength(left);
    }

    public static void reverse(StringBuilder ori, int start, int end) {
        while (start < end) {
            char temp = ori.charAt(end);
            ori.setCharAt(end, ori.charAt(start));
            ori.setCharAt(start, temp);
            start++;end--;
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// "the sky is blue"\n
// @lcpr case=end

// @lcpr case=start
// "   hello    world    "\n
// @lcpr case=end

// @lcpr case=start
// "a good   example"\n
// @lcpr case=end

 */

