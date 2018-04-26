package com.ankit.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		sortAscending();
		//sortDescending();
	}
	private static void sortAscending() {

		int countStep = 0;
		int ar []= new int []{9,5,8,4,7,6};
		ar = new int []{9,8,7,6,5,4};
//		ar = new int []{4,5,6,7,8,9};
		for(int j=1;j<ar.length;j++) {
			int i=j;
			if(ar.length>1) {
				while(i > 0 && ar[i-1] > ar[i]) {
					int temp=ar[i-1];
					ar[i-1]=ar[i];
					ar[i]=temp;
					i--;
					countStep++;
				}
				countStep++;
				for(int n:ar)
					System.out.print(n+" ");
				System.out.println();
			}
		}
		System.out.println();
		for(int i:ar)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("Countstep="+countStep);
	}
	private static void sortDescending() {
		int countStep = 0;
		int ar []= new int []{9,5,8,4,7,6};
		ar = new int []{9,8,7,4,5,6};
		ar = new int []{4,5,6,7,8,9};
		for(int j=1;j<ar.length;j++) {
			int i=j;
			if(ar.length>1) {
				while(i > 0 && ar[i-1] < ar[i]) {
					int temp=ar[i-1];
					ar[i-1]=ar[i];
					ar[i]=temp;
					i--;
					countStep++;
				}
				for(int n:ar)
					System.out.print(n+" ");
				System.out.println();
			}
		}
		System.out.println();
		for(int i:ar)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("Countstep="+countStep);
	}
}
