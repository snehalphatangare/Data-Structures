/*
Problem :- Sort an array of 0s & 1s, i.e element at each index of the array is either 0 or 1. 
Implement an efficient algorithm so that the array gets sorted (all '0's are placed before '1's)
*/

import java.util.Arrays;

public class SortArraysWithZerosAndOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,0,1,0,1,0};
		int[] ans = sort(arr);
		System.out.println("After sorting"+Arrays.toString(ans));
	}
	
	public static int[] sort(int[] arr){
		int i = 0;
		int j = arr.length-1;
		   
	   // start traversing the array from end
	   while ( i <=j ) {
	      if (arr[j] == 0) {
	         //swap with element at position i and increment i(since 0 at its right position)
	         int temp=arr[i];
	         arr[i]=arr[j];
	         arr[j]=temp;
	         
	         i++;
	      }
	      else //For 1, decrement j since 1 is at its right postion
	         j--;
	   }
		return arr;
	}
  
  /*Other approaches:
  One approach is counting the no. of '0's and '1s'  and then placing those many 0's followed by respective number or 1s. 
  TC= O(n). (as traversing twice) */

}
