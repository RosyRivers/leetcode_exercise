



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
    public static int[][] generateMatrix(int n) {
        int [][]result = new int[n][n];
        int circout = n / 2;
        int startx = 0, starty = 0;
        int counter = 1;
        int offset = 1;
        while (circout > 0) {
            // top
            for (int j = starty; j < n - offset; j++) {
                result[startx][j] = counter++;
                starty = j;
            }
            starty++;
            // right
            for (int i = startx; i < n - offset; i++) {
                result[i][starty] = counter++;
                startx = i;
            }
            startx++;
            // bottle
            for (int j = starty; j > offset - 1; j--) {
                result[startx][j] = counter++;
                starty = j;
            }
            starty--;
            // left
            for (int i = startx; i > offset - 1 ; i--) {
                result[i][starty] = counter++;
                startx = i;
            }
            starty ++;
            circout --;
            offset ++;
        }
        if (n % 2 == 1) result[n/2][n/2] = counter;
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

 */

