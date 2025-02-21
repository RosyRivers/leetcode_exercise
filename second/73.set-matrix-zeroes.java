/*
 * @lc app=leetcode.cn id=73 lang=java
 * @lcpr version=30204
 *
 * [73] 矩阵置零
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (67.01%)
 * Likes:    1157
 * Dislikes: 0
 * Total Accepted:    487.4K
 * Total Submissions: 702K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * 示例 2：
 * 
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int[] first = new int[2];
        byte count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // 第一个为0的坐标
                if (matrix[i][j] == 0 && count == 0) {
                    // 记录
                    first[0] = i;
                    first[1] = j;
                    count = 1;
                    
                }
                else if (matrix[i][j] == 0 && count != 0) {
                    // 记录位置
                    matrix[first[0]][j] = 0;
                    matrix[i][first[1]] = 0;
                }
            }
        }
        // 进行修改
        // 遍历第一个为0的十字
        // 遍历横轴
        if (count == 0) return;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[first[0]][j] == 0 && j != first[1]) {
                // 对竖轴进行置零操作
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 遍历竖轴
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][first[1]] == 0 && i != first[0]) {
                // 对横轴置零
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 对十字置零
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][first[1]] = 0;
            
        }
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[first[0]][j] = 0;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,1,1],[1,0,1],[1,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,1,2,0],[3,4,5,2],[1,3,1,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[1]]\n
// @lcpr case=end

 */

