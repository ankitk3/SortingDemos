package com.ankit.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Rolling hexa values
 * Two arrays given one is all hexadecimal numbers
 * In second rolling array, every index means, no of values in hexa array to be rolledup by one
 * Means as at index 0 value is 2, that means in hex array starting from 0 two elements will be rolled up by one
 * output is {'B', 'D', '0', '9'}
 *
 *
 * //Hex array: {'A', 'C', '0', '9'}
 * //Roll array: {2,1,3}
 */
public class MicrosoftFirstQuestion {

    private char[] rollValues(char [] hexArray, int[] rollArray) {
        if(rollArray != null && rollArray.length > 0 && hexArray != null && hexArray.length > 0) {
            char [] convertedHexArray = new char[hexArray.length];
            Map<Integer,Character> indexToHexMap = new HashMap<>(); //These are prepopulated
            Map<Character, Integer> hexToIntegerMap = new HashMap<>(); //These are prepopulated
            int [] countArray = new int[16];
            Arrays.sort(rollArray); // 1,2,3,4,6
            for(int rollIndex = 0; rollIndex < rollArray.length; rollIndex++){

                //if value is zero, just contiue the loop

                //get count, by which it needs to be rolled
                int count = rollArray.length - rollIndex-1;   //size=5, index=0, count = 4
                int indexValue = rollArray[rollIndex]; //get the index value, for which count is to be set

                countArray[indexValue] = countArray[indexValue] + count; //Put count, index wise
            }

            for(int hexIndex = 0; hexIndex < hexArray.length; hexIndex++){
                int totalCount = countArray[hexIndex+1]; //Will give me total count
                int hexMapIndex = hexToIntegerMap.get(hexArray[hexIndex]);
                int nextIndex = (hexMapIndex+totalCount) % 16;
                char nextHexValue = indexToHexMap.get(nextIndex);
                convertedHexArray[hexIndex] = nextHexValue;
            }
            return convertedHexArray;
        }
        return hexArray;
    }
}
/**
 * Test cases
 * input
 * HexArray: {'B', '0', 'F' , '0'}
 * RollArray: {1,1,3,4}
 *
 *
 * input
 * HexArray: {'B', '0', 'F' , '0'}
 * RollArray: {0,1,3,4,9}
 *
 *
 * input
 * HexArray: {'B', '0', 'F' , '0'}
 * RollArray: {4,4,4,5,5,6}
 *
 *
 * input
 * HexArray: {'B', '0', 'F' , '0'}
 * RollArray: {}
 *
 * input
 * HexArray: {}
 * RollArray: {1,2}
 *
 *
 * input
 * HexArray: {}
 * RollArray: {}
 *
 *
 * input
 * HexArray: {'B'}
 * RollArray: {0,1,2,3,4}
 **/