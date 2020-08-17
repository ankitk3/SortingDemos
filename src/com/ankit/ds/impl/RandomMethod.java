package com.ankit.ds.impl;

public class RandomMethod {

	private static void print(int arr[]) {
		for(int i : arr)
			System.out.print(i+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[]= {5,4,3,2,1};
		print(arr);
		for(int i=arr.length/2-1;i>=0;i--) {
			checkAndReplace(arr, i);
			print(arr);
		}
		print(arr);
	}
	private static void checkAndReplace(int[] arr, int i) {
		if(arr[i] > arr[2*i+1]) {
			int temp = arr[2*i+1];
			arr[2*i+1] = arr[i];
			arr[i]=temp;
		}
		if(arr[i] > arr[2*i+2]) {
			int temp = arr[2*i+2];
			arr[2*i+2] = arr[i];
			arr[i]=temp;
		}
	}
	public static void minHeap(int arr[]) {
		//for
	}
}
