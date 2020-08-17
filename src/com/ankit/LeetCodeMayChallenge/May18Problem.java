package com.ankit.LeetCodeMayChallenge;

import java.util.Arrays;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class May18Problem {
    public boolean checkInclusion(String s1, String s2) {
        boolean isStarted = false;
        if(s1 ==  null){
            return true;
        }
        if(s2 == null || s1.length() > s2.length()){
            return false;
        }
        int [] charArr = new int[26];
        int totalChar = 0;
        for(char c : s1.toCharArray()){
            charArr[c-'a']++;
            totalChar++;
        }
        int tempTotalChar = totalChar;
        int [] tempCharArr = Arrays.copyOf(charArr,charArr.length);

        int begin = 0, end = s1.length();
//        for(int i = 0; i < end && i < s2.length(); i++) {
//            if(tempCharArr[s2.charAt(i) - 'a']-- > 0) {
//                tempTotalChar--;
//                tempCharArr[s2.charAt(i)]--;
//            }
//        }
//        if(tempTotalChar == 0)
//            return true;
//
//        while(end < s2.length()) {
//            if(table[s2.charAt(end++) - 'a']-- > 0) {
//                count--;
//            }
//
//            if(table[s2.charAt(begin++) - 'a']++ >= 0) {
//                count++;
//            }
//
//            if(count == 0) return true;
//
//        }
//        for(char c : s2.toCharArray()){
        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int value = tempCharArr[c-'a'];
            if(value >0){
                if(!isStarted){
                    isStarted = true;
                }
                tempTotalChar--;
                tempCharArr[c-'a']--;
                if(tempTotalChar == 0){
                    return true;
                }
            } else{
                if(isStarted){
                    tempTotalChar = totalChar;
                    tempCharArr = Arrays.copyOf(charArr,charArr.length);
                }
            }
        }
        return false;
    }
    private boolean checkInclusionCopied(String s1, String s2){
        int[] target = new int[26], current = new int[26];
        int count = s1.length(), begin = 0, end = 0;
        for(char c : s1.toCharArray()) target[c - 'a']++;
        while(end < s2.length()) {
            char c = s2.charAt(end++);
            if(target[c - 'a'] == 0) {
                begin = end;
                for(int i = 0; i < current.length; i++) current[i] = 0;
                count = s1.length();
            } else {
                current[c - 'a']++;
                count--;
                while(current[c - 'a'] > target[c - 'a']) {
                    current[s2.charAt(begin++) - 'a']--;
                    count++;
                }
                if(count == 0) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        May18Problem obj = new May18Problem();
//        String s1 = "ab";
//        String s2 = "eidboaoo";
//        String s1 = "hello";
//        String s2 = "ooolleoooleh";
        String s1 = "adc";
        String s2 = "dcda";
        boolean result = obj.checkInclusionCopied(s1,s2);
        System.out.println(result);
    }
}
