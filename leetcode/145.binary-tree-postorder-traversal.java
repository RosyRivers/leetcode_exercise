
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/*
 * @lc app=leetcode.cn id=145 lang=java
 * @lcpr version=30204
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (76.65%)
 * Likes:    1193
 * Dislikes: 0
 * Total Accepted:    818.5K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 
 * 输出：[3,2,1]
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
 * 输出：[4,6,7,5,2,9,8,3,1]
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
 * 树中节点的数目在范围 [0, 100] 内
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
/*      if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.left != null) stack.push(temp.left);
            if (temp.right != null) stack.push(temp.right);
        }
        Collections.reverse(result);*/
        if (root == null) return result;
        stack.push(root);
        TreeNode flag = new TreeNode();
        while(!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp != flag) {
                stack.push(flag);
                if (temp.right != null) 
                    stack.push(temp.right);
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

