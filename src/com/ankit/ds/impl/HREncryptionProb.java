package com.ankit.ds.impl;

public class HREncryptionProb {

	
	// Complete the encryption function below.
    static String encryption(String s) {
        if(s == null || s.length() <2){
            return s;
        }
        s = s.replaceAll(" ","");
        int row = getSquareRoot(s.length());
        int col = row+1;
        if(row*col < s.length()){
            row+=1;
        }
        char matrix[][] = new char [row][col];
        //int line=0;
        int i=0;
        int j=0;
        for(char c : s.toCharArray()){
            matrix[i][j] = c;
            j++;
            if(j==col){
                i++;
                j=0;
            }
        }
        String output = "";
        for(int k=0;k<col;k++){
            for(int l=0;l<row;l++){
                if(Character.isWhitespace(matrix[l][k]))
                    continue;
                output+=matrix[l][k];
            }
            if(k!=col-1)
                output+=" ";
            // if(l==row-1){

            // }
        }
        //output+="\n";
        return output;
    }
    static int getSquareRoot(int length){
        int num = length;
        int startValue = num/2;
        while(num >= length){
            num = startValue * startValue;
            if(num > length){
                startValue--;
            }
        }
        return startValue;
    }
	public static void main(String[] args) {
		String resp = encryption("feedthedog");
		System.out.println("======");
		System.out.println(resp+"=====");
		System.out.println("======");
	}
}
