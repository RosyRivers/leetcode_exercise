/*
 * @lc app=leetcode.cn id=59 lang=java
 * @lcpr version=30204
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (70.87%)
 * Likes:    1293
 * Dislikes: 0
 * Total Accepted:    435K
 * Total Submissions: 613.9K
 * Testcase Example:  '3'
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 20
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int loop = n / 2;
        int mid = n / 2;
        int offset = 1;
        int xstart = 0;
        int ystart = 0;
        while (loop > 0) {
            // →
            for (; ystart < n - offset; ystart++) {
                result[xstart][ystart] = count++;
            }
            // ↓
            for (; xstart < n - offset; xstart++) {
                result[xstart][ystart] = count++;
            }
            // ←
            for (;  ystart >= offset; ystart --) {
                result[xstart][ystart] = count++;
            }
            // ↑
            for (; xstart >= offset; xstart--) {
                result[xstart][ystart] = count++;
            }
            loop --;
            xstart ++;
            ystart ++;
            offset++;
        }
        if (n % 2 == 1) result[mid][mid] = n*n;
        return result;

    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 5\n
// @lcpr case=end

 */

