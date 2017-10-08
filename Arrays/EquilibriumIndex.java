package Arrays;

import java.util.Arrays;

/*
 * Given an array find  Equilibrium index. Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes
 * */
public class EquilibriumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = {1,-2,3,-1};
		int[] arr = {-1,3,-4,5,1,-6,2,1};
		System.out.println("Equilibrium indices are: ");
		findEquilibriumIndex(arr);
		
	}
	
	/*Calculate sum of all elements. Iterate over the array. While iterating keep a track of leftsum. At a given element its rightsum =sum-leftsum. Compare two
	 * T.C=O(n) S.C.= constant
	*/
	private static void findEquilibriumIndex(int[] arr){
		if(arr.length==0)
			System.out.println("Empty array ");
		int sum=0;
		//Calculate sum of all elements
		for(Integer i:arr)
			sum+=i;
		//Iterate over the array. While iterating keep a track of leftsum
		int leftsum=0;
		for(int i=0;i<arr.length;i++){
			//Calculate right sum = sum-arr[i]
			sum=sum-arr[i];
			if(leftsum == sum)
				System.out.println(i);
			leftsum+=arr[i];
			
		}
	}
	
	/*Appraoch2
	 * Create two arrays. LeftSum(at an index will store sum of all elements to left of arr[i]). Rightsum.
	 * COmpare elements at same index in both arrays. If same, return that index
	 * T.C=O(n). S.C =O(N)
	 * */

}
