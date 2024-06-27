
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=707 lang=java
 * @lcpr version=30204
 *
 * [707] 设计链表
 *
 * https://leetcode.cn/problems/design-linked-list/description/
 *
 * algorithms
 * Medium (34.43%)
 * Likes:    1028
 * Dislikes: 0
 * Total Accepted:    318.5K
 * Total Submissions: 925.2K
 * Testcase Example:  '["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]\n' +
  '[[],[1],[3],[1,2],[1],[1],[1]]'
 *
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * 
 * 实现 MyLinkedList 类：
 * 
 * 
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val
 * 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果
 * index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get",
 * "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * 输出
 * [null, null, null, null, 2, null, 3]
 * 
 * 解释
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
 * myLinkedList.get(1);              // 返回 2
 * myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
 * myLinkedList.get(1);              // 返回 3
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= index, val <= 1000
 * 请不要使用内置的 LinkedList 库。
 * 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class MyLinkedList {
    private int size;
    private Node first;

    public MyLinkedList() {
        this.size = 0;
        this.first = null;
    }
    
    public int get(int index) {
        printString();
        if (index >= size) return -1;
        Node fir = first;
        // System.out.println("头节点的值为" + fir);
        for (int i = 0; i < index; i++) {
                fir = fir.next;
        }
        // System.out.println("列表长度为" + size);
        // System.out.println("第" + index + "个元素为" + fir);
        return fir.val;
    }

    private class Node {
        private int val;
        private Node next;

        private Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }
        @Override
        public String toString() {
            return "[val =" + val + "]";
        }

    }
    
    public void addAtHead(int val) {
        Node head = new Node(val, first);
        first = head;
        size ++;

    }
    public void printString() {
        int []link = new int[size];
        Node fir = first;
        for (int i = 0; i < size; i++) {
            link[i] = fir.val;
            fir = fir.next;
        }
        var linked = Arrays.toString(link);
        System.out.println(linked);
        // return linked;
    }
    
    public void addAtTail(int val) {
        Node tail = new Node(val, null);
        Node fir = first;
        for (int i = 0; i < size - 1; i++) {
            fir = fir.next;
        }
        size ++;
        if (size == 1) first = tail;
        else fir.next = tail;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        else if (index == 0) {
            addAtHead(val);
            return;
        }
        else if (index == size) {
            addAtTail(val);
            return;
        }
        Node fir = first;
        for (int i = 0; i < index - 1; i++) {
            fir = fir.next;
        }
        Node ins = new Node(val, fir.next);
        fir.next = ins;
        size ++;

    }
    
    public void deleteAtIndex(int index) {
        if (index < size && index > 0) {
            Node fir = first;
            for (int i = 0; i < index - 1; i++) {
                fir = fir.next;
            }
            fir.next = fir.next.next;
            size --;
        }
        else if (index == 0) {
            first = first.next;
            size --;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// @lc code=end



