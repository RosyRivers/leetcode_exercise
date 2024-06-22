package leetcode;

import java.util.Scanner;

public class Rmelement_27 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        String s = in.nextLine();
        int val = in.nextInt();
        String []str = s.split(" ");
        int []nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        System.out.println(Solution27.removeElement(nums, val));
        for (int i : nums) {
            System.out.printf("%d ", i);
        }
        
    }
}
 class Solution27 {
    public static int removeElement(int[] nums, int val) {
        int flag = 0;
        int cir = 0;
        for (int i = 0; i < nums.length; i++) {
            if(cir == nums.length) break;
            if (nums[i] == val) {
                flag ++;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
            cir++;
        }
        return nums.length - flag;
    }
}
