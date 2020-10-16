/**
 * 
 */
package com.ankit.algorithms.sorting;

/**
 * @author Vashishta.Ankit
 *
 * Working - Picking up the first element of the array/subarray,
 * we try and put the element at its correct position. And divide 
 * the array on the left and right of the element.
 * There are two sub algos of this algo.
 * 1. Partition - Positions the first element of the array correctly.
 * 2. sort - calls partition and divides the array in two parts,
 * 			 on the basis of partition.
 * 
 * Example - Suppose we have to sort the array - { 4, 3, 5, 1, 2, 8, 6 }.
 * Cycle1 :
 * { 4, 3, 5, 1, 2, 8, 6 } -> { 2, 3, 5, 1, 4, 8, 6 }
 * Step 1 - We start from the right end of array, and compare with the element, 
 * here, 4 to find an element smaller than 4. And as we find an element
 * smaller, we swap the positions of the elements.
 * 
 * { 2, 3, 5, 1, 4, 8, 6 } -> { 2, 3, 4, 1, 5, 8, 6 }
 * Step 2 - Now, we start from the left end of the array and look for an element
 * greater than the element. Which in this case, we encounter 5. We swap the positions
 * of 4 and 5.
 * 
 * { 2, 3, 4, 1, 5, 8, 6 } -> { 2, 3, 1, 4, 5, 8, 6 }
 * Step 3 - Now, we start moving again from right to left finding a number smaller
 * than 4, and we start from 5, because to the right of it, the elements are not
 * smaller than the element(4). So we get a number smaller than 4, ie 1.
 * Hence, we swap 1 and 4.
 * 
 * Now, 4 is at correct position, as when we start moving from left to right
 * again from 1, we will encounter 4 before we encounter any number larger than 4.
 * 
 * Next Step would be to divide the array in two parts ie. the left of the 
 * element and right of it. So, we have ->{2, 3, 1} and {5, 8, 6} as subarrays to 
 * be sorted.
 * 
 * Cycle 2:
 * {2, 3, 1} -> {1, 3, 2}	Main Array - {1, 3, 2, 4, 5, 8, 6}
 * {1, 3, 2} -> {1, 2, 3}	Main Array - {1, 2, 3, 4, 5, 8, 6}
 * And
 * {5, 8, 6} -> {5, 8, 6}	Main Array - {1, 2, 3, 4, 5, 8, 6}
 * No Change, now the array has one more subarray -> {8, 6}.
 * 
 * Cycle 3
 * {8, 6} -> {6, 8}		Main Array - {1, 2, 3, 4, 5, 6, 8}
 * {6, 8} -> {6, 8}		Main Array - {1, 2, 3, 4, 5, 6, 8}
 * 
 * Running time complexity :
 * Best Case - O(nlogn)
 * Average Case - O(nlogn)
 * Worst Case - O(n^2)
 * 
 */
public class QuickSort {

	public static void main(String args[]) {
		Integer[] arr = { 4, 3, 5, 1, 2, 8, 6 };

		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length - 1);
		quickSort.printArray(arr);

	}

	/**
	 * Retrieves the point of partition in the sub array passed
	 * and divides the array on that partition point.
	 *
	 * This algo works on divide and conquer methodology.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public void sort(Integer[] arr, int start, int end) {
		if (start < end) {
			int position = partition(arr, start, end);
			sort(arr, start, position - 1);
			sort(arr, position + 1, end);
		}
	}

	/**
	 * Finds the correct position of the first element of the array passed.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return position of the element, to divide the array.
	 */
	public int partition(Integer[] arr, int start, int end) {
		Integer element = arr[start];
		int position = start;
		while (start < end) {
			while (end > position) {
				if (element > arr[end]) {
					arr[position] = arr[end];
					arr[end] = element;
					start = position;
					position = end;
				} else {
					end = end - 1;
				}
			}
			while (start < position) {
				if (element < arr[start]) {
					arr[position] = arr[start];
					arr[start] = element;
					position = start;
				} else {
					start = start + 1;
				}
			}
		}
		return position;
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
