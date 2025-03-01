/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30204
 *
 * [79] 单词搜索
 *
 * https://leetcode.cn/problems/word-search/description/
 *
 * algorithms
 * Medium (47.16%)
 * Likes:    1941
 * Dislikes: 0
 * Total Accepted:    629.6K
 * Total Submissions: 1.3M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * 
 * 
 * 
 * 
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
        
//         // 读取行数和列数
//         int rows = scanner.nextInt();
//         int cols = scanner.nextInt();
//         scanner.nextLine();  // 消耗换行符
        
//         // 读取字符矩阵
//         char[][] board = new char[rows][cols];
//         for (int i = 0; i < rows; i++) {
//             String line = scanner.nextLine().trim();
//             board[i] = line.toCharArray();
//         }
        
//         // 读取目标单词
//         String word = scanner.nextLine().trim();
        
//         // 创建解决方案实例并验证
//         Selution solution = new Selution();
//         boolean result = solution.exist(board, word);
//         System.out.println(result);
//     }
    
// }

import java.util.Arrays;

class Solution {
    private static byte[][] flag;
    private static int[][] fangx = 
    new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        flag = new byte[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean ans = false;
                if (board[i][j] == word.charAt(0)) {
                    // flag[i][j] = 1;
                    ans = bfs(board, i, j, w, 1);
                    
                }
                if (ans) return true;
            }
        }
        return false;
    }

    public static boolean bfs(char[][] board, int x, int y, char[] word, int idx) {
        if (idx == word.length) return true;
        
        boolean ans = false;
        flag[x][y] = 1;
        for (int i = 0; i < fangx.length; i++) {
            // 四个方向
            int curx = x + fangx[i][0];
            int cury = y + fangx[i][1];
            // 判断当前的路是否走过
            if (curx < board.length && cury < board[0].length && curx >= 0 && cury >= 0) {
                if (flag[curx][cury] == 1) continue;
                if (board[curx][cury] == word[idx]) {
                    // 递归
                    if(bfs(board, curx, cury, word, idx + 1)) {
                        return true;
                    }
                }
            }
            // 复位
        }
        flag[x][y] = 0;
        return ans;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

// @lcpr case=start
// [["a","a"]]\n"aaa"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]\n"ABCESEEEFS"\n
// @lcpr case=end

 */

