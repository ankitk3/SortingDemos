package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @see https://leetcode.com/problems/reordered-power-of-2/
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 *
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Example 2:
 *
 * Input: 10
 * Output: false
 * Example 3:
 *
 * Input: 16
 * Output: true
 * Example 4:
 *
 * Input: 24
 * Output: false
 * Example 5:
 *
 * Input: 46
 * Output: true
 */
public class ArrangeNumberCheckPowerOf2  {

    public boolean reorderedPowerOf2(int N) {
        Map<String,Integer> countMap = new HashMap<>();
        String str = Integer.toString(N);
        for(char c : str.toCharArray()){
            if(countMap.containsKey(c)){
                //countMap.put(c ,(countMap.get(c)+1));
            } else{
                //countMap.put(c ,1);
            }
        }
        int output = -1;
        int index=1;
        while(output < N){
            //output = Math.pow(2,index);

        }
        return false;
    }

    public static void main(String[] args) {
        ArrangeNumberCheckPowerOf2 obj = new ArrangeNumberCheckPowerOf2();
        obj.reorderedPowerOf2(46);
    }

}
