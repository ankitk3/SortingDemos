package com.ankit.LeetCodeMayChallenge;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class May6Problem {

    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        int maxCount = 0;
        int maxIndexValue = -1;
        int currentValue = -1;
        int currentCount = 0;
        int midSize = (nums.length/2) + 1;
        for(int index = 0; index < nums.length ; index++){
              if(currentValue == nums[index]){
                  currentCount++;
              } else{
                  currentCount = 1;
                  currentValue = nums[index];
              }
              if(currentCount > maxCount){
                  maxCount = currentCount;
                  maxIndexValue = currentValue;
                  if(maxCount >= midSize){
                      break;
                  }
              }


        }
        if(maxCount >= midSize){
            return maxIndexValue;
        } else{
            return -1;
        }
    }
    /**I Tried with single digit array, but if it is double digit value, this won't work.
     * This didn't work, it failed.
    */
    public int majorityElementForSingleDigit(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int [] countArr = new int[10];
        for(int num : nums){
            countArr[num] = countArr[num]+1;
        }
        int midSize = (nums.length/2) + 1;
        for(int index = 0; index < countArr.length ; index++){
            int count = countArr[index];
            if(count >= midSize){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        May6Problem obj = new May6Problem();
//        int [] input = {2,2,1,1,1,2,2};
//        int[] input = {3,2,3};
        int [] input = {10,9,9,9,10};
        int response = obj.majorityElement(input);
        System.out.println(response);
    }
}
