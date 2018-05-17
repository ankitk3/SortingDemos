package com.ankit.problems;

//Min heap array for descending order
public class MinHeapArray {

	private void print(int arr[]) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int kthSmallest(int arr[], int k) {
		print(arr);
		int largest = -1;
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		print(arr);
		for (int i = arr.length - 1; i >= k; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
			largest = arr[i];
		}
		print(arr);
		return largest;
	}
	
	public void sort(int arr[]) {
		print(arr);
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}
		print(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
		print(arr);
	}

	public void heapify(int arr[], int n, int i) {
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int smallest = i;
		if (l < n && arr[smallest] > arr[l]) {
			smallest = l;
		}
		if (r < n && arr[smallest] > arr[r]) {
			smallest = r;
		}
		if (i != smallest) {
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, smallest);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 4, 6, 8, 2, 1 };
		MinHeapArray min = new MinHeapArray();
		min.sort(arr);
		int largest = min.kthSmallest(arr, 3);
		System.out.println("Kth largest="+largest);
	}
}
