
import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=225 lang=java
 * @lcpr version=30204
 *
 * [225] 用队列实现栈
 *
 * https://leetcode.cn/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (65.60%)
 * Likes:    895
 * Dislikes: 0
 * Total Accepted:    394.3K
 * Total Submissions: 601.1K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 
 * 实现 MyStack 类：
 * 
 * 
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty
 * 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * 
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * 
 * 
 * 
 * 
 * 进阶：你能否仅用一个队列来实现栈。
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class MyStack {
    private ArrayDeque<Integer> temp = null;
    private ArrayDeque<Integer> stack = null;
    private byte flag;

    public MyStack() {
        this.temp = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (flag == 0) temp.offer(x);
        else stack.offer(x);
    }
    
    public int pop() {
        if (flag == 0) {
            while (temp.size() > 1) {
                stack.offer(temp.poll());
            }
            flag = 1;
            return temp.poll();
        }
        else {
            while (stack.size() > 1) {
                temp.offer(stack.poll());
            }
            flag = 0;
            return stack.poll();
        }

    }
    
    public int top() {
        if (flag == 0) {
            while (temp.size() > 1) {
                stack.offer(temp.poll());
                //flag = 1;
            }
            return temp.peek();
        }
        else {
            while (stack.size() > 1) {
                temp.offer(stack.poll());
                //flag = 0;
            }
            return stack.peek();
        }
    }
    
    public boolean empty() {
        return temp.isEmpty() && stack.isEmpty();

    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);["MyStack","push","push","top","push","top"]
 [[],[1],[2],[],[3],[]]
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end



/*
// @lcpr case=start
// ["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]\n
// @lcpr case=end

// @lcpr case=start
// ["MyStack","push","push","top","push","top"]\n[[],[1],[2],[],[3],[]]\n
// @lcpr case=end

// @lcpr case=start
// ["MyStack","push","push","top","pop","pop","empty"]\n[[],[1],[2],[],[],[],[]]
// @lcpr case=end

// @lcpr case=start
// ["MyStack","push","pop","push","top"]\n[[],[1],[],[2],[]]
// @lcpr case=end

 */

