package com.ankit.sorting;

public class RotateArrayReverse {

	public static void main(String[] args) {
		int ar[] = {5,6,7,1,2,3};
		for(int j:ar) {
			System.out.print(j+"\t");
		}
		int index=0;
		for(int i=0;i<ar.length; i++) {
			if(ar[i]>ar[i+1]) {
				index = i;
				break;
			}
		}
		
		reverse(ar,0,index);
		reverse(ar,index+1,ar.length-1);
		reverse(ar,0,ar.length-1);
		System.out.println();
		System.out.println("==============================");
		for(int j:ar) {
			System.out.print(j+"\t");
		}
	}

	private static void reverse(int[] ar, int i, int index) {
		while(i<=index) {
			int temp = ar[index];
			ar[index] = ar[i];
			ar[i] = temp;
			i++;
			index--;
		}
	}
}
