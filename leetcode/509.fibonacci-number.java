/*
 * @lc app=leetcode.cn id=509 lang=java
 * @lcpr version=30204
 *
 * [509] 斐波那契数
 *
 * https://leetcode.cn/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (65.92%)
 * Likes:    784
 * Dislikes: 0
 * Total Accepted:    753.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '2'
 *
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 
 * 
 * 给定 n ，请计算 F(n) 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 30
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start



class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0, second = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            ans = first + second;
            first = second;
            second = ans;
        }
        return ans;
    }
    
}
// @lc code=end



/*
// @lcpr case=start
// 2\n
// @lcpr case=end

// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 30\n
// @lcpr case=end

 */

