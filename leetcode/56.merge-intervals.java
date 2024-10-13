/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30204
 *
 * [56] 合并区间
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (50.17%)
 * Likes:    2423
 * Dislikes: 0
 * Total Accepted:    962K
 * Total Submissions: 1.9M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2：
 * 
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
        // 记录合并后的左边界
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> result = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 判断下一个区间的左边界是否在这个区间的有边界内
            //如果重叠，更新区间有边界，左边界不变
            if (intervals[i][0] <= right)
                right = Math.max(right, intervals[i][1]);
            // 如果不重叠，则构造数组，之后更新边界
            else {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }      
        }
        
        result.add(new int[]{left, right});
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

 */

