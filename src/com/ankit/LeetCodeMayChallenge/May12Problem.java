package com.ankit.LeetCodeMayChallenge;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class May12Problem {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return search(nums,0, nums.length-1);
        //int length = nums.length/2;
//        if(length%2 == 0 && )
    }
    private int search(int arr[], int start, int end){
        if(start > end){
            return -1;
        }
        if(start == end){
            return arr[start];
        }
        int mid = (start+end)/2;
        if(mid % 2 == 0)
        {
            if(arr[mid] == arr[mid+1])
                return search(arr, mid+2, end);
            else
                return search(arr, start, mid);
        }
        // If mid is odd
        else if(mid % 2 == 1)
        {
            if(arr[mid] == arr[mid-1])
                return search(arr, mid+1, end);
            else
                return search(arr, start, mid-1);
        }
        return -1;
    }

    /**
     * Another XOR approach, this take more time then above.
     * @param ar
     * @param ar_size
     * @return
     */
    private int findSingle(int ar[])
    {
        int ar_size = ar.length;
        // Do XOR of all elements and return
        int res = ar[0];
        for (int i = 1; i < ar_size; i++)
            res = res ^ ar[i];

        return res;
    }
    public static void main(String[] args) {
        May12Problem obj = new May12Problem();
        int [] input = {1,1,2,2,4,4,5,8,8};
        int resp = obj.singleNonDuplicate(input);
        System.out.println(resp);
    }
}
