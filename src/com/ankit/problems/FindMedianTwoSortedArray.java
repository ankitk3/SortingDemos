package com.ankit.problems;

public class FindMedianTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0;
        int j=0;
        double median = 0;
        int counter = (nums1.length+nums2.length)/2;
        boolean isEven = false;
        if((nums1.length+nums2.length)%2 == 0){
            isEven = true;
        } else{
            counter++;
        }
        while((i < nums1.length || j < nums2.length) && counter > 0){
            counter--;
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    if(isEven)
                        median = (nums1[i] + nums2[j])/2.0;
                    else
                        median = nums1[i];
                    i++;
                } else{
                    if(isEven)
                        median = (nums1[i] + nums2[j])/2.0;
                    else
                        median = nums2[j];
                    j++;
                }
            } else if(i < nums1.length){
                if(isEven)
                    if(nums2.length > 0)
                        median = (nums1[i] + nums2[j])/2.0;
                    else
                        median = (nums1[i] + nums1[i+1])/2.0;
                else
                    median = nums1[i];
                i++;
            } else if(j < nums2.length){
                if(isEven)
                    if(nums1.length > 0)
                        median = (nums1[i] + nums2[j])/2.0;
                    else
                        median = (nums2[j] + nums2[j+1])/2.0;
                else
                    median = nums2[j];
                j++;
            } else{
                break;
            }

        }
        return median;
    }
    public static void main(String[] args) {
        int arr[] = {};
        int arr2[] = {3,5};
        FindMedianTwoSortedArray find = new FindMedianTwoSortedArray();
        double response = find.findMedianSortedArrays(arr,arr2);
        System.out.println(response);
    }
}
