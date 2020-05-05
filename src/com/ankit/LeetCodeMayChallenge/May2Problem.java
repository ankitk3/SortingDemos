package com.ankit.LeetCodeMayChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class May2Problem {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> jewelsMap = new HashMap<>();
        for(char jewel : J.toCharArray()){
            jewelsMap.put(jewel,1);
        }
        int count = 0;
        for(char stone : S.toCharArray()){
            if(jewelsMap.containsKey(stone)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        May2Problem obj = new May2Problem();
        //int resp = obj.numJewelsInStones("aA","aAAbbbb");
        int resp = obj.numJewelsInStones("z","ZZ");
        System.out.println(resp);
    }
}
