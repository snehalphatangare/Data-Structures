import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,4,6,8,3};
		int[] ans = insertionSort(arr);
		System.out.println(Arrays.toString(ans));
	}
	
	// average, worst complexity O(n^2)
	// best O(n)
	//space O(1): variable key. This is an inplace sorting algo
	public static int[] insertionSort(int arr[]){
        for (int i=1; i<arr.length; ++i)//Start with the 1st element 
        {
            int key = arr[i];//key to be compared to elements to the left
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && key<arr[j])
            {
                arr[j+1] = arr[j];//move element 1 position to the right
                j = j-1;
            }
            arr[j+1] = key;//Put key at j+1 because j was decremented just before the condition fails
        }
        return arr;
	}

}
