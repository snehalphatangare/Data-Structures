/*
 * Given an array, print the Next Smaller Element (NSE) for every element. The Next smaller Element for an element x is the first smaller element on the right side of x in array.
 *  Elements for which no smaller element exist, consider next smaller element as 0.
 */
package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
	
	//Approach 1
	//Brute-force: For each element, find the next smaller element in array
	//T.C = O(n^2)

	/*Approach 2-  Using Stack
	 * Since we have to find next smaller element we can use LIFO i.e stack(if smallest element to right was to be found then stack could not be used)
	 * Iterate the elements from right to store next smaller elements in stack.
	 * As long as stack top element is bigger than the given number we will keep popping the stack. At some point either a smaller element will appear or 
	 * stack will become empty. At this point we will replace the array element with the top element of the stack or put zero if the stack is empty. 
	 * This way we will try to put the number on stack then replace the number in the array and keep on moving from right to left. 
	 * T.C= O(N). S.C=O(N)
	 */
	private static void printNSE(int[] array){
		Stack<Integer> s= new Stack<Integer>();
		int[] output= new int[array.length];
		//Since we want smaller elements to right, iterate from right of array and push smaller elements to stack
		for(int i=array.length-1;i>=0;--i)
		{
			int currentNum=array[i];
			//Check isEmpty stack. If yes, no smaller element ,hence replace element by 0
			if(s.isEmpty())
			{
				output[i]=0;
				s.push(currentNum);
				continue;
			}
			//Else look into stack for smaller element. Pop the elements larger than currentNum
			while(!s.isEmpty() && currentNum<=s.peek()){
				s.pop();
			}
			//Either next smaller element is found or stack has become empty
			if(s.isEmpty()){
				output[i]=0;
				s.push(currentNum);
			}
			else{
				output[i]=s.peek();
				s.push(currentNum);
			}
		}
		
		System.out.println("NSE Updated array is "+Arrays.toString(output));
	}
	
	/*
	 * Implementation for Next greater element in array.
	 * Elements for which no greater element exist, consider next greater element as -1.
	 */
	private static void printNGE(int[] array){
		Stack<Integer> s= new Stack<Integer>();
		int[] output= new int[array.length];
		//Since we want smaller elements to right, iterate from right of array and push greater elements to stack
		for(int i=array.length-1;i>=0;--i)
		{
			int currentNum=array[i];
			//Check isEmpty stack. If yes, no smaller element ,hence replace element by 0
			if(s.isEmpty())
			{
				output[i]=-1;
				s.push(currentNum);
				continue;
			}
			//Else look into stack for greater element. Pop the elements smaller than currentNum
			while(!s.isEmpty() && currentNum>=s.peek()){
				s.pop();
			}
			//Either next greater element is found or stack has become empty
			if(s.isEmpty()){
				output[i]=-1;
				s.push(currentNum);
			}
			else{
				output[i]=s.peek();
				s.push(currentNum);
			}
		}
		
		System.out.println("NGE Updated array is "+Arrays.toString(output));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array={3,4,2,6,5,1,8,4};
		printNSE(array);
		
		// Similar implementation for Next greater element printNGE. Only difference is put greater elements in stack
		array=new int[]{4,5,2,25};
		printNGE(array);
	}

}
