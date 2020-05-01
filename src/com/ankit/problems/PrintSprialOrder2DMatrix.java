package com.ankit.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintSprialOrder2DMatrix {
    //This didn't work, which i tried, then I copied solution from net and pasted as another method.
    public List<Integer> spiralOrderAnkit(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length>0){
            int rowLength = matrix.length;
            int colLength = matrix[0].length;
            int additionRow = 0;
            int additionCol = 0;
            while(additionRow < (matrix.length+1)/2) {
                for (int index = additionRow; index < colLength - additionCol-1; index++) {
                    System.out.print(matrix[additionRow][index]);
                    System.out.print("\t");
                    list.add(matrix[additionRow][index]);
                }
                System.out.println("First");
                for (int index = additionRow; index < rowLength - additionRow-1; index++) {
                    System.out.print(matrix[index][colLength - additionRow - 1]);
                    System.out.print("\t");
                    list.add(matrix[index][colLength - additionRow - 1]);
                }
                System.out.println("Second");

                //reverse printing
                for (int index = colLength - additionCol - 1; index > additionCol; index--) {
                    System.out.print(matrix[rowLength - additionRow - 1][index]);
                    System.out.print("\t");
                    list.add(matrix[rowLength - additionRow - 1][index]);
                }
                System.out.println("Third");
                for (int index = rowLength - additionRow - 2; index > additionRow; index--) {
                    System.out.print(matrix[index][additionCol]);
                    System.out.print("\t");
                    list.add(matrix[index][additionCol]);
                }
                System.out.println("Fourth");
                additionRow++;
                additionCol++;
            }
        }
        return list;
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }
    public static void main(String[] args) {
//        int [][]matrix = {
//                {1,   4,  7, 11, 15, 18},
//                {2,   5,  8, 12, 19 ,21},
//                {3,   6,  9, 16, 22 ,23},
//                {10, 13, 14, 17, 24 ,28},
//                {18, 21, 23, 26, 30, 36}
//        };
        int[][]matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        PrintSprialOrder2DMatrix obj = new PrintSprialOrder2DMatrix();

        List<Integer> resp = obj.spiralOrder(matrix);
        resp.stream().forEach(l-> System.out.println(l));
    }
}
