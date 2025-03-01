

/*
 * @lc app=leetcode.cn id=203 lang=java
 * @lcpr version=30204
 *
 * [203] 移除链表元素
 *
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 *
 * algorithms
 * Easy (56.92%)
 * Likes:    1433
 * Dislikes: 0
 * Total Accepted:    747K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,6,3,4,5,6]\n6'
 *
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 
 * 
 * 示例 1：
 * 
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = [], val = 1
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 列表中的节点数目在范围 [0, 10^4] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

//  // Definition for singly-linked list.
//   class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }


class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode virhead = new ListNode(-1, head);
        ListNode result = head;
        ListNode index = virhead;
        while(index.next != null) {
            if (index.next.val != val) { // 下一个节点不是目标节点，索引+1
                index = index.next;
                
            }
            else index.next = index.next.next;  //下一个节点是目标节点，删除指向下一个节点的指针，索引不变
            // 如果下一个节点为空，退出循环
        }
        result = virhead.next;
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,6,3,4,5,6]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n1\n
// @lcpr case=end

// @lcpr case=start
// [7,7,7,7]\n7\n
// @lcpr case=end

 */

