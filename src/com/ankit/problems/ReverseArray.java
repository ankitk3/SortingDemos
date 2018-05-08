package com.ankit.problems;

public class ReverseArray {

	private void recursive(int arr[], int i) {
		if(i >= arr.length/2) {
			return;
		}
		int temp = arr[i];
		arr[i]=arr[arr.length-1-i];
		arr[arr.length-1-i]=temp;
		recursive(arr, ++i);
	}
	public static void main(String[] args) {
		int arr[]=new int[] {1,2,3,4,5,6};
		ReverseArray ra = new ReverseArray();
		ra.recursive(arr, 0);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
