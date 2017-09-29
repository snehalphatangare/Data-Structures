/*Given a number n, find the smallest number that has same set of digits as n and is greater than n. 
 If x is the greatest possible number with its set of digits, then print “not possible”
Observations:
1. If all digits in descending order, then not possible.
2. If all digits in ascending, then swap last 2 digits
3. Other cases, process number from right side (Find the smallest digit that can be replaced with a slightly greater number(to get greater num). Sort rest in ascending(to get smallest greater num)
	i.Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit
	ii.search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’.
	iii.Swap d and smallest found digit
	iv. Sort the remaining digits from d in ascending order(to get smallest greater number)
	*/


import java.util.*;

public class FindNextGreaterNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 432;
		int ans=findNextGreater(num);
		if(ans==-1)
			System.out.println("No greater number possible");
		else
			System.out.println("Next greater number with same digits = "+ans);
		
		num = 1234;
		ans=findNextGreater(num);
		if(ans==-1)
			System.out.println("No greater number possible");
		else
			System.out.println("Next greater number with same digits = "+ans);
		
		num = 534976;
		ans=findNextGreater(num);
		if(ans==-1)
			System.out.println("No greater number possible");
		else
			System.out.println("Next greater number with same digits = "+ans);
	}
	
	public static int findNextGreater(int num){
		System.out.println("\nGiven number= "+num);
		int[] digits= getDigitsOfNum(num);
		int i;
		for(i=digits.length-1;i>0;i--){
			if(digits[i-1]<digits[i]){
				break;
				
				//Sort the remaining digits to the right of i-1
				//digits.sor
			
			}
		}
		if(i==0)
			return -1;
		else{
			//Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
			int min_index=i;
			for(int j=i+1;j<digits.length;j++){
				if(digits[j] > digits[i-1] && digits[j] < digits[min_index])
					min_index=j;
			}
			//Swap smallest found digit with digits(i-1)
			int temp=digits[i-1];
			digits[i-1]= digits[min_index];
			digits[min_index]=temp;
			//Sort the digits to the right of i-1 in ascending order
			Arrays.sort(digits, i, digits.length);
			
		}
		
		//Convert int[] to int using StringBuilder
		StringBuilder strNum = new StringBuilder();
		for (int d : digits) 
		     strNum.append(d);
		int finalInt = Integer.parseInt(strNum.toString());
		return finalInt;
	}
	
	private static int[] getDigitsOfNum(int num){
		Stack<Integer> digitStack = new Stack<Integer>();
		while(num > 0){
			digitStack.push(num%10);
			num=num/10;
		}
		System.out.println("Digits Stack="+digitStack);
		int[] digits = new int[digitStack.size()];
		int i=0;
		while(!digitStack.empty())
			digits[i++]=digitStack.pop();
		System.out.println("Digits ="+Arrays.toString(digits));
		return digits;
	}
}
