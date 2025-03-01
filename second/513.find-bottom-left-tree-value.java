/*
 * @lc app=leetcode.cn id=513 lang=java
 * @lcpr version=30204
 *
 * [513] 找树左下角的值
 *
 * https://leetcode.cn/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (73.20%)
 * Likes:    593
 * Dislikes: 0
 * Total Accepted:    267.4K
 * Total Submissions: 364.6K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 
 * 假设二叉树中至少有一个节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 输入: root = [2,1,3]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * ⁠
 * 
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [1,10^4]
 * -2^31 <= Node.val <= 2^31 - 1 
 * 
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
    // private List<List<Integer>> record;
    // private ArrayDeque<TreeNode> curQueue;
    private static int res; 
    private static int curDepth;
    public int findBottomLeftValue(TreeNode root) {
        // record = new ArrayList<>();
        // curQueue = new ArrayDeque<>();
        // curQueue.offer(root);
        // while (!curQueue.isEmpty()) {
        //     int size = curQueue.size();
        //     List<Integer> row = new ArrayList<>(size);
        //     for (int i = 0; i < size; i++) {
        //         TreeNode temp = curQueue.poll();
        //         row.add(temp.val);
        //         if (temp.left != null) curQueue.offer(temp.left);
        //         if (temp.right != null) curQueue.offer(temp.right);   
        //     }
        //     record.add(row);
        // }
        // return record.getLast().getFirst();
        res = root.val;
        curDepth = 1;
        preTravel(root, 1);
        return res;


    }

    public static void preTravel(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > curDepth) {
            res = node.val;
            curDepth = depth;
        }

        preTravel(node.left, depth + 1);
        preTravel(node.right, depth + 1);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,null,5,6,null,null,7]\n
// @lcpr case=end

 */

