/*
 * Check Whether Two Strings are Permutations of each other
 */
package Strings;
import java.util.Arrays;
import java.util.Scanner;

public class CheckStringPermutation {
	
	private static Boolean checkPermutation(String str1,String str2){
		if(str1==str2)
			return true;
		if((str1==null || str2==null) || (str1!=null && str2!=null && str1.length()!=str2.length()))
			return false;
		
		char[] temp1 = str1.toCharArray();
		Arrays.sort(temp1);
		System.out.println("temp1="+temp1.toString());
		str1 = temp1.toString();
		temp1 = str2.toCharArray();
		Arrays.sort(temp1);
		System.out.println("temp2="+temp1);
		str2 = temp1.toString();
		System.out.println("string 1 and 2 are"+str1+" "+str2);
		return str1.equals(str2);
	}

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
