package com.ankit.problems;

//Example of backtracking
public class PrintAllPossibleString {
	int totalCount=0;
	private void permute(String str, int l, int r) {
		if (l == r) {
			System.out.println(str);
			totalCount++;
		}else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				//str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String s = "ankit";
		PrintAllPossibleString ps = new PrintAllPossibleString();
		ps.permute(s, 0, s.length()-1);
		System.out.println(ps.totalCount);
	}
}
