package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Need to find out total no of pairs available in an array whose total is equal to given sum
 * This has to be done in O(n)
 *
 *
 *  *
 *          *Question 1
 *          * ===========
 *          *
 *          *Given an array of integers,and a number ‘sum’,find the number of pairs of integers in the array whose sum is equal to ‘sum’.
 *          *
 *          *Examples:
 *          *
 *          *Input:arr[]={1,5,7,-1},
 *          *sum=6
 *          *Output:2
 *          *Pairs with sum 6are(1,5)and(7,-1)
 *          *
 *          *Input:arr[]={1,5,7,-1,5},
 *          *sum=6
 *          *Output:3
 *          *Pairs with sum 6are(1,5),(7,-1)&
 *          *(1,5)
 *          *
 *          *Input:arr[]={1,1,1,1},
 *          *sum=2
 *          *Output:6
 *          *There are 3!pairs with sum 2.
 *          *
 *          *Input:arr[]={10,12,10,15,-1,7,6,
 *          *5,4,2,1,1,1},
 *          *sum=11
 *          *Output:9
 *          *
 *          *Expected time complexity O(n)
 *          *
 *          *Please write working code and your solution should handle all edge cases.
 *          *
 *          *
 */
public class AmazonTestOne {

    private int totalPairsAvailable(int sum, int []array) {
        int pairsCount = 0;

        if (array != null && array.length != 0) {
            //Map which will contain total count of numbers exist.
            Map<Integer, Integer> valueCountMap = new HashMap<>();
            for (int value : array) {
                //If value exists, increase count
                if (valueCountMap.containsKey(value)) {
                    valueCountMap.put(value, (valueCountMap.get(value) + 1));
                } else {
                    valueCountMap.put(value, 1);
                }
            }
            for (int value : array) {
                int remainingValue = sum - value;
                if (valueCountMap.containsKey(remainingValue)) {
                    //pairsCount++;
                    //if count is more than 1, decrease the count, else remove the value.
                    int countActualValue = valueCountMap.get(value);
                    if (countActualValue > 0) {
                        //valueCountMap.put(value,(valueCountMap.get(countActualValue)-1));
                        decrementValue(value, valueCountMap);
                        decrementValue(remainingValue, valueCountMap);
                        pairsCount++;
                    } else {
                        int countRemainingValue = valueCountMap.get(remainingValue);
                        if (countRemainingValue > 0) {
                            decrementValue(remainingValue, valueCountMap);
                            pairsCount++;
                        }
                    }
                }
            }
        }
        return pairsCount;
    }
    //Decreasing the count
    private void decrementValue(int value, Map<Integer,Integer> valueCountMap){
        int countRemainingValue = valueCountMap.get(value);
        //if count is more than 1, decrease the count, else remove the value.
        if(countRemainingValue > 1){
            valueCountMap.put(value,(valueCountMap.get(value)-1));
        } else{
            valueCountMap.put(value,0);
        }
    }
    public static void main(String[] args) {
        AmazonTestOne test1 = new AmazonTestOne();
        int count = test1.totalPairsAvailable(11,new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1});
        System.out.println(count);
    }
}
