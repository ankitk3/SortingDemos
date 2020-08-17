package com.ankit.problems;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * Input: "abbaca"
 * Output: "ca"
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class RemoveDuplicatesInString {

    public String removeDuplicates(String s) {
        StringBuffer response = new StringBuffer();
        if(s != null && s.length() > 0){
            int index = 0;
            while(index < s.length()){
                if(response.length() > 0){
                    if((response.charAt(response.length()-1) == s.charAt(index))){
                        response.deleteCharAt(response.length()-1);
                    }else{
                        response.append(s.charAt(index));
                    }
                } else{
                    response.append(s.charAt(index));
                }
                index++;
            }
        }
        return response.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicatesInString obj = new RemoveDuplicatesInString();
        String output = obj.removeDuplicates("abbaca");
        System.out.println(output);
    }
}
