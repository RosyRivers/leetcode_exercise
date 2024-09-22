/*
 * @lc app=leetcode.cn id=968 lang=java
 * @lcpr version=30204
 *
 * [968] 监控二叉树
 *
 * https://leetcode.cn/problems/binary-tree-cameras/description/
 *
 * algorithms
 * Hard (52.51%)
 * Likes:    750
 * Dislikes: 0
 * Total Accepted:    87K
 * Total Submissions: 165.3K
 * Testcase Example:  '[0,0,null,0,0]'
 *
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * 
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * 
 * 计算监控树的所有节点所需的最小摄像头数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
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
    int count;
    public int minCameraCover(TreeNode root) {
        count = 0;
        if (root.left == null && root.right == null) return 1;
        int val = beTravel(root);
         if (val == 1) count ++;
        return count;
    }
    public int beTravel(TreeNode node) {
        if (node == null) return 0;
        // 返回值为0，则代表为叶子节点或者它的上层需要摄像头
        int left = beTravel(node.left);
        int right = beTravel(node.right);
        // 根据左右子节点返回值判断是否是叶子节点
        if (left == 0 && right == 0) {
            return 1;
        }
        // 只要有一个返回值为1，是叶子节点的上一层或者已经与上一个摄像头相隔两层,需要安置摄像头
        else if (left == 1 || right == 1) {
            count ++;
            return 2;
        }
        // 只要有一个返回值为2，则代表它的子节点安置过摄像头了，此处不需要
        else {
            return 0;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,0,null,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,null,0,null,0,null,null,0]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,null,null,0,0,null,null,0,0]\n
// @lcpr case=end

 */

