/*
 * @lc app=leetcode.cn id=437 lang=java
 * @lcpr version=30204
 *
 * [437] 路径总和 III
 *
 * https://leetcode.cn/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (47.55%)
 * Likes:    1996
 * Dislikes: 0
 * Total Accepted:    386K
 * Total Submissions: 811.7K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9 <= Node.val <= 10^9 
 * -1000 <= targetSum <= 1000 
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int count;
    private static HashMap<Long, Integer> map;
    private static long sum;

    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        sum = 0;
        count = 0;
        map.put(sum, 1);
        midTravel(root, targetSum);
        return count;
    }
    public static void midTravel(TreeNode node, int targetSum) {
        if (node == null) return;
        int curVal = node.val;
        sum += curVal;
        long diff = sum - targetSum;
        if (map.containsKey(diff)) {
            count += map.get(diff);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        midTravel(node.left, targetSum);
        midTravel(node.right, targetSum);
        // 回溯
        map.put(sum, map.get(sum) - 1);
        sum -= curVal;
    }

}

// @lc code=end



/*
// @lcpr case=start
// [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

// @lcpr case=start
// [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]\n0\n
// @lcpr case=end

 */

