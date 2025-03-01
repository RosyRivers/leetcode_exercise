/*
 * @lc app=leetcode.cn id=74 lang=java
 * @lcpr version=30204
 *
 * [74] 搜索二维矩阵
 *
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 *
 * algorithms
 * Medium (50.74%)
 * Likes:    1016
 * Dislikes: 0
 * Total Accepted:    509.8K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3'
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * 
 * 
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 
 * 
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int starty = 0, endy = matrix[0].length - 1;
        boolean[] flag = new boolean[matrix.length];
        while (x >= 0 && x < matrix.length) {
            if (matrix[x][0] > target) {
                if (flag[x] == true) return false;
                flag[x] = true;
                x --;
            }
            else if (matrix[x][matrix[0].length - 1] < target) {
                if (flag[x] == true) return false;
                flag[x] = true;
                x ++;
            }
            // 在这一行进行搜索
            else {
                if (flag[x] == true) return false;
                flag[x] = true;
                int mid = (starty + endy) / 2;
                while (matrix[x][mid] != target && starty <= endy) {
                    if (matrix[x][mid] < target) {
                        starty = mid + 1;
                        mid = (endy + starty) / 2;
                    }
                    else if (matrix[x][mid] > target) {
                        endy = mid - 1;
                        mid = (endy + starty) / 2;
                    }
                }
                if (matrix[x][mid] == target) return true;
                return false;
            }
            starty = 0; endy = matrix[0].length - 1;
            
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3\n
// @lcpr case=end

// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n13\n
// @lcpr case=end

 */

