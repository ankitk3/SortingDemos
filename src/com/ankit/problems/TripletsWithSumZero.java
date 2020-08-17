package com.ankit.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletsWithSumZero {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resposeList = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return resposeList;
        }
        Map<Integer, Integer> numberMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(numberMap.containsKey(nums[i])){
                numberMap.put(nums[i],numberMap.get(nums[i])+1);
            } else{
                numberMap.put(nums[i],1);
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum == 0){

                }
            }
        }
        return resposeList;
    }

    public static void main(String[] args) {
        TripletsWithSumZero obj = new TripletsWithSumZero();
        int[]nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resp = obj.threeSum(nums);
        resp.stream().forEach(l-> l.stream().forEach(k-> System.out.println(k)));
    }
}
