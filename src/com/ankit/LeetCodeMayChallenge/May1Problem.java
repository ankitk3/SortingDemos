package com.ankit.LeetCodeMayChallenge;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class May1Problem {
    public int firstBadVersion(int n) {
        int startIndex=1, endIndex = n;
        while(startIndex < endIndex){
            int currentValue = startIndex+ (endIndex-startIndex)/2;
            if(isBadVersion(currentValue)){
                endIndex = currentValue;
            } else{
                startIndex = currentValue+1;
            }
        }
        return startIndex;
    }
    //Assume isBadVersion(value) is predefined
    private boolean isBadVersion(int value){
        System.out.println("I am called.");
        if(value >= 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        May1Problem obj = new May1Problem();
        int input = 1;
        int output = obj.firstBadVersion(input);
        System.out.println(output);
    }
}
