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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> numList = new ArrayList<>();
        Travel(root, result, numList);
        return result;
        
    }
    public static void Travel(TreeNode node, List<String> result, List<Integer> numList) {
        numList.add(node.val);
        if (node.left == null && node.right == null) {
           StringBuilder path = new StringBuilder();
           for (int i = 0; i < numList.size() - 1; i++) {
                path.append(numList.get(i));
                path.append("->");
           }
           path.append(numList.get(numList.size() - 1));
           result.add(path.toString());
           numList.removeLast();
        }
        else if (node.left != null && node.right == null) {
            Travel(node.left, result, numList);
            numList.removeLast();

        }
        else if (node.right != null && node.left == null) {
            Travel(node.right,result,numList);
            numList.removeLast();
        }
        else {
            Travel(node.left, result, numList);
            Travel(node.right,result,numList);
            numList.removeLast();
        }
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

