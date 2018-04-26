package com.ankit.sorting;

public class SearchInSortedRotatedArray {

	public static void main(String[] args) {
		int k = 2;
		int ar[] = new int []{2,3,4,5,6,7,1};
		process(ar, 0, ar.length, k);
	}
	private static void process(int ar[], int start, int end, int k) {
		if(start==end) {
			System.out.println("Number not found");
			return ;
		}
		int pivot = getPivot(ar,start, end-1);
		System.out.println("Pivot="+pivot+":start="+start+":end="+end);
		if (pivot == -1)
	           process(ar, 0, end-1, k);
		if(k == ar[pivot]) {
			System.out.println("Found the number at index "+pivot);
			return ;
		}
		//if(k < ar[pivot]) {
		if (ar[0] <= k) {
			process(ar, start, pivot, k);
		} else {
			process(ar, pivot+1, end, k);
		}
	}
	private static int getPivot(int ar[], int start, int end) {
		if (end < start)  
            return -1;
       if (end == start) 
            return start;
		int pivot = (end+start)/2;
		if(pivot < end && ar[pivot] > ar[pivot+1]) {
			return pivot+1;
		} else if(pivot > start && ar[pivot] < ar[pivot-1]) {
			return pivot-1;
		}
		return pivot;
	}
}
