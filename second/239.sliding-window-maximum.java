/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30204
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode.cn/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (48.94%)
 * Likes:    2859
 * Dislikes: 0
 * Total Accepted:    671.7K
 * Total Submissions: 1.4M
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

import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        DanQueue<Integer> queue = new DanQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = k; i < nums.length; i++) {
            result[i - k] = queue.peek();
            queue.poll(nums[i - k]);
            queue.offer(nums[i]);
        }
        result[nums.length - k] = queue.peek();
        return result;
    }

    // 构造一个单调队列
    public class DanQueue<T extends Comparable<T>> {

        private ArrayDeque<T> queue;
        
        public DanQueue() {
            queue = new ArrayDeque<>();
        }

        public void offer(T t) {
            while (!queue.isEmpty() && queue.getLast().compareTo(t) < 0) {
                queue.removeLast();
            }
            queue.offer(t);
        }

        public T poll(T t) {
            if (!queue.isEmpty() && queue.peek().equals(t))
                return queue.poll();
            return null;    
        }

        public T peek() {
            return queue.peek();
        }
        
        public int size() {
            return queue.size();
        }
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

