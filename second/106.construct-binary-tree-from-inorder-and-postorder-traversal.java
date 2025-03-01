/*
 * @lc app=leetcode.cn id=106 lang=java
 * @lcpr version=30204
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (72.23%)
 * Likes:    1260
 * Dislikes: 0
 * Total Accepted:    412.7K
 * Total Submissions: 569.8K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder
 * 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, postorder, 0, postorder.length);

    }

    public static TreeNode build(int[] inorder, int beginIn, 
                                int[] postorder, int beginPost, int length) {
        if (length <= 0) return null;
        // 构造当前节点所需的两个数组长度一定相同
        int nodeVal = postorder[beginPost + length - 1];
        // 递归退出条件
        TreeNode node = new TreeNode(nodeVal);
        if (length == 1) {
            return node;
        }
        // 每次递归的变量
        int mid = getIndexByVal(inorder, nodeVal);
        // System.out.println("当前遍历节点为：" + nodeVal);
        int leftLength = mid - beginIn;
        int rightLength = length - leftLength - 1;
        // 左子树
        node.left = build(inorder, beginIn, postorder, beginPost, leftLength);
        node.right = build(inorder, mid + 1, postorder, beginPost + leftLength, rightLength);
        return node;

    }

    public static int getIndexByVal(int[] num, int val) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == val) return i;
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [9,3,15,20,7]\n[9,15,7,20,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

// @lcpr case=start
// [2,1]\n[2,1]\n
// @lcpr case=end

 */

