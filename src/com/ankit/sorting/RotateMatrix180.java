package com.ankit.sorting;

public class RotateMatrix180 {

	static int[][]matrix;
	static {
		matrix = new int[4][4];
		matrix[0][0]=1;
		matrix[0][1]=2;
		matrix[0][2]=3;
		matrix[0][3]=4;
		matrix[1][0]=5;
		matrix[1][1]=6;
		matrix[1][2]=7;
		matrix[1][3]=8;
		matrix[2][0]=9;
		matrix[2][1]=10;
		matrix[2][2]=11;
		matrix[2][3]=12;
		matrix[3][0]=13;
		matrix[3][1]=14;
		matrix[3][2]=15;
		matrix[3][3]=16;
	}
	
	public static void main(String[] args) {
		printArray();
		rotate180();
		System.out.println("=======================");
		printArray();
	}
	private static void rotate180() {
		int rowStart=0;
		int rowLength = matrix.length-1;
		while(rowStart <= rowLength) {
			int columnStart = 0;
			int columnLength = matrix[rowStart].length-1;
			int length = matrix[rowStart].length-1;
			if(rowStart==rowLength)
				length/=2;
			while(columnStart <= length) {
				int temp = matrix[rowStart][columnStart];
				matrix[rowStart][columnStart] = matrix[rowLength][columnLength];
				matrix[rowLength][columnLength] = temp;
				columnLength--;
				columnStart++;
			}
			rowStart++;
			rowLength--;
		}
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[row].length;col++) {
				
			}
		}
	}
	private static void printArray() {
		for(int i []: matrix) {
			for(int j : i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
}
