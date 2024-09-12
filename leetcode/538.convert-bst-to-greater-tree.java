/*
 * @lc app=leetcode.cn id=538 lang=java
 * @lcpr version=30204
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Medium (77.48%)
 * Likes:    1013
 * Dislikes: 0
 * Total Accepted:    294.1K
 * Total Submissions: 378.2K
 * Testcase Example:  '[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]'
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node
 * 的新值等于原树中大于或等于 node.val 的值之和。
 * 
 * 提醒一下，二叉搜索树满足下列约束条件：
 * 
 * 
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 
 * 
 * 注意：本题和 1038:
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * 相同
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 * 
 * 
 * 示例 3：
 * 
 * 输入：root = [1,0,2]
 * 输出：[3,3,2]
 * 
 * 
 * 示例 4：
 * 
 * 输入：root = [3,2,4,1]
 * 输出：[7,9,4,10]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数介于 0 和 10^4^ 之间。
 * 每个节点的值介于 -10^4 和 10^4 之间。
 * 树中的所有值 互不相同 。
 * 给定的树为二叉搜索树。
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
    TreeNode pre = new TreeNode(0);
    public TreeNode convertBST(TreeNode root) {

        return buildTree(root);
    }
    public TreeNode buildTree(TreeNode node) {
        if (node == null) return null;
        buildTree(node.right);
        node.val += pre.val;
        pre.val = node.val;
        buildTree(node.left);
        return node;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]\n
// @lcpr case=end

// @lcpr case=start
// [0,null,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,2]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4,1]\n
// @lcpr case=end

 */

