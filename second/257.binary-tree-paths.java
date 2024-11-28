/*
 * @lc app=leetcode.cn id=257 lang=java
 * @lcpr version=30204
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode.cn/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (70.80%)
 * Likes:    1159
 * Dislikes: 0
 * Total Accepted:    419.9K
 * Total Submissions: 591.5K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 
 * 叶子节点 是指没有子节点的节点。
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [1]
 * 输出：["1"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

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
    // 回溯算法 
    private static List<String> path;
    private static List<Integer> tempPath;
    public List<String> binaryTreePaths(TreeNode root) {
        path = new ArrayList<>();
        if (root == null) return path;
        tempPath = new ArrayList<>();
        // 采用先序遍历
        preTravel(root);
        return path;
    }
    public static void preTravel(TreeNode node) {
        if (node.left == null && node.right == null) {
            // 构建字符路线
            StringBuilder buPath = new StringBuilder();
            for (int i = 0; i < tempPath.size(); i++) {
                buPath.append(tempPath.get(i));
                buPath.append("->");
            }
            buPath.append(node.val);
            path.add(buPath.toString());
            return;
        }
        tempPath.add(node.val);
        if (node.left != null) preTravel(node.left);
        if (node.right != null) preTravel(node.right);
        tempPath.remove(tempPath.size() - 1);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,null,5]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

