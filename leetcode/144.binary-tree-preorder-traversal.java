
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 * @lcpr version=30204
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.94%)
 * Likes:    1272
 * Dislikes: 0
 * Total Accepted:    1.1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 
 * 输出：[1,2,3]
 * 
 * 解释：
 * 
 * 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9]
 * 
 * 输出：[1,2,4,5,6,7,3,8,9]
 * 
 * 解释：
 * 
 * 
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 
 * 输出：[]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1]
 * 
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if (root != null)
            stack.push(root);
        else return result;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            result.add(stack.pop().val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return result;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,8,null,null,6,7,9]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,6,1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

