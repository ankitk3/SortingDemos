package com.ankit.problems;

import java.util.HashMap;
import java.util.Map;

public class MinDiffSubArray {

	private int [] arr = {3,6,7,9,8,12,8,6,6,2,2,2,2,2};
	private void printArr(int[]a) {
		for(int i : a) {
			System.out.print(i+"\t");
		}
		System.out.println();
	}
	private void findMinDiff() {
		printArr(arr);
		Map<Integer,Integer> map = new HashMap<>();
		//int []tempArr = new int[arr.length];
		//int j=0;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		System.out.println(map);
		int totOcc = 0;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			if(map.containsKey(entry.getKey()+1)) {
				int tempOcc = entry.getValue()+map.get(entry.getKey()+1);
				if(tempOcc>totOcc) {
					totOcc = tempOcc;
				}
			}
		}
		System.out.println("TotalSubarray size = "+totOcc);
	}
	public static void main(String[] args) {
		MinDiffSubArray a = new MinDiffSubArray();
		a.findMinDiff();
	}
}
