/*
 * @lc app=leetcode.cn id=93 lang=java
 * @lcpr version=30204
 *
 * [93] 复原 IP 地址
 *
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (59.61%)
 * Likes:    1445
 * Dislikes: 0
 * Total Accepted:    452.8K
 * Total Submissions: 752.9K
 * Testcase Example:  '"25525511135"'
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 
 * 
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * 
 * 
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能
 * 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 
 * 示例 3：
 * 
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 20
 * s 仅由数字组成
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
    List<String> path;
    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(s, 0);
        return result;

    }
    public boolean isIpAddress(String ip) {
        if (ip.charAt(0) == '0' && ip.length() != 1) return false;
        int temp = Integer.parseInt(ip);
        if (temp < 0 || temp > 255) return false;
        return true;
    }

    public void backtracking(String s, int start) {
        if (start == s.length() && path.size() == 4) {
            StringBuilder temp = new StringBuilder(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                temp.append(".");
                temp.append(path.get(i));
            }
            result.add(temp.toString());
            return;
        }
        else if (start != s.length() && path.size() > 4) return;
        for (int i = start; i < s.length(); i++) {
            if (i - start + 1 > 3) break;
            String str = s.substring(start, i + 1);
            if (!isIpAddress(str)) continue;
            path.add(str);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "25525511135"\n
// @lcpr case=end

// @lcpr case=start
// "0000"\n
// @lcpr case=end

// @lcpr case=start
// "101023"\n
// @lcpr case=end

 */

