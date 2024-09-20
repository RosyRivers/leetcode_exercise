/*
 * @lc app=leetcode.cn id=452 lang=java
 * @lcpr version=30204
 *
 * [452] 用最少数量的箭引爆气球
 *
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/
 *
 * algorithms
 * Medium (51.59%)
 * Likes:    1008
 * Dislikes: 0
 * Total Accepted:    307.2K
 * Total Submissions: 590.4K
 * Testcase Example:  '[[10,16],[2,8],[1,6],[7,12]]'
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend]
 * 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足
 * xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 
 * 
 * 示例 1：
 * 
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 
 * 示例 2：
 * 
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 
 * 示例 3：
 * 
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * 
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= points.length <= 10^5
 * points[i].length == 2
 * -2^31 <= xstart < xend <= 2^31 - 1
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int arroy = points.length;
        // 按照左区间进行排序
        Arrays.sort(points,(first,second) -> {
            if (first[0] - second[0] != 0)
                return Integer.compare(first[0], second[0]);
            else return Integer.compare(first[1], second[1]);
        });
        // for (int i = 0; i < points.length; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         System.out.printf("%d ",points[i][j]);
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < points.length - 1;) {
            // 判断是否发生前一个区间的右区间与当前区间的左区间重叠
            int j = i + 1;
            int[] cover = points[i];
            while (j < points.length && points[j][0] <= cover[1] && cover[1] >= cover[0]) {
                // System.out.printf("前一个区间[%d,%d], 后一个区间[%d,%d]， ",
                //     points[i][0], points[i][1],points[j][0], points[j][1]);
                // System.out.println();
                // 覆盖区间的左区间为后一个区间的左边界，右区间为前一个的右边界
                cover[0] = points[j][0];
                if (points[i][1] > points[j][1]) cover[1] = points[j][1];
                else cover[1] = points[i][1];
                arroy --;
                j ++;
            }
            i = j;
        }
        return arroy;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [[10,16],[2,8],[1,6],[7,12]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[3,4],[5,6],[7,8]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2],[2,3],[3,4],[4,5]]\n
// @lcpr case=end

// @lcpr case=start
// [[-2147483646,-2147483645],[2147483646,2147483647]]\n
// @lcpr case=end

// @lcpr case=start
// [[9,15],[6,17]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]\n
// @lcpr case=end

// @lcpr case=start
// [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]\n
// @lcpr case=end
 */

