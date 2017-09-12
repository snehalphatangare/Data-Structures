
import java.util.Arrays;

/*Bubble Sort algorithm in first pass, we move largest element to end 
 * (Assuming sorting in increasing order). In second pass, we move second largest element to second last position 
 * and so on.
 * */
 
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,4,6,8,3};
		int[] ans = bubbleSort(arr);
		System.out.println(Arrays.toString(ans));
		
		ans = bubbleSortOptimized(arr);
		System.out.println(Arrays.toString(ans));
		
		ans=bubbleSortRecursive(arr,arr.length);
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
		
		//Recursive Bubble Sort has no performance/implementation advantages, but can be a good question to check one’s understanding of Bubble Sort and recursion
		/*Recursion Idea.
		Base Case: If array size is 1, return.
		Do One Pass of normal Bubble Sort. This pass fixes last element of current subarray.
		Recur for all elements except last of current subarray.*/
		public static int[] bubbleSortRecursive(int arr[],int n){
			//Base case
			if(n==1)
				return arr;
			
			//Move largest element to the extreme right
			int temp;
			for (int i = 0; i < n-1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			//Move the next largest element to the extreme right
			int[] ans=bubbleSortRecursive(arr,n-1);
			return ans;
		}
}
