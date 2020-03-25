package com.ankit.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintZigZagOrder2DMatrix {
    public List<Integer> zigZagOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length>0){
            boolean isRevert = false;
            int j = 0;
            for(int i=0;i<matrix.length;i++){
                if(isRevert){
                    j=matrix[0].length-1;
                }else{
                    j = 0;
                }
                for(; j>=0 && j < matrix[i].length;){
                    list.add(matrix[i][j]);
                    if(isRevert){
                        j--;
                    } else{
                        j++;
                    }
                }
                isRevert = !isRevert;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int [][]matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        PrintZigZagOrder2DMatrix obj = new PrintZigZagOrder2DMatrix();

        List<Integer> resp = obj.zigZagOrder(matrix);
        resp.stream().forEach(l-> System.out.println(l));
    }
}
