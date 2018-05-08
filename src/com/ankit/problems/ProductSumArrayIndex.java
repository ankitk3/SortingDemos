package com.ankit.problems;

public class ProductSumArrayIndex {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		int previous = -1;
		for(int i=0;i<arr.length;i++) {
			int value = arr[i];
			
			if(i > 0) {
				value *=previous;
			}
			if(i<arr.length-1) {
				value +=arr[i+1];
			}
			previous = arr[i];
			arr[i]=value;
		}
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
}
