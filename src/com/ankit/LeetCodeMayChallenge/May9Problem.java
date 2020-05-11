package com.ankit.LeetCodeMayChallenge;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class May9Problem {
    public boolean isPerfectSquare(int num) {
        double sr = Math.sqrt(num);

        // If square root is an integer
        return ((sr - Math.floor(sr)) == 0);
    }

    public static void main(String[] args) {
        May9Problem obj = new May9Problem();
        int input = 808201;
        boolean resp = obj.isPerfectSquare(input);
        System.out.println(resp);
    }
}
