/*
 * @lc app=leetcode.cn id=104 lang=java
 * @lcpr version=30204
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (77.64%)
 * Likes:    1865
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 1.8M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [1,null,2]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数量在 [0, 10^4] 区间内。
 * -100 <= Node.val <= 100
 * 
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return preTravel(root);
    }
    public static int preTravel(TreeNode node) {
        if (node == null) return 0;
        // 后序遍历           
        int i = preTravel(node.left);
        int j = preTravel(node.right);
        return 1 + Math.max(i, j);

    }
}
// 前序遍历
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
//         return preOrder(root, 1);
//     }

//     public static int preOrder(TreeNode node, int count) {
//         if (node == null) return count - 1; // 返回上一个节点的深度

//         // 处理当前节点
//         int leftDepth = preOrder(node.left, count + 1); // 前序递归访问左子节点
//         int rightDepth = preOrder(node.right, count + 1); // 前序递归访问右子节点

//         return Math.max(leftDepth, rightDepth); // 返回更大的深度
//     }
// }

// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2]\n
// @lcpr case=end

 */

