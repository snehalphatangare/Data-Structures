import java.util.Arrays;

/*Selection sort is like sorting playing cards. Find the smallest card put it in right position, then next smallest card.
This algorithm first finds the smallest element in the array and exchanges it with the element in the first position, 
then find the second smallest element and exchange it with the element in the second position, 
and continues in this way until the entire array is sorted.*/

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,4,6,8,3};
		int[] ans = selectionSort(arr);
		System.out.println(Arrays.toString(ans));
	}
	
	// average, worst complexity O(n^2)
	// best O(n^2)
	//space O(1) The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
	public static int[] selectionSort(int arr[])
    {
		//After each iteration of i the next smallest element goes to the ith position 
        for (int i = 0; i < arr.length-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            // Put the minimum found element in its right position i.e ith index
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
