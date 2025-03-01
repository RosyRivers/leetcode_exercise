/*
 * @lc app=leetcode.cn id=394 lang=java
 * @lcpr version=30204
 *
 * [394] 字符串解码
 *
 * https://leetcode.cn/problems/decode-string/description/
 *
 * algorithms
 * Medium (57.77%)
 * Likes:    1876
 * Dislikes: 0
 * Total Accepted:    382.1K
 * Total Submissions: 650.6K
 * Testcase Example:  '"3[a]2[bc]"'
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 
 * 
 * 示例 4：
 * 
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300] 
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;

class Solution {
    public String decodeString(String s) {
        // 遍历过的字符，但是遇到了新的[，放入栈中
        ArrayDeque<char[]> stackString = new ArrayDeque<>();
        ArrayDeque<Integer> stackNum = new ArrayDeque<>();
        char[] string = s.toCharArray();
        StringBuffer tempS = new StringBuffer();
        int mut = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] >= '0' && string[i] <= '9') {
                mut = mut * 10 + string[i] - '0';
            }
            else if (string[i] == '[') {
                // 字符入栈操作
                stackString.push(tempS.toString().toCharArray());
                // 次数入栈
                stackNum.push(mut);
                tempS.delete(0, tempS.length());
                mut = 0;
            }
            else if (string[i] >= 'a' && string[i] <= 'z') {
                tempS.append(string[i]);
            }
            else if (string[i] == ']') {
                // 进行出栈操作
                int num = stackNum.pop();
                char[] pre = stackString.pop();
                // 设置本次递归退出得到的字符字串，并将这个字符字串作为当前字串
                StringBuffer tempStack = new StringBuffer();
                if (pre.length != 0)
                    tempStack.append(pre);
                for (int j = 0; j < num; j++) {
                    tempStack.append(tempS);
                }
                tempS = new StringBuffer(tempStack);
            }
        }
        return tempS.toString();

    }
    
}
// @lc code=end



/*
// @lcpr case=start
// "3[a]2[bc]"\n
// @lcpr case=end

// @lcpr case=start
// "3[a2[c]]"\n
// @lcpr case=end

// @lcpr case=start
// "2[abc]3[cd]ef"\n
// @lcpr case=end

// @lcpr case=start
// "abc3[cd]xyz"\n
// @lcpr case=end

// @lcpr case=start
// "3[cd]xyz"\n
// @lcpr case=end


// @lcpr case=start
// "3[ace2[cd]xy3[qwer]z]"\n
// @lcpr case=end

// @lcpr case=start
// "9[leetcode]"\n
// @lcpr case=end
 */

