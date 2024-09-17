/*
 * @lc app=leetcode.cn id=51 lang=java
 * @lcpr version=30204
 *
 * [51] N 皇后
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (74.05%)
 * Likes:    2130
 * Dislikes: 0
 * Total Accepted:    438.2K
 * Total Submissions: 589.2K
 * Testcase Example:  '4'
 *
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * 
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 
 * 
 * 
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 1
 * 输出：[["Q"]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
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
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        char[][] solve = new char[n][n];
        for (int i = 0; i < solve.length; i++) {
            Arrays.fill(solve[i], '.');
        }
        backtracking(n, 0, solve);
        return result;

    }
    public void backtracking(int n,int row, char[][] solve) {
        if (row == n) {
            Array2String(n, solve);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isVaild(n, row, solve, col)) {
                solve[row][col] = 'Q';
                backtracking(n, row + 1, solve);
                solve[row][col] = '.';
                
            }
        }
    }

    public void Array2String(int n, char[][] solve) {
        List<String> soList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            soList.add(new String(solve[i]));
        }
        result.add(soList);
    }

    public boolean isVaild(int n, int row, char[][] solve, int col) {
        if (row == 0) return true;
        // 检查列
        for (int i = 0; i < n; i++) {
            if (solve[i][col] == 'Q') return false; 
        }

        // 检查右上行
        for (int i = row, j = col; i >= 0 && j < n; i --, j ++) {
            if (solve[i][j] == 'Q') return false;
        }

        // 检查左上行
        for (int i = row, j = col; i >= 0 && j >= 0; i --, j --) {
            if (solve[i][j] == 'Q') return false;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

