/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30204
 *
 * [230] 二叉搜索树中第 K 小的元素
 *
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (78.79%)
 * Likes:    947
 * Dislikes: 0
 * Total Accepted:    473.2K
 * Total Submissions: 600.5K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 10^4
 * 0 <= Node.val <= 10^4
 * 
 * 
 * 
 * 
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历
        count = 0;
        return midTravel(root, k);

        
    }

    public int midTravel(TreeNode node, int k) {
        if (node == null) return -1;
        int left = midTravel(node.left, k);
        count ++;
        if (count == k) return node.val;
        int right = midTravel(node.right, k);
        return left == -1 ? right : left;
        

    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

