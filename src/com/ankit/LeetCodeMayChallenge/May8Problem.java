package com.ankit.LeetCodeMayChallenge;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class May8Problem {

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null){
            return false;
        }
        if(coordinates != null && (coordinates.length == 1 || coordinates.length == 2)){
            return true;
        }
        float gSlope =  getSlope(coordinates[0], coordinates[1]);
        for(int index = 2; index < coordinates.length; index++){
            int [] cordinateArray = coordinates[index];
            if(cordinateArray == null || cordinateArray.length != 2){
                return false;
            }
            int [] previousCoordinate = coordinates[index-1];
            float slope = getSlope(cordinateArray, previousCoordinate);
            if(slope != gSlope){
                return false;
            }
        }
        return true;
    }
    private float getSlope(int [] p1, int [] p2){
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        May8Problem obj = new May8Problem();
        int [][] input = {
                {1,2},
                {2,3},
                {3,4},
                {4,5}
        };
//        int [][] input = {
//                {-3,-2},
//                {-1,-2},
//                {2,-2},
//                {-2,-2},
//                {0,-2}
//        };
        boolean resp = obj.checkStraightLine(input);
        System.out.println(resp);
    }
}
