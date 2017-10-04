package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr1 = {4, 1, 0, 2, 2}; 
		//int[] arr2 = {0, 2, 1, 2}; 
		//Input 2
		int[] arr1 = {4, 1, 0, 2, 9, 6,8,7,5,3}; 
		int[] arr2 = {6,4,7,2,1,0,8,3,9}; 
		
		int missingElem=findMissingElement2(arr1,arr2);
		System.out.println("Missing element by approach 2 is: "+missingElem);
		missingElem=findMissingElement3(arr1,arr2);
		System.out.println("Missing element by approach 3 is: "+missingElem);
		missingElem=findMissingElement4(arr1,arr2);
		System.out.println("Missing element by approach 4 is: "+missingElem);
	}
	
	//Approach 1
	//Brute-force: For each element in array1, check if its there in array2. handle case for duplicate elements
	//T.C = O(n^2)
	
	//Approach 2: Sorting the arrays and traversing both arrays
	//T.C= O(n)
	private static int findMissingElement2(int[] arr1,int[] arr2){
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for(int i=0;i<arr1.length-2;i++){ //Length of smaller array
			if(arr1[i]!=arr2[i])
				return arr1[i];
		}
		//If at the end of for loop nothing is returned, means the last element in 1st array is missing element
		return arr1[arr1.length-1];
	}
	
	//Approach 3: Using HashMap of elements in array1 to its count
	//T.C= O(n). S.C= O(n)
	private static int findMissingElement3(int[] arr1,int[] arr2){
		//System.out.println("array 1 :" +Arrays.toString(arr1));
		//System.out.println("array 2 :" +Arrays.toString(arr2));
		HashMap<Integer,Integer> mapNumToCnt= new HashMap<Integer,Integer>();
		for(int num: arr2){ 
			int cnt=0;
			if(mapNumToCnt.containsKey(num)){
				cnt=mapNumToCnt.get(num);
			}
			mapNumToCnt.put(num, ++cnt);
		}
		System.out.println("mapNumToCnt :" +mapNumToCnt);
		for(int num: arr1){ 
			if(mapNumToCnt.containsKey(num)){
				if(mapNumToCnt.get(num)==0)
					return num;
				else{
					int cnt=mapNumToCnt.get(num);
					mapNumToCnt.put(num,--cnt);
				}
			}
			else
				return num;
				
		}
		//If at the end of for loop nothing is returned, means the last element in 1st array is missing element
		return arr1[arr1.length-1];
	}
	
	//Approach 4: XOR. XOR of a number with itself is 0. So XOR of same elements between 2 arrays will result in 0. 
	//Last, XOR of 0 with an element gives the element. Therefore, XOR of 0 and 1 extra element gives the extra element in array1
	//T.C= O(n). S.C = O(1)
	private static int findMissingElement4(int[] arr1,int[] arr2){
		int missingElem=0;
		for(int num: arr1){
			missingElem=missingElem^num;
		}
		for(int num: arr2){
			missingElem=missingElem^num;
		}
		return missingElem;
	}
	
	//Approach 5: Add all the elements in both arrays.  sum1-sum2 = missing element
	//Problem: if the arrays are too long, or the numbers are very large. Then overflow will occur while summing up the numbers.
}
