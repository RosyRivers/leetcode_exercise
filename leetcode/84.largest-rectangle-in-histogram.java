/*
 * @lc app=leetcode.cn id=84 lang=java
 * @lcpr version=30204
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (45.86%)
 * Likes:    2806
 * Dislikes: 0
 * Total Accepted:    458.5K
 * Total Submissions: 988.6K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入： heights = [2,4]
 * 输出： 4
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= heights.length <=10^5
 * 0 <= heights[i] <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[heights.length+1] = 0;
        newHeight[0] = 0;
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] >= newHeight[i]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = newHeight[mid];
                    res = Math.max(res, w*h);
                }
                
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,5,6,5,7]\n
// @lcpr case=end

// @lcpr case=start
// [2,4]\n
// @lcpr case=end

 */

