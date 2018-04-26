package com.ankit.sorting;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][]matrix = new int[3][4];
		matrix[0][0]=23;
		matrix[0][1]=56;
		matrix[0][2]=77;
		matrix[0][3]=99;
		matrix[1][0]=23;
		matrix[1][1]=56;
		matrix[1][2]=77;
		matrix[1][3]=99;
		matrix[2][0]=23;
		matrix[2][1]=56;
		matrix[2][2]=77;
		matrix[2][3]=99;
		for(int []ii : matrix) {
			for(int j : ii) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		rotate(matrix,3);
		System.out.println("After rotate");
		for(int []ii : matrix) {
			for(int j : ii) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] matrix, int i) {
		int temp[][]=new int[matrix.length][i];
		if(i>0) {
			int count=0;
			for(int aa[]:matrix) {
				int internalCount = 0;
				int replaceIndex=0;
				while(internalCount < aa.length) {
					if(internalCount < i) {
						temp[count][internalCount]=aa[internalCount];
						//aa[(aa.length-1)-internalCount]=aa[internalCount];
					} else {
						aa[replaceIndex]=aa[internalCount];
						if(replaceIndex < i) {
							aa[internalCount] = temp[count][replaceIndex];
							replaceIndex++;
						}
					}
					internalCount++;
				}
				count++;
			}
		}
	}
}
