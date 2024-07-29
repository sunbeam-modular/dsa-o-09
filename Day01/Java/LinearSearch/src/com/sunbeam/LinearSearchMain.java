package com.sunbeam;

import java.util.Scanner;

public class LinearSearchMain {
	
	
	public static int linearSearch(int arr[], int N, int key) {
		//2. traverse collection (array) from one end to another end
		for(int i = 0 ; i < N ; i++) {
			//3. compare key with each element of an array
			if(key == arr[i])
				//4. if key is matching, then return True/index of array
				return i;
		}
		//5. if key is not matching, then return False/-1 
		return -1;
	}

	public static void main(String[] args) {
		
		int arr[] = {88, 33, 66, 99, 11, 77, 22, 55, 14};
		
		Scanner sc = new Scanner(System.in);
		//1. decide key/data to be searched
		System.out.print("Enter key to be searched : ");
		int key = sc.nextInt();
		
		int index = linearSearch(arr, arr.length, key);
		if(index == -1)
			System.out.println("Key is not found");
		else
			System.out.println("Key is found at index : " + index);
		
		
		sc.close();
	}

}
