/*
 * @lc app=leetcode.cn id=110 lang=java
 * @lcpr version=30204
 *
 * [110] 平衡二叉树
 *
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (58.49%)
 * Likes:    1546
 * Dislikes: 0
 * Total Accepted:    644.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，判断它是否是 平衡二叉树  
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 输入：root = []
 * 输出：true
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
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
    public boolean isBalanced(TreeNode root) {
        // 后序遍历，判断左右字数高度

        if (root == null) return true;
        int left = afterTravel(root.left);
        int right = afterTravel(root.right);
        if (left - 1 > right || right - 1 > left || right < 0 || left < 0) 
            return false;
        else return true;
    }

    // 后序遍历
    public static int afterTravel(TreeNode node) {
        if (node == null) return 0;
        int left = afterTravel(node.left);
        int right = afterTravel(node.right);
        if (left - 1 > right || right - 1 > left || right < 0 || left < 0) 
            return -1;
        else return Math.max(left, right) + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,3,3,null,null,4,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,6,null,8]\n
// @lcpr case=end

 */

