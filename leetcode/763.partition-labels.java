/*
 * @lc app=leetcode.cn id=763 lang=java
 * @lcpr version=30204
 *
 * [763] 划分字母区间
 *
 * https://leetcode.cn/problems/partition-labels/description/
 *
 * algorithms
 * Medium (77.07%)
 * Likes:    1195
 * Dislikes: 0
 * Total Accepted:    270.2K
 * Total Submissions: 348.7K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 
 * 返回一个表示每个字符串片段的长度的列表。
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
 * 
 * 示例 2：
 * 
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 500
 * s 仅由小写英文字母组成
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // 记录字母的最远位置
        int[] record = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // record数组索引与字母相互对应
            int index = (int)(s.charAt(i) - 'a');
            record[index] = i;
        }
        // 保存可能截取的位置
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 'a';
            // 保存位置
            if (count < record[index])
                count = record[index];
            if (i == count) {
                result.add(count + 1 - sum);
                sum += result.getLast();
                count = 0;
            }
        }
        return result;

    }
}
// @lc code=end



/*
// @lcpr case=start
// "ababcbacadefegdehijhklij"\n
// @lcpr case=end

// @lcpr case=start
// "eccbbbbdec"\n
// @lcpr case=end

 */

