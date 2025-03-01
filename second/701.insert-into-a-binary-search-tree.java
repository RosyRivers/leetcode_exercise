/*
 * @lc app=leetcode.cn id=701 lang=java
 * @lcpr version=30204
 *
 * [701] 二叉搜索树中的插入操作
 *
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
 *
 * algorithms
 * Medium (70.06%)
 * Likes:    578
 * Dislikes: 0
 * Total Accepted:    254.7K
 * Total Submissions: 363.6K
 * Testcase Example:  '[4,2,7,1,3]\n5'
 *
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证
 * ，新值和原始二叉搜索树中的任意节点值都不同。
 * 
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 
 * 
 * 示例 3：
 * 
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数将在 [0, 10^4]的范围内。
 * -10^8 <= Node.val <= 10^8
 * 所有值 Node.val 是 独一无二 的。
 * -10^8 <= val <= 10^8
 * 保证 val 在原始BST中不存在。
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode idx = preTravel(root, val);
        if (val < idx.val) idx.left = new TreeNode(val);
        else idx.right = new TreeNode(val);
        return root;
    }

    public static TreeNode preTravel(TreeNode node, int val) {
        // 退出条件，为叶子节点，或者要插入的位置为空
        if ((node.left == null && val < node.val) || (node.right == null && val > node.val)) 
            return node;
        //先序遍历
        TreeNode res = null;
        if (val < node.val) // 向左遍历
            res = preTravel(node.left, val);
        else // 向右遍历
            res = preTravel(node.right, val);
        return res;
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,7,1,3]\n5\n
// @lcpr case=end

// @lcpr case=start
// [40,20,60,10,30,50,70]\n25\n
// @lcpr case=end

// @lcpr case=start
// [4,2,7,1,3,null,null,null,null,null,null]\n5\n
// @lcpr case=end


// @lcpr case=start
// []\n5\n
// @lcpr case=end

 */

