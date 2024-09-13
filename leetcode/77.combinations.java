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
    List<List<Integer>> result;
    List<Integer> raw;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        raw = new ArrayList<>();
        backtracking(n, k, 1);
        return result;


    }

    public void backtracking(int n,int k,int start) {
        if (raw.size() == k) {
            List<Integer> temp = new ArrayList<>(raw);
            result.add(temp);
            return;
        }
        for (int i = start; i <= n - k + raw.size() + 1; i++) {
            raw.add(i);
            backtracking(n, k, i + 1);
            raw.removeLast();
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

