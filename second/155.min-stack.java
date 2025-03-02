/*
 * @lc app=leetcode.cn id=155 lang=java
 * @lcpr version=30204
 *
 * [155] 最小栈
 *
 * https://leetcode.cn/problems/min-stack/description/
 *
 * algorithms
 * Medium (60.89%)
 * Likes:    1889
 * Dislikes: 0
 * Total Accepted:    693.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 实现 MinStack 类:
 * 
 * 
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 10^4 次
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayDeque;

class MinStack {
    // private ArrayDeque<int[]> stack;
    private ArrayDeque<Integer> stack;
    private int min;

    public MinStack() {
        stack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        // if (stack.isEmpty()) {
        //     stack.push(new int[]{val, val});
        //     return;
        // }
        // int[] top = getTop();
        // if (top[1] < val) {
        //     stack.push(new int[]{val, top[1]});
        // }
        // else stack.push(new int[]{val, val});

        // O（1）空间
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        }
        else {
            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

    }
    
    public void pop() {
        // stack.pop();
        if (stack.peek() == min) {
            stack.pop();
            if (!stack.isEmpty())
                min = stack.pop();
        }
        else stack.pop();
    }
    
    public int top() {
        // return getTop()[0];
        return stack.peek();
    }
    
    public int getMin() {
        // return getTop()[1];
        return min;
    }

    // private int[] getTop() {
    //     // return stack.peek();
    // }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end



/*
// @lcpr case=start
// ["MinStack","push","push","push","getMin","pop","top","getMin"][[],[-2],[0],[-3],[],[],[],[]]\n
// @lcpr case=end

 */

