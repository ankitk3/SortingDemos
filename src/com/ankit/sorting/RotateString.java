package com.ankit.sorting;

public class RotateString {

	public static void main(String[] args) {
		int d = 2;
		String str = "abcdef";
		leftRotate(str,d);
		rightRotate(str,d);
		leftRotateInPlace(str,d);
	}
	private static void leftRotate(String str, int d) {
		String subStr = str.substring(0, d);
		String st = str.substring(d,str.length())+subStr;
		System.out.println(st);
	}
	private static void rightRotate(String str, int d) {
		String subStr = str.substring(str.length()-d, str.length());
		String st = subStr+str.substring(0, str.length()-d);
		System.out.println(st);
	}
	private static void leftRotateInPlace(String str, int d) {
		char charArr []= str.toCharArray();
		for(int i=0;i<charArr.length;i++) {
			if(i < d) {
				char temp = charArr[i];
				charArr[i]=charArr[charArr.length-1-(d+i)];
				charArr[charArr.length-1-(d+i)]=temp;
			}
		}
		System.out.println(new String(charArr));
	}
}
