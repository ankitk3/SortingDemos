package com.ankit.problems;

/**
 * This is DP problem, will try to solve it later.
 */
public class LongestPalindrome {

    private String process(String str){
        String resp = "";
        int longest = Integer.MIN_VALUE;
        if(str.length() < 3){
            return str;
        } else{
            int start = 0, end = 1;
            if(((end-start) +1) > longest){
                longest = (end-start)+1;
                //resp+=
            }
        }
        return resp;
    }

    private boolean compare(String str, int start, int end){
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String str = "abababab";
        String resp = lp.process(str);
        System.out.println(resp);
    }

}
