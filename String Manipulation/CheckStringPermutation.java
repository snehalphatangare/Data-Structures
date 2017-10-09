/*
 * Check Whether Two Strings are Permutations of each other. Try not to use additional space
 */
package Strings;
import java.util.Arrays;
import java.util.Scanner;

public class CheckStringPermutation {
	
	//Approach 1
	//Iterate and compare every element with other to find 
	//T.C=O(n^2) S.C=O(1)
	
	/*Approach 2
	Sort both strings and compare
	T.C=O(N LogN) S.C=O(1)*/
	private static Boolean checkPermutation(String str1,String str2){
		if(str1==str2)
			return true;
		if((str1==null || str2==null) || (str1!=null && str2!=null && str1.length()!=str2.length()))
			return false;
		
		char[] temp1 = str1.toCharArray();
		Arrays.sort(temp1);
		String newStr1 = new String(temp1);
		temp1 = str2.toCharArray();
		Arrays.sort(temp1);
		String newStr2 = new String(temp1);
		System.out.println("string 1 and 2 are "+newStr1+" "+newStr2);
		return newStr1.equals(newStr2);
	}
	
	/*Approach 3
	Use HashTable to store elements of longer array and its count
	Navigate the smaller string. check if that char­ac­ter exist­ing in hash table, if yes then decrease its count by 1 and if it doesn’t exist then return false.
	If for an element the count is already 0 before decrementing, then return false.
	T.C=O(N) S.C=O(N)*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		 System.out.println("\n Enter 1st string");
         String str1  = scan.next();
         System.out.println("\n Enter 2nd string");
         String str2  = scan.next();
         
         if(checkPermutation(str1,str2)){
        	 System.out.printf(" %s is permutation of %s",str2,str1);
         }else
        	 System.out.printf(" %s is not permutation of %s",str2,str1);
        	 
	}

}
