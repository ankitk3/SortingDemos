package com.ankit.LeetCodeMayChallenge;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class May3Problem {
    public boolean canConstruct(String ransomNote, String magazine) {
//        if(ransomNote == null || ransomNote.isEmpty() || magazine == null || magazine.isEmpty()){
//            return  false;
//        }
        Map<Character,Integer> countMap = new HashMap<>();
        for(char magChar : magazine.toCharArray()){
            if(countMap.containsKey(magChar)){
                countMap.put(magChar,countMap.get(magChar)+1);
            } else{
                countMap.put(magChar,1);
            }
        }
        for(char ranChar : ransomNote.toCharArray()){
            if(countMap.containsKey(ranChar) && countMap.get(ranChar) > 0){
                countMap.put(ranChar,countMap.get(ranChar)-1);
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        May3Problem obj = new May3Problem();
        boolean resp = obj.canConstruct("","");
        System.out.println(resp);
    }
}
