/*
 * Problem: Implement a method to perform basic string compression using the contents of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3
 * If compressed string is greater than original, return original string.
 */
package Strings;

import java.util.Scanner;

public class StringCompression {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		 System.out.println("\n Enter string");
	    String str1  = scan.next();
	    
	    String result=stringCompression(str1);
	    System.out.println("REsult ="+result);
	    }
	
	private static String stringCompression(String str){
		if (str.isEmpty()) 
			return "";

	    int count = 1;
	    char last = str.charAt(0);
	    StringBuffer buf = new StringBuffer(str.length());
	    for (int i=1; i<str.length(); i++) {
	      char next = str.charAt(i);
	      if (last == next) {
	        count++;
	      } else {//If different character, reset counter and set last to new character
	        buf.append(last).append(count);
	        count = 1;
	        //set last to new character
	        last = next;
	      }
	    }
	    //append the last unique character
	    buf.append(last).append(count);
	    System.out.println("Compressed string is "+buf);
	    return buf.length()<str.length() ? buf.toString() : str;

	}
}
