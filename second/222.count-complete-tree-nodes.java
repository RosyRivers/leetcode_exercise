/*
 * @lc app=leetcode.cn id=222 lang=java
 * @lcpr version=30204
 *
 * [222] 完全二叉树的节点个数
 *
 * https://leetcode.cn/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Easy (81.71%)
 * Likes:    1172
 * Dislikes: 0
 * Total Accepted:    428.8K
 * Total Submissions: 523.2K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 
 * 完全二叉树
 * 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h
 * 层，则该层包含 1~ 2^h 个节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = []
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 输入：root = [1]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 * 
 * 
 * 
 * 
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
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
    public int countNodes(TreeNode root) {
        return balancedCount(root);


    }

    public static int commonCount(TreeNode node) {
        // 遍历获取左右子树的节点个数
        // 后序遍历
        if (node == null) return 0;
        int left = commonCount(node.left);
        int right = commonCount(node.right);
        return left + right + 1;

    }

    public static int balancedCount(TreeNode node) {
        // 最后一定时满二叉树 终止条件为判断是否为满二叉树
        int num = isManTree(node);
        if (num >= 0) {
            return (2 << num) - 1;
        }
        else if (num == -1) return 0;
        int left = balancedCount(node.left);
        int right = balancedCount(node.right);
        return left + right + 1;
    }

    public static int isManTree(TreeNode node) {
        if (node == null) return -1;
        int left = 0, right = 0;
        TreeNode noder = node;
        while (node.left != null) {
            node = node.left;
            left ++;
        }

        while (noder.right != null) {
            noder = noder.right;
            right ++;
        }
        if (left == right) return right;
        else return -2;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

