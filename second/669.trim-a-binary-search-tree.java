/*
 * @lc app=leetcode.cn id=669 lang=java
 * @lcpr version=30204
 *
 * [669] 修剪二叉搜索树
 *
 * https://leetcode.cn/problems/trim-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (67.03%)
 * Likes:    956
 * Dislikes: 0
 * Total Accepted:    173K
 * Total Submissions: 257.9K
 * Testcase Example:  '[1,0,2]\n1\n2'
 *
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树
 * 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * 
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数在范围 [1, 10^4] 内
 * 0 <= Node.val <= 10^4
 * 树中每个节点的值都是 唯一 的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 10^4
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return midTravel(root, low, high);

    }
    // 中序遍历
    public static TreeNode midTravel(TreeNode node, int low, int high) {
        // 递归条件
        if (node == null) return node;
        // 判断是否超出边界
        if (node.val > high) {
            return midTravel(node.left, low, high);
        }
        else if (node.val < low) {
            return midTravel(node.right, low, high);
        }
        // 当前节点的值在范围内
        else {
            node.left = midTravel(node.left, low, high);
            node.right = midTravel(node.right, low, high);
            return node;
        }

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,2]\n1\n2\n
// @lcpr case=end

// @lcpr case=start
// [3,0,4,null,2,null,null,1]\n1\n3\n
// @lcpr case=end

 */

