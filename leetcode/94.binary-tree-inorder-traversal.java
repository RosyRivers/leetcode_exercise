/*
 * @lc app=leetcode.cn id=94 lang=java
 * @lcpr version=30204
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.90%)
 * Likes:    2131
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 2M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：root = [1]
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
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;





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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
/*      TreeNode next = root;
        while (next != null || !stack.isEmpty()) {
            if (next != null) {
                stack.push(next);
                next = next.left;
            }
            else {
                next = stack.pop();
                result.add(next.val);
                next = next.right;
            }
        }   
*/
        if (root == null) return result;
        stack.push(root);
        TreeNode flag = new TreeNode();
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp != flag) {
                // 先弹出父节点，防止重复入栈
                stack.pop();
                if (temp.right != null)
                    stack.push(temp.right);
                stack.push(temp);
                stack.push(flag);
                if (temp.left != null)
                    stack.push(temp.left);
            }
            else {
                stack.pop();
                result.add(stack.pop().val);
            }
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
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

