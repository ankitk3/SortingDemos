package com.ankit.problems;

public class Print2DSortedArray {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 42, 48 }, 
						{ 32, 33, 49, 50 }, 
					  };
		int pointers[]=new int[mat.length];
		
		for(int index=0;index<pointers.length;index++) {
			
		}
		//int i=0, j=0, rowLength = mat.length,colLength = mat[0].length;
		int aa=0;
		while(aa < pointers.length || pointers[aa]<mat[aa].length) {//(i < rowLength || j < colLength) {
			//int smallest = Integer.MAX_VALUE;
			for(aa=0;aa < pointers.length-1;aa++) {
				if(pointers[aa] < mat[aa].length && mat[aa][pointers[aa+1]] < mat[aa+1][pointers[aa+1]]) {
					System.out.println(mat[aa][pointers[aa]]);
					pointers[aa]=pointers[aa]+1;
					
				} else if(pointers[aa] < mat[aa].length) {
					System.out.println(mat[aa+1][pointers[aa]]);
					pointers[aa+1]=pointers[aa+1]+1;
				}
			}
			/*if(i-1 >= 0 && j-1 >= 0 && mat[i][j]>mat[i-1][j] && mat[i][j] > mat[i][j-1]) {
				System.out.println(mat[i][j]);
				i--;
				j--;
				continue;
			}*/
			/*if(i+1 < rowLength && j+1 < colLength && mat[i][j]<mat[i+1][j] && mat[i][j] < mat[i][j+1]) {
				System.out.println(mat[i][j]);
				i++;
				j++;
				continue;
			}
			if(i+1 < rowLength && j+1 < colLength && mat[i][j]<mat[i+1][j] && mat[i][j] > mat[i][j+1]) {
				System.out.println(mat[i][j]);
				i++;
				continue;
			}
			if(i+1 < rowLength && j+1 < colLength && mat[i][j] > mat[i+1][j] && mat[i][j] < mat[i][j+1]) {
				System.out.println(mat[i][j]);
				j++;
				continue;
			}*/
		}
	}
}
