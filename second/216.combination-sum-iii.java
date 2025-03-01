/*
 * @lc app=leetcode.cn id=216 lang=java
 * @lcpr version=30204
 *
 * [216] 组合总和 III
 *
 * https://leetcode.cn/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (71.28%)
 * Likes:    877
 * Dislikes: 0
 * Total Accepted:    417.4K
 * Total Submissions: 584.7K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 
 * 
 * 只使用数字1到9
 * 每个数字 最多使用一次 
 * 
 * 
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 
 * 示例 3:
 * 
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 2 <= k <= 9
 * 1 <= n <= 60
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
    static int sum;
    // 递归深度为k，迭代宽度为n,且只能使用一次数字
    public List<List<Integer>> combinationSum3(int k, int n) {
        sum = 0;
        union = new ArrayList<>();
        res = new ArrayList<>();
        int depth = 0;
        backtrack(1, k, n, 0);
        return res;


    }

    public static void backtrack(int idx, int k, int targetNum, int depth) {
        // 不满足条件
        if (sum > targetNum || depth > k) {
            return;
        }
        // 满足条件退出递归
        else if (sum == targetNum && depth == k) {
            res.add(new ArrayList<>(union));
            return;
        }
        // 迭代查询
        for (int i = idx; i <= 9; i++) {
            sum += i;
            union.add(i);
            // 递归
            backtrack(i + 1, k, targetNum,depth + 1);
            sum -= i;
            union.removeLast();

        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n7\n
// @lcpr case=end

// @lcpr case=start
// 3\n9\n
// @lcpr case=end

// @lcpr case=start
// 4\n1\n
// @lcpr case=end

 */

