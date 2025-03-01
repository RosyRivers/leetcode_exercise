/*
 * @lc app=leetcode.cn id=21 lang=java
 * @lcpr version=30204
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (66.64%)
 * Likes:    3691
 * Dislikes: 0
 * Total Accepted:    1.9M
 * Total Submissions: 2.9M
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 
 * 
 * 示例 2：
 * 
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /**
         * 递归
         */

        // if (list1 == null) return list2;
        // if (list2 == null) return list1;
        // if (list1.val < list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // }
        // else {
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }


        /**
         * 迭代
         */
        ListNode prehead = new ListNode(-1);
        ListNode prenode = prehead;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prenode.next = list1;
                prenode = list1;
                list1 = list1.next;
            }
            else {
                prenode.next = list2;
                prenode = list2;
                list2 = list2.next;
            }
        }
        prenode.next = list1 == null ? list2 : list1;
        return prehead.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [5]\n[1,2,4]\n
// @lcpr case=end

 */

