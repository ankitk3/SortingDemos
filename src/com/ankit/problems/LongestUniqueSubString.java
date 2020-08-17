package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int current = 0;
        char[]array = s.toCharArray();
        Map<Character,Integer> countMap = new HashMap<>();
        for(int i=0,j=0;j<array.length && i < array.length;){
            if(countMap.containsKey(array[j])){
                if(countMap.get(array[i]) > 1){
                    countMap.put(array[i],(countMap.get(array[i])-1));
                } else {
                    countMap.remove(array[i]);
                }
                i++;
                current--;
            }else{
                if(countMap.containsKey(array[j])){
                    countMap.put(array[j],(countMap.get(array[j])+1));
                } else {
                    countMap.put(array[j], 1);
                }
                j++;
                current++;
            }
            if(current > maxLength){
                maxLength = current;
            }
            System.out.println("Current="+current+"::maxLength="+maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestUniqueSubString lon = new LongestUniqueSubString();
        int max = lon.lengthOfLongestSubstring("abcdcefgh");
        System.out.println(max);
    }
}
