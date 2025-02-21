/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (51.06%)
 * Likes:    1857
 * Dislikes: 0
 * Total Accepted:    666.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int x_start = 0, y_start = 0;
        int x_edge = matrix.length - 1, y_edge = matrix[0].length - 1;
        while (x_start <= x_edge && y_start <= y_edge) {
            int i = x_start, j = y_start;
            // →
            for (j = y_start; j <= y_edge; j++) {
                ans.add(matrix[x_start][j]);
            }
            x_start ++;
            // ↓
            for (i = x_start; i <= x_edge; i++) {
                ans.add(matrix[i][y_edge]);
            }
            y_edge --;
            if (x_start <= x_edge) {
                // ←
                for (j = y_edge; j >= y_start; j--) {
                    ans.add(matrix[x_edge][j]);
                }
                x_edge --;
            }
            if (y_start <= y_edge) {
                // ↑
                for (i = x_edge; i >= x_start; i--) {
                    ans.add(matrix[i][y_start]);
                }
                y_start ++;
            }
            
        }
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
// @lcpr case=end

 */

