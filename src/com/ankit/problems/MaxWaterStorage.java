package com.ankit.problems;

public class MaxWaterStorage {

    //In O(n2)
    public int maxArea(int[] height) {
        int count = 0;
        if(height != null && height.length > 0){
            int max = 0;
            for(int i = 0;i<height.length;i++){
                int leftVal = height[i];
                for(int j=i;j<height.length;j++){
                    if(leftVal <= height[j] && max < ((j-1)*leftVal)){
                        max = ((j-1)*leftVal);
                    } else if(leftVal >= height[j] && max < ((j-1)*height[j])){
                        max = ((j-1)*height[j]);
                    }
                    count++;
                }
            }
            System.out.println("Total iterations = "+count);
            return max;
        }
        System.out.println("Total iterations = "+count);
        return 0;
    }

    //complexity is O(n)
    public int maxArea2(int [] height){
        int count = 0;
        if(height != null && height.length > 0){
            int maxArea = 0;
            int i = 0, j = height.length - 1;
            while(i < j)
            {
                //compare from left to right and move smaller one, by not moving tallest one, we can get the maximum area
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                if(height[i] < height[j])
                    i++;
                else
                    j--;
                count++;
            }
            System.out.println("Total iterations = "+count);
            return maxArea;
        }
        System.out.println("Total iterations = "+count);
        return 1;
    }

    public static void main(String[] args) {
        int arr[] = {1,8,6,2,5,4,8,3,2};
//        int arr[] = {1,1};
        MaxWaterStorage max = new MaxWaterStorage();
        int answer = max.maxArea2(arr);
        System.out.println(answer);
    }
}
