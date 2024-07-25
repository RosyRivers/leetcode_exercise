
import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30204
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (48.95%)
 * Likes:    2821
 * Dislikes: 0
 * Total Accepted:    645.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回 滑动窗口中的最大值 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class MyQueue {
    private ArrayDeque<Integer> queue;
    public MyQueue() {
        this.queue = new ArrayDeque<>();
    }

    public void poll(int val) {
        if (!queue.isEmpty() && queue.peek() == val)
            queue.poll();
    }

    public boolean offer(int val) {
        while (!queue.isEmpty() && val > queue.getLast()) {
            queue.removeLast();
        }
        queue.offer(val);
        return true;
    }

    public int peek() {
        return queue.peek();
    }

    public int getmax() {
        return queue.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k;
        int[] res = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k ; i++) {
            queue.offer(nums[i]);
        }
        res[0] = queue.getmax();
        for (; right < nums.length; right++) {
            queue.poll(nums[left]);
            queue.offer(nums[right]);
            left++;
            res[left] = queue.getmax();
        }
        return res;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end


// @lcpr case=start
// [1,3,1,2,0,5]\n3\n
// @lcpr case=end

 */

