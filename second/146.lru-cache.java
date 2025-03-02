/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30204
 *
 * [146] LRU 缓存
 *
 * https://leetcode.cn/problems/lru-cache/description/
 *
 * algorithms
 * Medium (54.19%)
 * Likes:    3388
 * Dislikes: 0
 * Total Accepted:    770.3K
 * Total Submissions: 1.4M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 
 * 实现 LRUCache 类：
 * 
 * 
 * 
 * 
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组
 * key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 
 * 
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 10^5
 * 最多调用 2 * 10^5 次 get 和 put
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class LRUCache {
    private HashMap<Integer, ListNode> map;
    private int capacity;
    private int count;
    private ListNode head;
    private ListNode tail;

    class ListNode {
        int key;  // 新增key属性
        int val;
        ListNode next;
        ListNode pre;
        ListNode(int key, int val) {  // 修改构造方法以接收key和value
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity * 2);
        this.capacity = capacity;
        this.count = 0;
        head = null;
        tail = null;
    }

    public int get(int key) {
        ListNode temp = map.get(key);
        if (temp == null) return -1;
        update(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode t = map.get(key);
            t.val = value;
            update(t);
            return;
        }

        if (count >= capacity) {
            // 删除头节点，并通过节点的key移除哈希表项
            if (head != null) {
                int oldKey = head.key;
                map.remove(oldKey);
                head = head.next;
                if (head != null) {
                    head.pre = null;
                } else {
                    tail = null; // 当链表被清空时更新tail
                }
                count--;
            }
        }

        // 创建新节点时传入key和value
        ListNode temp = new ListNode(key, value);
        if (count == 0) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.pre = tail;
            tail = temp;
        }
        map.put(key, temp);  // 将新节点加入哈希表
        count++;
    }

    private void update(ListNode t) {
        if (t == tail) return;

        if (t == head) {
            head = head.next;
            if (head != null) head.pre = null;
        } else {
            ListNode p = t.pre;
            p.next = t.next;
            if (t.next != null) t.next.pre = p;
        }

        // 将节点移动到尾部
        t.pre = tail;
        t.next = null;
        tail.next = t;
        tail = t;
    }
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

// @lcpr case=start
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]\n[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// @lcpr case=end

// @lcpr case=start
// ["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
// @lcpr case=end



