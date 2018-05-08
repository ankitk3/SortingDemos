package com.ankit.problems;

public class ArrayAccoringGivenIndexArray {

	public static void main(String[] args) {
		//input 40 90 30 10 20
		//Output 30 20 40 10 90
		int arr[]=new int[] {40,90,30,10,20};
		int index[] = {2,4,0,3,1};
		//new ArrayAccoringGivenIndexArray().process(arr, index);
		System.out.println("================");
		arr=new int[] {50,40,70,60,90};
		index = new int[]{3,2,4,1,0};
		new ArrayAccoringGivenIndexArray().process(arr, index);
	}
	private void process(int arr[], int index[]) {
		for(int i : index) {
			System.out.print(" "+i+" ");
		}
		System.out.println();
		for(int i : arr) {
			System.out.print(i+" ");
		}
		for(int j=0;j<index.length;j++) {
			if(index[j]!=j) {
				int temp = index[j];
				int tempValue = arr[j];
				index[j]=index[temp];
				arr[j] = arr[temp];
				index[temp] = temp;
				arr[temp] = tempValue;
				/*while(temp<=j) {
					int temp2 = index[temp];
					int tempValue2 = arr[temp];
					index[temp]=index[temp2];
					arr[temp] = arr[temp2];
					index[temp2] = temp2;
					arr[temp2] = tempValue2;
					temp = temp2;
				}*/
			}
		}
		System.out.println();
		for(int i : index) {
			System.out.print(" "+i+" ");
		}
		System.out.println();
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
