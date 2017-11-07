package Sorting;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int arr[] = {1,4,6,8,3,4};
		 mergeSort(arr,0,arr.length-1);
		
	}
	
	private static void mergeSort(int[] arr,int low,int high){
		if(low<high){
			int mid=(low+high)/2;
			//System.out.printf("low=%d high=%d mid=%d",low,high,mid);
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	
	private static void merge(int[] arr,int low,int mid,int high){
		// Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; i++)
            L[i] = arr[low + i];
        for (int j=0; j<n2; j++)
            R[j] = arr[mid + 1+ j];
        System.out.printf("low=%d high=%d mid=%d",low,high,mid);
        System.out.println("L[]=" +Arrays.toString(L));
        System.out.println("R[]=" +Arrays.toString(R));
		//int[] temp=new int[arr.length];
        //Merge elements from two sub-arrays. Compare while merging
        //Since we are going to store the result in same array, set index k=low for result array
		int i=0,j=0,k=low;
		while(i<n1 && j<n2){
			if(L[i] <= R[j])
				arr[k++]=L[i++];
			else 
				arr[k++]=R[j++];
		}
		while(i<n1)
			arr[k++]=L[i++];
		while(j<n2)
			arr[k++]=R[j++];
		System.out.println(Arrays.toString(arr));
	}
}
