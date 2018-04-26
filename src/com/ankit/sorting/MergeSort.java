package com.ankit.sorting;

public class MergeSort {

	private static int countStep = 0;
	private static int subArr[] ;
	public static void main(String[] args) {
		sortAscending();
		//sortDescending();
	}
	private static void sortAscending() {
		int ar []= new int []{9,5,8,4,7,6};
		//ar = new int []{9,8,7,6,5,4,3};
//		ar = new int []{4,5,6,7,8,9};
		subArr = new int[ar.length];
		merge(ar,0,ar.length-1);
		System.out.println("Countstep="+countStep);
	}
	private static void merge(int a[],int start, int end) {
		if(start<end) {
			int middle = start + (end-start)/2;
			System.out.println("In Merge "+start+":"+middle+":"+end);
			merge(a,start, middle);
			merge(a,(middle+1), end);
			for(int i:a)
				System.out.print(i+" ");
			mergeGroups(a, start, middle, end);
		}
	}
	private static void mergeGroups(int ar[], int start,int middle, int end) {
		System.out.println("In merge groups "+start+":"+middle+":"+end);
		int s = start,k = middle+1, e = end;
		int index = start;
		int totalNum = end-start;
		while(s <= middle && k <= e) {
			if(ar[s]>ar[k]) {
				subArr[index]=ar[k];
				k++;
			} else {
				subArr[index]=ar[s];
				s++;
			}
			index++;
			countStep++;
		}
		//Filling remaining indexes.
		while(s<=middle || k<=e) {
			if(s <= middle) {
				subArr[index]=ar[s];
				s++;
			}
			if(k<=e) {
				subArr[index]=ar[k];
				k++;
			}
			index++;
		}
		for(int i=0;i<=totalNum;i++) {
			//System.out.print(subArr[start+i]+" ");
			ar[start+i]=subArr[start+i];
		}
		//System.out.println();
		for(int i:ar)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("--------------");
	}
}
