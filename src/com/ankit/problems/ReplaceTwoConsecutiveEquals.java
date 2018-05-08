package com.ankit.problems;

public class ReplaceTwoConsecutiveEquals {

	private static void process(int arr[]) {
		
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i] == arr[i+1]) {
				arr[i]=arr[i]+1;
			}
			if(i<arr.length-1) {
				if(arr[i] == arr[i+1]) {
					arr[i]=arr[i]+1;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[]=new int[] {5,2,1,1,2,2};
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		process(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
