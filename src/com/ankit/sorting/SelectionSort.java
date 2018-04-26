package com.ankit.sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int countStep=0;
		int ar[] = new int []{6,5,4,3,2,1};
		ar = new int []{9,8,7,4,5,6};
		for(int i=ar.length-1;i>0;i--) {
			int maxIndex=0;
			for(int j=0; j<=i; j++) {
				if(ar[maxIndex] < ar[j]) {
					maxIndex=j;
				}
				if(j==i) {
					int temp = ar[maxIndex];
					ar[maxIndex]=ar[j];
					ar[j]=temp;
				}
				countStep++;
			}
			System.out.println("MaxIndex="+maxIndex);
			for(int n:ar)
				System.out.print(n+" ");
			System.out.println();
		}
		for(int i:ar)
			System.out.print(i+" ");
		System.out.println("Countstep="+countStep);
	}
}