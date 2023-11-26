package easy;

import medium.LongestSubstring;

public class RemoveDuplicates {

    //can set left to 1 and i to 1, and compare to i-1
    private int removeDuplicates(int[] nums){
        int prev = nums[0] - 1;
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(prev != nums[i]) {
                nums[left] = nums[i];
                left++;
            }
            prev = nums[i];
        }
        return left;
    }

    static int[] nums;

    RemoveDuplicates() {
        nums = new int[]{1,1,2};
        int result = removeDuplicates(nums);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < result; i++){
            sb.append(nums[i]);
            sb.append(',');
        }
        sb.setCharAt(sb.length() - 1, ']');
        System.out.println(sb.toString());
        System.out.println(result);
    }

    public static void main(String args[]) {
        new RemoveDuplicates();
    }

}
