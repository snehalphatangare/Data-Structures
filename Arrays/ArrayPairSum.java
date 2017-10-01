/*
 * Given an array and a value, find all pairs in array whose sum is equal to the given value.
 */
package Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 4, 7, 5, 9, 10, -1}; 
		//int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11}; target=10
		System.out.println("Set of pairs using approach 2 are: ");
		arrayPairSumTwoPointers(arr,9);
		System.out.println("Set of pairs using hashmap approach are: ");
		arrayPairSumUsingHashSet(arr,9);
	}
	
	//Approach 1
	//Brute-force: For each element, check its sum with every other element to find the pairs.
	//T.C = O(n^2)
	
	
	//Approach 2-  Space effective solution
	//Two pointers: Sort the array and use two pointers. If sum of both the values are equal to given number then pair found. 
	//If the sum of two numbers is less than target then increase the left pointer, else if the sum is greater than target decrement the right pointer
	//Arrays.sort()uses quicksort for primitives. Also it is inplace sorting algo. T.C = O(NLogN). S.C= O(1)
	public static void arrayPairSumTwoPointers(int[] arr,int target){
		if(arr.length<2)
			return;
		//Sort the array
		Arrays.sort(arr);
		//Traverse the array using two pointers at two ends
		int i=0;int j=arr.length-1;
		while(i<j){
			int sum=arr[i]+arr[j];
			if(sum==target){
				System.out.println("("+arr[i]+","+arr[j]+")");
				i++; //Or do j--
			}
			else if(sum<target) //Move to next greater element
				i++;
			else	//Move to next smaller element
				j--;
				
		}
	}
	
	//Approach 3 - Time effective solution
	//Hashmap: Hashset of visited elements. Traverse the array. If (target-element) is in hashmap then print pair. Else add the element to set 
	//(This way 1st time element will not be found in set, hence will be entered.So moving forward in array when we come to the pair of elem in array, the diff of target and this element is already entered in set
	// T.C = O(N). S.C= O(N)
	public static void arrayPairSumUsingHashSet(int[] arr,int target){
		if(arr.length<2)
			return;
		HashSet setOfNumbers=new HashSet<Integer>();
		//Traverse the array
		
		for(int elem: arr){
			int diff=target-elem;
			if(setOfNumbers.contains(diff)){
				System.out.println("("+elem+","+diff+")");
			}
			else {
				setOfNumbers.add(elem);
			}
				
		}
	}


}
