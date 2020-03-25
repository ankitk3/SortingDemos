package com.ankit.problems;

public class SearchInSorted2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length>0) {
            int i = 0;
            int j = matrix[i].length - 1;
            while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length) {
                if (matrix[i][j] == target) {
                    return true;
                }
                if (matrix[i][j] > target) {
                    j--;
                    continue;
                }
                if (matrix[i][j] < target) {
                    i++;
                    continue;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][]matrix = {
                {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        SearchInSorted2DMatrix obj = new SearchInSorted2DMatrix();
        boolean resp = obj.searchMatrix(matrix,40);
        System.out.println(resp);
    }
}
