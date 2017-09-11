
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,4,6,8,3};
		int[] ans = bubbleSort(arr);
		System.out.println(Arrays.toString(ans));
		
		ans = bubbleSortOptimized(arr);
		System.out.println(Arrays.toString(ans));
	}
	
		// average, worst complexity O(n^2)
		// best O(n^2)
		//space O(1)
		// compare two elements and put largest lelement in last
		public static int[] bubbleSort(int arr[]){
			
			
			if(arr==null || arr.length==0)
				return null;
			
			//After each iteration of i 1 maximum element goes to its right position 
			int i, j, temp;
			for (i = 0; i < arr.length - 1; i++) {
				for (j = 0; j < (arr.length - 1 - i); j++) {// -i because i number of elements are already at their correct postions
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
			return arr;
		}
		
		//The above function always runs O(n^2) time even if the array is sorted. It can be optimized by
		//stopping the algorithm if inner loop didn’t cause any swap.
		// average, worst complexity O(n^2)
		// best O(n), outer loop will run exactly once and inner loop will run (n-1) times
		//space O(1)
		public static int[] bubbleSortOptimized(int arr[]){
			
			if(arr==null || arr.length==0)
				return null;
			
			//After each iteration of i 1 maximum element goes to its right position 
			int i, j, temp;
			Boolean swapped=true;
			for (i = 0; i < arr.length - 1; i++) {
				swapped=false;
				for (j = 0; j < (arr.length - 1 - i); j++) {// -i because i number of elements are already at their correct postions
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						swapped=true;
					}
				}
				// IF no two elements were swapped by inner loop, then array is sorted
			     if (swapped == false)
			        break;
			}
			
			return arr;
		}

}
