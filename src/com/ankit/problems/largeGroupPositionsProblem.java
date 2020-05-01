package com.ankit.problems;

import java.util.ArrayList;
import java.util.List;

public class largeGroupPositionsProblem {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> responseList = new ArrayList<>();
        int startIndex=-1, endIndex=-1;
        char[] charArray = S.toCharArray();
        char previousValue='-';
        for(int index=0;index<charArray.length;index++){
            if(index==0){
                previousValue = charArray[index];
                startIndex = 0;
                endIndex = 0;
            } else{
                  if(charArray[index] == previousValue){
                      endIndex++;
                      //If it is last index, then also add all the current value
                      if(index == charArray.length-1 && endIndex - startIndex >=2){
                          List<Integer> cordinates = new ArrayList<>();
                          cordinates.add(startIndex);
                          cordinates.add(endIndex);
                          responseList.add(cordinates);
                      }
                  } else{
                      if(endIndex - startIndex >=2){
                          List<Integer> cordinates = new ArrayList<>();
                          cordinates.add(startIndex);
                          cordinates.add(endIndex);
                          responseList.add(cordinates);
                      }
                      startIndex = index;
                      endIndex = index;
                      previousValue = charArray[index];
                  }
            }
        }
        return responseList;
    }

    public static void main(String[] args) {
        largeGroupPositionsProblem obj = new largeGroupPositionsProblem();
        String input = "abcdddeeeeaabbbcd";
        //input = "aaa";
        List<List<Integer>> resp = obj.largeGroupPositions(input);
        resp.stream().forEach(l-> l.stream().forEach(k-> System.out.println(k)));
    }
}
