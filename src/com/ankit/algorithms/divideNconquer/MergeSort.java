package com.ankit.algorithms.divideNconquer;

/**
 * 
 * @author Vashishta.Ankit
 * 
 *         Running time complexity : Average Case - O(nlogn)
 *
 */
public class MergeSort {

	public static void main(String args[]) {

		MergeSort mergeSort = new MergeSort();
		// Integer[] arr = { 5, 2, 4, 3, 6, 1 }; { 3, 41, 52, 26, 38, 57, 9, 49 }
		Integer[] arr = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
		System.out.println(arr.length);
		mergeSort.mergeSort(arr, 0, arr.length - 1);
		for (Integer i : arr) {
			System.out.print(i + " , ");
		}
	}

	private void mergeSort(Integer[] arr, int p, int r) {
		if (p < r) {
			// System.out.println(p + " " + r);
			int q = (p + r) / 2;
			mergeSort(arr, p, q);
			mergeSort(arr, q + 1, r);
			merge(arr, p, q, r);
		}
	}

	// { 5, 2, 4, 3, 6, 1 };
	private void merge(Integer[] arr, int p, int q, int r) {
		System.out.println(p + " " + q + " " + r);
		int size1 = (q - p) + 1;
		int size2 = r - q;
		Integer[] subArray1 = new Integer[size1 + 1]; // The array is initialized with a size greater than the evaluated
														// size, to accommodate a sentinel value(null) marking the end
														// of array.
		Integer[] subArray2 = new Integer[size2 + 1];
		for (int i = 0; i < size1; i++) {
			subArray1[i] = arr[p + i];
		}
		for (int i = 1; i <= size2; i++) {
			subArray2[i - 1] = arr[q + i];
		}
		int i = 0, j = 0;
		for (int count = p; count <= r; count++) {
			if (subArray1[i] != null && (subArray2[j] == null || subArray1[i] <= subArray2[j])) {
				arr[count] = subArray1[i];
				i++;
			} else {
				arr[count] = subArray2[j];
				j++;
			}
		}
		System.out.print("");
	}

}
