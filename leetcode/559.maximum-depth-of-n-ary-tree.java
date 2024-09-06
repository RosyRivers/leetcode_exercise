
import java.util.List;



import java.util.Arrays;
import org.w3c.dom.Node;



/*
 * @lc app=leetcode.cn id=559 lang=java
 * @lcpr version=30204
 *
 * [559] N 叉树的最大深度
 *
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/description/
 *
 * algorithms
 * Easy (75.18%)
 * Likes:    393
 * Dislikes: 0
 * Total Accepted:    173.7K
 * Total Submissions: 230.8K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，找到其最大深度。
 * 
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树的深度不会超过 1000 。
 * 树的节点数目位于 [0, 10^4] 之间。
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val) {
//         val = _val;
//     }

//     public Node(int _val, List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };


class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        // List<List<Integer>> result = new ArrayList<>();
        // ArrayDeque<Node> queue = new ArrayDeque<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     int len = queue.size();
        //     List<Integer> raw = new ArrayList<>();
        //     while (len > 0) {
        //         Node temp = queue.poll();
        //         raw.add(temp.val);
        //         len --;
        //         queue.addAll(temp.children);
        //     }
        //     result.add(raw);
        // }
        // return result.size();
        
        return binTravel(root);
        
    }
    public static int binTravel(Node root) {
        if (root == null) return 0;
        int depth = 0;
        if (root.children.size() != 0) {
            for (Node iNode : root.children) {
                depth = Math.max(depth, binTravel(iNode));
            }
        }
        return 1 + depth;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,3,2,4,null,5,6]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]\n
// @lcpr case=end

 */

