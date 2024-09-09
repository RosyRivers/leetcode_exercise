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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    
        // 确定退出条件
        // if (postorder.length == 0) return null;
        // // 获取后序遍历的最后一个节点,就是当前节点
        // int root = postorder[postorder.length - 1];
        // TreeNode node = new TreeNode(root);
        // if (postorder.length == 1) return node;
        // int[] leftI = new int[0];
        // int[] rightI = new int[0];
        // int[] leftP = new int[0];
        // int[] rightP = new int[0];
        // // 切割中序数组
        // for (int i = 0; i < inorder.length; i++) {
        //    //  System.out.printf("%d ", inorder[i]);
        //     if (root == inorder[i]) {
        //         leftI = Arrays.copyOfRange(inorder, 0, i);
        //         rightI = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        //     }    
        // }
        // postorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);
        // // 切割后序数组

        // leftP = Arrays.copyOfRange(postorder, 0, leftI.length);
        // rightP = Arrays.copyOfRange(postorder, leftI.length, postorder.length);
        // node.left = buildTree(leftI, leftP);
        // node.right = buildTree(rightI, rightP);
        // return node;
    Map<Integer, Integer> map;  // 方便根据数值查找位置
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder,  0, inorder.length, postorder,0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, 
                            int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex,
                            postorder, postBegin, postBegin + lenOfLeft);
        root.right = findNode(inorder, rootIndex + 1, inEnd,
                            postorder, postBegin + lenOfLeft, postEnd - 1);
        return root;
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
// [7,11,2,3,5,13,8,4,1]\n[7,2,11,3,13,1,4,8,5]\n
// @lcpr case=end

 */

