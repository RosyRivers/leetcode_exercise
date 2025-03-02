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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // 迭代解决
        // if (head == null || head.next == null) return head;
        // ListNode virHead = new ListNode(-1, head);
        // ListNode pre = virHead;
        // ListNode cur = head;
        // ListNode next = head.next;
        // while (cur != null && next != null) {
        //     cur.next = next.next;
        //     next.next = cur;
        //     pre.next = next;

        //     pre = cur;
        //     cur = pre.next;
        //     if (cur == null) break;
        //     next = cur.next;
        // }
        // return virHead.next;

        /**
         * 递归解决
         */
        // 递归的退出条件
        if (head == null || head.next == null) return head;
        // 进行递归
        ListNode cur = head, pre = cur.next;
        cur.next = swapPairs(pre.next);
        pre.next = cur;
        return pre;
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

