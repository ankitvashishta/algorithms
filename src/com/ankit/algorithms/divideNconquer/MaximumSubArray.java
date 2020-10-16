package com.ankit.algorithms.divideNconquer;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] array = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		Map<String, Integer> placeHolders = new HashMap<String, Integer>();
		findMaximumSubArray(array, 0, array.length - 1, placeHolders);
		System.out.println(placeHolders.get("low"));
		System.out.println(placeHolders.get("high"));
		System.out.println(placeHolders.get("sum"));

	}

	public static void findMaximumSubArray(int[] array, int low, int high, Map<String, Integer> placeHolders) {
		if (high == low) {
			inputPlaceHolders(low, high, array[low], placeHolders);
		} else {
			int mid = (low + high) / 2;
			findMaximumSubArray(array, low, mid, placeHolders);
			int leftLow = placeHolders.get("low");
			int leftHigh = placeHolders.get("high");
			int leftSum = placeHolders.get("sum");
			findMaximumSubArray(array, mid + 1, high, placeHolders);
			int rightLow = placeHolders.get("low");
			int rightHigh = placeHolders.get("high");
			int rightSum = placeHolders.get("sum");
			findMaxCrossingSubArray(array, low, mid, high, placeHolders);
			int crossLow = placeHolders.get("low");
			int crossHigh = placeHolders.get("high");
			int crossSum = placeHolders.get("sum");

			if (leftSum >= rightSum && leftSum >= crossSum) {
				inputPlaceHolders(leftLow, leftHigh, leftSum, placeHolders);
			} else if (rightSum >= leftSum && rightSum >= crossSum) {
				inputPlaceHolders(rightLow, rightHigh, rightSum, placeHolders);
			} else {
				inputPlaceHolders(crossLow, crossHigh, crossSum, placeHolders);
			}
		}
	}

	public static void findMaxCrossingSubArray(int[] array, int low, int mid, int high,
			Map<String, Integer> placeHolders) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = -1;
		for (int i = mid; i >= low; i--) {
			sum = sum + array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = -1;
		for (int i = mid + 1; i <= high; i++) {
			sum = sum + array[i];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		inputPlaceHolders(maxLeft, maxRight, leftSum + rightSum, placeHolders);
	}

	private static void inputPlaceHolders(int low, int high, int sum, Map<String, Integer> placeHolders) {
		placeHolders.put("low", low);
		placeHolders.put("high", high);
		placeHolders.put("sum", sum);
	}

}
