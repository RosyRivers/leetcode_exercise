/*
 * @lc app=leetcode.cn id=40 lang=java
 * @lcpr version=30204
 *
 * [40] 组合总和 II
 *
 * https://leetcode.cn/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (59.44%)
 * Likes:    1586
 * Dislikes: 0
 * Total Accepted:    560.4K
 * Total Submissions: 940.6K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 
 * 注意：解集不能包含重复的组合。 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    int sum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        sum = 0;
        // 升序排序保证剪枝
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;

    }

    public void backtracking(int[] candidates, int target, int start) {
        // 退出条件
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            // 去重
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,1,2,7,6,1,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2,5,2,1,2]\n5\n
// @lcpr case=end

 */

