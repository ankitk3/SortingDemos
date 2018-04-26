package com.ankit.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int countStep=0;
		int ar[] = new int []{6,5,4,3,2,1};
		ar = new int []{9,8,7,4,5,6};
		for (int i=ar.length-1;i>0;i--) {
			boolean isChanged = false;
			for(int j=0;j<i;j++) {
				countStep++;
				if(ar[j] > ar[j+1]) {
					int temp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
					isChanged = true;
				}
			}
			for(int n:ar)
				System.out.print(n+" ");
			System.out.println();
			if(!isChanged) {
				break;
			}
		}
		for(int i:ar)
			System.out.print(i+" ");
		System.out.println("Countstep="+countStep);
	}
}
