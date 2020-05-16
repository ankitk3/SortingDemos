package com.ankit.LeetCodeMayChallenge;

/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 *
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 *
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 *
 *
 *
 * Example 1:
 *
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * Example 2:
 *
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 *
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * Example 4:
 *
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * Example 5:
 *
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 *
 *
 * Note:
 *
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 */
public class May15Problem {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        boolean isAllNegative = true;
        // Case 1: get the maximum sum using standard kadane'
        // s algorithm
        int max_kadane = kadaneAlgo(A);

        // Case 2: Now find the maximum sum that includes
        // corner elements.
        int max_wrap  =  0;
        for (int i = 0; i < n; i++)
        {
            if(A[i] >= 0){
                isAllNegative = false;
            }
            max_wrap += A[i]; // Calculate array-sum
            A[i] = -A[i];  // invert the array (change sign)

        }

        // max sum with corner elements will be:
        // array-sum - (-max subarray sum of inverted array)
        max_wrap = max_wrap + kadaneAlgo(A);

        // The maximum circular sum will be maximum of two sums
        return (!isAllNegative && max_wrap > max_kadane)? max_wrap: max_kadane;
    }
    private int kadaneAlgo(int [] A){
        int size = A.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + A[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
    public static void main(String[] args) {
        May15Problem obj = new May15Problem();
//        int [] input = {5, -3, 5};
//        int [] input = {3,-1,2,-1};
        int[]input = {-2,-3,-1};
        int output = obj.maxSubarraySumCircular(input);
        System.out.println(output);
    }
}
