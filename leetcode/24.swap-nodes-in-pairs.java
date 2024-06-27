/*
 * @lc app=leetcode.cn id=24 lang=java
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (72.42%)
 * Likes:    2231
 * Dislikes: 0
 * Total Accepted:    875.2K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

 // Definition for singly-linked list.
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }
 
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode virhead = new ListNode(-1, head);
        var index = virhead;
        var first = index.next;
        if (first == null || first.next == null) return virhead.next;
        var second = index.next.next;
        var temp = second.next;
        while (second != null) {
            // 三次指针交换
            index.next = second;
            temp = second.next;
            second.next = first;
            first.next = temp;
            //更新三个指针
            if (temp == null || temp.next == null) break;
            index = first;
            first = temp;
            second = temp.next;
        }
        return virhead.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

