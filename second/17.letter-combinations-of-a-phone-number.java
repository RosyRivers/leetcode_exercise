/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (59.86%)
 * Likes:    2890
 * Dislikes: 0
 * Total Accepted:    947K
 * Total Submissions: 1.6M
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：digits = ""
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static List<String> res;
    private static StringBuffer str;
    private static List<char[]> alphabet = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        
        for (int i = 0; i < 8; i++) {
            int n = 3;
            if (i == 5 || i == 7)
                n = 4;
            char[] a = new char[n];
            int zero = 'a';
            for (int j = 0; j < a.length; j++) {
                if (i == 0) a[j] = (char) (zero + j);
                else 
                    // 获取上一轮最后一个字符
                    a[j] = (char) (alphabet.getLast()[alphabet.getLast().length - 1] + j + 1);
            }
            alphabet.add(a);
        }
        res = new ArrayList<>();
        str = new StringBuffer();
        if (digits.length() == 0) return res;
        char[] dig = digits.toCharArray();
        for (char[] c : alphabet) {
            for (int z = 0; z < c.length; z++) {
                System.out.printf("%s ", c[z]);
            }
        }
        backing(dig, 0);
        return res;

    }

    public static void backing(char[] dig, int depth) {
        // 递归退出条件
        if (depth == dig.length) {
            // 得到一个结果
            res.add(str.toString());
            return;
        }

        // 迭代次数
        char num = dig[depth];
        int numIndex = num - '2';
        char[] a = alphabet.get(numIndex);
        for (int i = 0; i < a.length; i++) {
            str.append(a[i]);
            // 递归
            backing(dig, depth + 1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

