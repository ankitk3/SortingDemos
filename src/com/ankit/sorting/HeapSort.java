package com.ankit.sorting;

//This is using Max Heap
public class HeapSort {

	static int[] ar = { 4, 5, 12, 2, 3, 10 };

	private static void print() {
		for (int i : ar) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		sort();
		int largest = kthLargest(3);
		System.out.println("Kth Largest = "+largest);
	}

	public static void sort() {
		print();
		int n = ar.length;
		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(ar, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;

			// call max heapify on the reduced heap
			heapify(ar, i, 0);
		}
		print();
	}
	public static int kthLargest(int k) {
		print();
		int largest = -1;
		for (int i = ar.length / 2 - 1; i >= 0; i--) {
			heapify(ar, ar.length, i);
		}
		print();
		for (int i = ar.length - 1; i >= k; i--) {
			int temp = ar[0];
			ar[0] = ar[i];
			ar[i] = temp;
			heapify(ar, i, 0);
			largest = ar[i];
		}
		print();
		return largest;
	}
	public static void heapify(int[] arr, int n, int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int largest = i;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (i != largest) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, n, largest);
		}
	}
}
