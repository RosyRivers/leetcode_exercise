/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=30204
 *
 * [77] 组合
 *
 * https://leetcode.cn/problems/combinations/description/
 *
 * algorithms
 * Medium (77.02%)
 * Likes:    1666
 * Dislikes: 0
 * Total Accepted:    770.1K
 * Total Submissions: 996.5K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 
 * 你可以按 任何顺序 返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 示例 2：
 * 
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> union;
    static List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        union = new ArrayList<>();
        res = new ArrayList<>();
        backtrack(1, n, k);
        return res;
    }

    public static void backtrack(int idx, int n, int k) {
        // 递归退出条件
        if (union.size() >= k) {
            // 存入结果
            res.add(new ArrayList<>(union));
            return;
        }
        // 迭代遍历：
        for (int i = idx; i <= n; i++) {
            // 记录当前数字
            union.add(i);
            backtrack(i + 1, n, k);
            union.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n2\n
// @lcpr case=end

// @lcpr case=start
// 1\n1\n
// @lcpr case=end

 */

