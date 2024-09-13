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
    List<String> result;
    StringBuilder path;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;
        path = new StringBuilder();
        backtracking(digits, 0);
        return result;


    }
    // 获取数字键对应的字母
    public char[] transnum(int val) {
        int n = 3;
        if (val == 7 || val == 9) n = 4;
        char[] cha = new char[n];
        if (val < 8) {
            for (int i = 0; i < cha.length; i++) {
                cha[i] = (char) ((val - 2) * 3 + 97 + i);
            }
        }
        else {
            for (int i = 0; i < cha.length; i++) {
                cha[i] = (char) ((val - 2) * 3 + 98 + i);
            }
        }
        return cha;
    }

    public void backtracking(String digits, int start) {
        // 递归结束条件，也是递归深度
        if (path.length() == digits.length()) {
            result.add(new String(path.toString()));
            return;
        }
        // 递归逻辑
        
        char[] cha = transnum(Character.getNumericValue(digits.charAt(start)));
        for (int i = 0; i < cha.length; i++) {
            path.append(cha[i]);
            backtracking(digits, start + 1);
            path.setLength(path.length() - 1);
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

