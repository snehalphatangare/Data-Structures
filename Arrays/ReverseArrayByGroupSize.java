package Arrays;

import java.util.Arrays;

/*
 * Given an array and group size, reverse array by group size
 */
public class ReverseArrayByGroupSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8};
		int k=3;
		int[] result=reverseArrGroupSize(arr,k);
		System.out.println("Reversed arr= "+Arrays.toString(result));
	}
	
	/*
	 * Iterate array and reverse chucks of k. 
	 * T.C= (complexity to reverse array * k ) * N = (k/2*k) * N = O(N/2)
	 */
	private static int[] reverseArrGroupSize(int[] arr,int k){
		for(int i=0;i<arr.length;i+=k){
			int left=i;
			int right=Math.min(arr.length-1, left+k-1);
			//System.out.printf("left = %d, right = %d",left,right);
			while(left<right){
				int temp=arr[left];
				arr[left++]=arr[right];
				arr[right--]=temp;
			}
		}
		return arr;
	}

}
