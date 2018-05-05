package com.ankit.sorting;

public class HeapSort {

	static int[] ar= {4,5,12,2,3,10};
	private static void print() {
		for(int i : ar) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		print();
		/*for(int i=ar.length/2-1;i>=0;i--) {
			heapify(ar, ar.length, i);
		}*/
		for(int i=ar.length-1;i>=0;i--) {
			int temp=ar[0];
			ar[0]=ar[i];
			ar[i]=temp;
			heapify(ar, i, 0);
			System.out.print(i+"::");
			print();
		}
		print();
	}
	public static void heapify(int []arr,int n, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		if(l<n && arr[l]>arr[largest]) {
			int temp = arr[l];
			arr[l]=arr[largest];
			arr[largest]=temp;
		}
		if(r<n && arr[r]>arr[largest]) {
			int temp = arr[r];
			arr[r]=arr[largest];
			arr[largest]=temp;
		}
		if(i!=largest) {
			heapify(arr,n,largest);
		}
	}
}
