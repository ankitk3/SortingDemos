package com.ankit.LeetCodeMayChallenge;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 *
 * Example 2:
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 *
 * Note:
 *
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class May4Problem {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        System.out.println(binary);
        int highestBit = Integer.highestOneBit(num);
        System.out.println(Integer.toBinaryString(highestBit));
        int shiftBit = highestBit << 1;
        System.out.println(Integer.toBinaryString(shiftBit));
        int subtractBit = shiftBit-1;
        System.out.println(Integer.toBinaryString(subtractBit));
        System.out.println(Integer.toBinaryString(~num));
        System.out.println(Integer.toBinaryString(~num & subtractBit));
        return ~num & subtractBit;
    }

    public static void main(String[] args) {
        May4Problem obj = new May4Problem();
        int input = 5;
        int output = obj.findComplement(input);
        System.out.println(output);
    }
}
