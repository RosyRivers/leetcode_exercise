/*
 * @lc app=leetcode.cn id=501 lang=java
 * @lcpr version=30204
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (55.31%)
 * Likes:    767
 * Dislikes: 0
 * Total Accepted:    223.9K
 * Total Submissions: 402.9K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 
 * 假定 BST 满足如下定义：
 * 
 * 
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 
 * 
 * 示例 2：
 * 
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数目在范围 [1, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
    private static int count;
    private static int curCount;
    private static HashSet<Integer> ele;
    private static TreeNode pre;
    private static TreeNode cur;
    public int[] findMode(TreeNode root) {
        count = 1;
        curCount = 1;
        ele = new HashSet<>();
        TreeNode idx = root;
        while (idx != null && idx.left != null) {
            idx = idx.left;
        }
        pre = idx; cur = pre;
        midTravel(root);
        int[] res = new int[ele.size()];
        int index = 0;
        for (int element : ele) {
            res[index++] = element;
        }
        return res;

    }
    // 中序遍历
    public static void midTravel(TreeNode node) {
        if (node == null) return;
        midTravel(node.left);
        // 处理逻辑
        cur = node;
        if (pre != cur && cur.val == pre.val) 
            curCount ++;
        else curCount = 1;
        if (curCount == count) {
            // 加入新元素
            ele.add(cur.val);
        }
        else if (curCount > count) {
            count = curCount;
            // 删除除当前元素以外的所有元素
            ele.removeIf((num) -> num != cur.val);
        }
        pre = cur;
        midTravel(node.right);

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,2]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2]\n
// @lcpr case=end


 */

