package com.ankit.LeetCodeMayChallenge;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class May5Problem {
    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty()){
            return -1;
        }
        char [] charArray = s.toCharArray();
        int[]charCount = new int[26];
        for(char c : charArray){
            int index = c -'a';
            charCount[index] = charCount[index]+1;
        }
        for(int index =0; index < charArray.length;index++){
            char currentChar = charArray[index];
            int countIndex = currentChar -'a';
            if(charCount[countIndex] == 1){
                return index;
            }
        }
        return -1;
    }

    //This I Copied from solution, this answer took 1 ms and mine above took 4 ms.
    public int anotherBestSolutionFromNet(String s){
        int res = Integer.MAX_VALUE;

        for(char c = 'a'; c <= 'z'; c++){
            int index = s.indexOf(c);

            if(index != -1 && index == s.lastIndexOf(c))
                res = Math.min(res, index);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {
        May5Problem obj = new May5Problem();
        String input = "eeedcode";
        int output = obj.firstUniqChar(input);
        System.out.println(output);
    }
}
