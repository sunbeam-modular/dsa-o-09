import java.util.Arrays;

public class QuickSortMain {
	
	public static void quickSort(int arr[], int left, int right) {
		//0. stop if partition has single element or is invalid
		if(left >= right)
			return;
		//1. select one referance/axis/pivot element from an array (left, right, mid)
		//int pivot = arr[left];
		//2. arrage all smaller elements than pivot on left side of pivot
		//3. arrange all greater elements than pivot on right side of pivot
		int i = left, j = right;
		while(i < j) {
			//i. find greater element than pivot from left side
			for( ; i <= right && arr[i] <= arr[left] ; i++);
			//ii. find less or equal element than pivot from right side
			for( ; arr[j] > arr[left] ; j--);
			//iii. if i and j are not crossed, then swap ith and jth element
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}//iv. repeat above three steps till i and j are not crossed
		//v. if i and j are crossed, then swap jth and pivot element
		int temp = arr[j];
		arr[j] = arr[left];
		arr[left] = temp;
		//4. sort left and right partitions of pivot individually by applying same quick sort algorithm
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}

	public static void main(String[] args) {

		int arr[] = {66, 33, 99, 11, 77, 22, 55, 66, 88};
		
		System.out.println("Array before sort : " + Arrays.toString(arr));

		quickSort(arr, 0, arr.length-1);
		
		System.out.println("Array after sort : " + Arrays.toString(arr));
	}

}
