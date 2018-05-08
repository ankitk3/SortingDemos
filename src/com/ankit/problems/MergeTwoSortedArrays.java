package com.ankit.problems;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int arr[] = {4,7,8,9,10};
		int arr2[] = {2,3,5,6,12};
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : arr2) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("================");
		sort(arr, arr2);
		System.out.println();
		System.out.println("+++++++++++++++++++");
		arr = new int []{1,5,9,10,15,20};
		arr2 = new int[]{2,3,8,13};
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i : arr2) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("================");
		sort(arr, arr2);
	}
	private static void insertionSort(int[]arr2, int minPosition, int value) {
		int i=0;
		while(i < arr2.length && value > arr2[i]) {
			i++;
		}
		i=i-1;
		while(minPosition < i) {
			arr2[minPosition]=arr2[minPosition+1];
			minPosition++;
		}
		arr2[minPosition]=value;
		
	}
	private static void sort(int[] arr, int[] arr2) {
		int i=0,j=0;
		while(i<arr.length && j < arr2.length) {
			if(arr[i]>arr2[j]) {
				int temp = arr[i];
				arr[i]=arr2[j];
				insertionSort(arr2, j,temp);
			}
			i++;
		}
		for(int k : arr) {
			System.out.print(k+" ");
		}
		System.out.println();
		for(int k : arr2) {
			System.out.print(k+" ");
		}
	}
}
