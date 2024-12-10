/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30204
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (78.66%)
 * Likes:    1553
 * Dislikes: 0
 * Total Accepted:    527.6K
 * Total Submissions: 666.4K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * 
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 按 严格递增 顺序排列
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 选取数组中间的值建立节点，然后以中间节点为界，分割两个长度相等的子数组
        // 在子数组中重复上述行为直到数组长度为1
        // 先序遍历
        return buildTreeByNum(nums, 0, nums.length);
    }

    // 左闭右开
    public static TreeNode buildTreeByNum(int[] nums, int begin, int end) {
        // 递归退出条件
        if (end - begin == 1) {
            return new TreeNode(nums[begin]);
        }
        else if (end - begin < 1) return null;
        // 找出中间节点
        int midIndex = (end + begin) / 2;
        TreeNode node = new TreeNode(nums[midIndex]);
        
        node.left = buildTreeByNum(nums, begin, midIndex);
        node.right = buildTreeByNum(nums, midIndex + 1, end);
        return node;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */

