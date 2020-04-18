package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.
 *
 * Return the number of servers that communicate with any other server.
 * https://leetcode.com/problems/count-servers-that-communicate/
 *
 */
public class CountConnectedServers {
    public int countServers(int[][] grid) {
        int count = 0;
        if(grid == null || grid.length == 0){
            return count;
        }
        Map<Integer,Integer> rowCount = new HashMap<>();
        Map<Integer,Integer> colCount = new HashMap<>();
        for(int i=0;i < grid.length; i++){
            for(int j=0;j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    //check Row
                    if(rowCount.containsKey(i)){
                        rowCount.put(i,(rowCount.get(i) +1));
                    } else{
                        rowCount.put(i,1);
                    }
                    //check Column
                    if(colCount.containsKey(j)){
                        colCount.put(j,(colCount.get(j) +1));
                    } else{
                        colCount.put(j,1);
                    }
                }
            }
        }
        for(int i=0;i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if(rowCount.get(i) > 1){
                        count++;
                    }
                    else if(colCount.get(j) > 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountConnectedServers obj = new CountConnectedServers();
        int[][]grid = new int[][]{{1,0,0},{0,0,1}};
        int count = obj.countServers(grid);
        System.out.println(count);
    }
}
