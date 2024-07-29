package com.sunbeam;

import java.util.Scanner;

public class BinarySearchMain {
	
	public static int binarySearch(int arr[], int N, int key) {
		int left = 0, right = N-1, mid;
			
		while(left <= right) {
			//1. divide collection(array) into two parts (find middle element)
			mid = (left + right)/2;
			//2. compare middle element with key
			if(key == arr[mid])
				//3. if key is matching, then return true/index
				return mid;
			//4. if key is less than middle element, search it into left partition
			else if(key < arr[mid])
				right = mid - 1;
			//5. if key is greater than middle element, search it into right partition
			else
				left = mid + 1;
		}//6. repeat step 1 to 5 untill key is found
		//7. if key is not matching, then  return false/-1
		return -1;
	}
	
	public static int binarySearch(int arr[], int left, int right, int key) {
		//0. stop if partition is invalid
		if(left > right)
			return -1;
		//1. divide collection(array) into two parts (find middle element)
		int mid = (left + right)/2;
		//2. compare middle element with key
		if(key == arr[mid])
			//3. if key is matching, then return true/index
			return mid;
		//4. if key is less than middle element, search it into left partition
		if(key < arr[mid])
			return binarySearch(arr, left, mid-1, key);
		//5. if key is greater than middle element, search it into right partition
		else
			return binarySearch(arr, mid+1, right, key);
	}
	
	

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		Scanner sc = new Scanner(System.in);
		//0. decide key to be searched
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		//int index = binarySearch(arr, arr.length, key);
		int index = binarySearch(arr, 0, arr.length-1, key);
		if(index == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at index " + index);
		
		sc.close();

	}

}
