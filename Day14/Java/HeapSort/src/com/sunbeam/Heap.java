package com.sunbeam;

public class Heap {
	private int SIZE;
	public Heap(int length) {
		SIZE = length-1;
	}
	
	public void heapify(int arr[]) {
		//1. start with first parent from right side
		for(int i = SIZE/2 ; i >= 1 ; i--) {
			int pi = i;
			int ci = pi * 2;
			while(ci <= SIZE) {
				//4.2 find index if max child
				if((ci + 1) <= SIZE &&  arr[ci + 1] > arr[ci])
					ci = ci + 1;
				//4.3 if max child is already less than parent
				if(arr[ci] < arr[pi])
					break;
				//4.4 if max child is greater than parent, then swap parent and child
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//4.5 update parent and child indices
				pi = ci;
				ci = pi * 2;
			}	
		}
	}
	
	public int delete(int arr[]) {
		//1. swap first and last element of heap
		int max = arr[1];		
		arr[1] = arr[SIZE];
		arr[SIZE] = max;
		//3. decrease size of heap by one
		SIZE--;
		//4. adjust position of root by comparing it with all its descendents
		//4.1 find indices of parent and child
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			//4.2 find index if max child
			if((ci + 1) <= SIZE &&  arr[ci + 1] > arr[ci])
				ci = ci + 1;
			//4.3 if max child is already less than parent
			if(arr[ci] < arr[pi])
				break;
			//4.4 if max child is greater than parent, then swap parent and child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//4.5 update parent and child indices
			pi = ci;
			ci = pi * 2;
		}	
		//5. return maximum element
		return max;
	}
	
	public void deleteHeap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++)
			delete(arr);
	}
	
	public void heapSort(int arr[]) {
		//1. create heap
		heapify(arr);
		//2. delete heap
		deleteHeap(arr);
	}

}
