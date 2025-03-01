/*
 * @lc app=leetcode.cn id=912 lang=java
 * @lcpr version=30204
 *
 * [912] 排序数组
 *
 * https://leetcode.cn/problems/sort-an-array/description/
 *
 * algorithms
 * Medium (49.10%)
 * Likes:    1039
 * Dislikes: 0
 * Total Accepted:    697.2K
 * Total Submissions: 1.4M
 * Testcase Example:  '[5,2,3,1]'
 *
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 * 你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 5 * 10^4
 * -5 * 10^4 <= nums[i] <= 5 * 10^4
 * 
 * 
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        // // 冒泡排序
        // int len = nums.length;
        // while (len > 0) {
        //     boolean flag = false;
        //     for (int j = 0; j < len - 1; j++) {
        //         if (nums[j] > nums[j + 1]) {
        //             flag = true;
        //             swap(nums, j + 1, j);
        //         }
        //     }
        //     if (flag == false) break;
        //     len --;
        // }
        // return nums;

        // // 插入排序
        // for (int i = 1; i < nums.length; i++) {
        //     int base = nums[i];
        //     int j = i - 1;
        //     while (j >= 0 && base < nums[j]) {
        //         nums[j + 1] = nums[j];
        //         j --;
        //     }
        //     nums[j + 1] = base;
            
        // }
        // return nums;

        // 快速排序
        // quickSort(nums, 0, nums.length - 1);
        // return nums;

        // 归并排序
        // mergeSort(nums, 0, nums.length - 1);
        // return nums;

        // 堆排序 堆化
        // heapSort(nums);
        // return nums;

        // 桶排序
        // bucketSort(nums);
        // return nums;

        // 计数排序
        // countSort(nums);
        // return nums;

        // 基数排序
        radisSort(nums);
        return nums;
        
    }

    public static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // https://tongluyang.com/2020/04/02/%E4%B8%89%E5%90%91%E5%88%87%E5%88%86%E5%BF%AB%E6%8E%92/
    public static void quickSort(int[] nums, int left, int right) {
        int i = left, j = right, eq = left;
        if (i >= j) return;
        // 随机索引
        int index = new Random().nextInt(left, right + 1);
        swap(nums, index, left);
        int base = nums[eq];
        while (eq <= j) {
            // 从左边开始找到大于基准数的
            if (nums[eq] > base) {
                swap(nums, eq, j);
                j --;
            }
            // 从左边开始找到小于基准数的
            else if (nums[eq] < base) {
                swap(nums, eq, i);
                i ++;
                eq ++;
            }
            else {
                eq++;
            }

        }
        // swap(nums, left, i);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // 到这一步，mid两侧的数组都是有序的
        merge(nums, left, mid, right);
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        // left 代表左子数组的起点，mid 代表左子数组的终点
        // 子数组都是排序好的,交替插入
        // 双重指针交替加入
        int[] temp = new int[right - left + 1];
        int leftp = left;
        int rightp = mid + 1;
        int tindex = 0;
        while (leftp <= mid && rightp <= right) {
            if (nums[leftp] > nums[rightp]) 
                temp[tindex++] = nums[rightp++];
            else 
                temp[tindex++] = nums[leftp++];
        }
        // 到这里必有一个子数组填充完毕
        // 若还有子数组还有元素没有填充到临时数组
        while (leftp <= mid) {
            temp[tindex++] = nums[leftp++];
        }
        while (rightp <= right) {
            temp[tindex++] = nums[rightp++];
        }
        // 将临时数组填充回原数组
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    // 维护堆操作 自start位置开始向下堆化
    public static void siftDown(int[] nums, int len, int start) {
        while (true) {
            int left = 2 * start + 1;
            int right = left + 1;
            int ma = start;
            if (left < len  && nums[left] > nums[ma]) 
               ma = left;   
            if (right < len && nums[right] > nums[ma])
                ma = right;
            // 若没有发生交换，就是已经稳定了
            if (ma == start)
                break;
            swap(nums, start, ma);
            start = ma;
        }
    }

    public static void heapSort(int[] nums) {
        // 堆化非叶子节点
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            siftDown(nums, nums.length, i);
        }

        // 移除堆顶元素进行排序
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            // 堆化
            siftDown(nums, i, 0);
        }
    }
    
    // 适合处理数据量较大的情况
    public static void bucketSort(int[] nums) {
        if (nums.length == 1) return;
        int k = nums.length / 2;
        // 初始化桶
        List<List<Integer>> buckers = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckers.add(new ArrayList<>());
        }
        // 获取数组中最大和最小元素
        int max = Arrays.stream(nums).max().getAsInt() + 1;
        int min = Arrays.stream(nums).min().getAsInt();
        float dist = max - min;
        // 将元素映射到桶中
        for (int num : nums) {
            float dis = num - min;
            float i =  dis / dist * k;
            int index = (int) i;
            buckers.get(index).add(num);
        }
        // 对每个桶进行排序
        for (List<Integer> bucket : buckers) {
            Collections.sort(bucket);
        }
        // 进行合并
        int i = 0;
        for (List<Integer> list : buckers) {
            for (Integer num : list) {
                nums[i++] = num;
            }
        }
    }
    
    // 适合数据量较大但数据范围较小的情况
    public static void countSort(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        // 复杂度O（max）,是数据范围的线性增长
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] ++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[index++] = (i + min);
                count[i]--;
            }
        }
    }

    public static void countingSortDigit(int[] nums, int exp) {
        int[] counter = new int[10];
        // 统计这一位中0~9出现的次数
        for (int i = 0; i < nums.length; i++) {
            // 获取这一位的数字
            int d = digit(nums[i], exp);
            counter[d] ++;
        }
        // 根据出现次数求对应的数组索引
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }
        // 倒序遍历
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            int j = counter[d] - 1;
            res[j] = nums[i];
            counter[d]--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }

    }
    
    public static void radisSort(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        for (int exp = 1; exp <= max; exp *= 10) {
            // 按照每一位进行排序
            countingSortDigit(nums, exp);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += min;
        }
    }

    private static int digit(int num, int exp) {
        return (num / exp) % 10;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,1,2,0,0]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

// @lcpr case=start
// [-1,2,-8,-10]\n
// @lcpr case=end

 */

