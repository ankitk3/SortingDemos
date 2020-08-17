package com.ankit.problems;

public class CountCommunicatingServers {

    private int process(int [][] grid){
        return countMethod(grid,0,0,grid[0].length,grid.length);
    }

    private int countMethod(int [][]grid, int i, int j, int rowLength, int colLength){
        int count= 0;
        if(grid[i][j] == 1){
            count++;
            grid[i][j] = 0;
        }
        if(i-1 > 0){
            count += countMethod(grid,i-1,j,rowLength,colLength);
        }
        if(i+1 < rowLength){
            count += countMethod(grid,i+1,j,rowLength,colLength);
        }
        if(j-1 > 0){
            count += countMethod(grid,i,j-1,rowLength,colLength);
        }
        if(j+1 < colLength){
            count += countMethod(grid,i,j+1,rowLength,colLength);
        }
        return count;
    }
    public static void main(String[] args) {
        int [][]input = {{1,0},{1,0}};
        CountCommunicatingServers ser = new CountCommunicatingServers();
        int output = ser.process(input);
        System.out.println(output);
    }
}
