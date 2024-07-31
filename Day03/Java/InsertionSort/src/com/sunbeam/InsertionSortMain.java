package com.sunbeam;

import java.util.Arrays;

public class InsertionSortMain {
	
	public static void insertionSort(int arr[], int N) {
		for(int i = 1 ; i < N ; i++) {
			//1. pick one element of array (start from 1 index)
			int temp = arr[i];
			int j = i - 1;
			//2. compare picked element with all its left neighbours one by one
			//3. if left neighbour is greater than picked element 
			while(j >= 0 && arr[j] > temp) {
				//then move it by one position ahead
				arr[j+1] = arr[j];
				j--;
			}
			//4. insert picked element at its appropriate position 
			arr[j+1] = temp;
		}//5. repeat above steps till array is not sorted
	}

	public static void main(String[] args) {
		int arr[] = {50, 40, 20, 60, 10, 30};
		
		System.out.println("Array  before sort : " + Arrays.toString(arr));

		insertionSort(arr, arr.length);
		
		System.out.println("Array  after sort : " + Arrays.toString(arr));
	}

}
