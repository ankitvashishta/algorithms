package com.ankit.algorithms.sorting;


/**
 * 
 * @author Vashishta.Ankit
 * 
 * Working - For a given array, arrange the element in the part 
 * of the array already traversed. The algorithm works linearly,
 * starting from the position of the array and starts walking 
 * towards the beginning of the array, and places the element 
 * in the already sorted part of the array by shifting the elements.
 * 
 * Example - Suppose, we have to sort the following array:
 * {6, 5, 3, 1, 8, 7, 2, 4}
 * 
 * Step 1:
 * {6, 5, 3, 1, 8, 7, 2, 4} -> {5, 6, 3, 1, 8, 7, 2, 4}
 * 
 * Step 2:
 * {5, 6, 3, 1, 8, 7, 2, 4} -> {3, 5, 6, 1, 8, 7, 2, 4}
 * 
 * Step 3:
 * {3, 5, 6, 1, 8, 7, 2, 4} -> {1, 3, 5, 6, 8, 7, 2, 4}
 * 
 * Step 4:
 * {1, 3, 5, 6, 8, 7, 2, 4} -> {1, 3, 5, 6, 8, 7, 2, 4}
 * 
 * Step 5:
 * {1, 3, 5, 6, 8, 7, 2, 4} -> {1, 3, 5, 6, 7, 8, 2, 4}
 * 
 * Step 6:
 * {1, 3, 5, 6, 7, 8, 2, 4} -> {1, 2, 3, 5, 6, 7, 8, 4}
 * 
 * Step 7:
 * {1, 2, 3, 5, 6, 7, 8, 4} -> {1, 2, 3, 4, 5, 6, 7, 8}
 * 
 * Running time complexity :
 * Best Case - O(n)
 * Average Case - O(n^2)
 * Worst Case - O(n^2)
 *
 */
public class InsertionSort {
	static int counter = 0;

	public static void main(String[] args) {
		
		Integer[] array = { 5, 2, 4, 3, 6, 1, 99, 101, 88, 67, 34, 2, 4, 99, -1 };
		
		InsertionSort insertionSort = new InsertionSort();
		
		insertionSort.sort(array);
		insertionSort.printArray(array);
	}

	/**
	 * Positions the elements in the array in the sorted format.
	 * 
	 * @param array
	 */
	public void sort(Integer[] array) {
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
				counter++;
			}
			array[i + 1] = key;
			counter++;
		}
		System.out.println("\n" + "no of computations : " + counter);
	}

	/**
	 * Output the array to console.
	 * 
	 * @param arr
	 */
	private void printArray(Integer arr[]) {
		System.out.println();
		for (Integer i : arr) {
			System.out.print(i + " , ");
		}
	}
}
