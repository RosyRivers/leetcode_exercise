

import java.util.Scanner;

public class Binsearch_704 {
    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            String cache = in.nextLine();
            int target = in.nextInt();
            //ArrayList<Integer> numbers = new ArrayList<>();
            String[] num = cache.split(" ");
            int []nums = new int[num.length];
            for (int i = 0; i < num.length; i++) {
                nums[i] = Integer.parseInt(num[i]);
    
            }
            System.out.println(Solution704.search(nums, target));
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }

    }
}

class Solution704 {
    public static int search(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        int middle = (start - end) / 2 + end;
        while (nums[middle] != target) {
            if(target > nums[middle]) { 
                start = middle;
                middle = (start - end) / 2 + end;
            }
            else {
                end = middle;
                middle = (start - end) / 2 + end;
            }
            if(start >= end - 1) {
                break;
            }
        }
        if(nums[middle] == target) return middle;
        if(nums[end] == target) return end;
        return -1;

    }
}
