package com.ankit.problems;

/**
 * @@see  https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int currentNumber = Integer.MIN_VALUE;
        boolean initial = true;
        int currentCount = 1;
        int finalIndex=-1;
        for(int num : nums){
            if(initial || currentNumber != num){
                currentNumber= num;
                currentCount = 1;
                finalIndex++;
                nums[finalIndex] = num;
                initial=false;
            } else if(currentNumber == num && currentCount >=2){
                continue;
            } else if(currentNumber == num && currentCount < 2){
                currentCount++;
                finalIndex++;
                if(nums[finalIndex] != num){
                    nums[finalIndex] = num;
                }
            }
            System.out.println("currentNumber="+currentNumber+"::currentCount="+currentCount+"::finalIndex="+finalIndex);
        }
        for(int i : nums){
            System.out.print(i+"\t");
        }
        System.out.println();
        return finalIndex+1;
    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();
        int output = obj.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        System.out.println(output);
    }
}
