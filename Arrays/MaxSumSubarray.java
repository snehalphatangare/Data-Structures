package Arrays;

public class MaxSumSubarray {

	public static void main(String[] args) {
		ArrayPairSum n= new ArrayPairSum();
		// TODO Auto-generated method stub
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4}; 
		//int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11}; target=10
		System.out.println("Maximum sum of subarray is : ");
		int maxSum=maxSumSubarray(arr);
		System.out.println(maxSum);
	}
	
	public static int maxSumSubarray(int[] arr){
		int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            //Sum=sum+a[i] Or if new sum is less than new number, then initialize to new number & start new subarray
            sum=Math.max(sum+arr[i],arr[i]);
            maxSum=sum > maxSum? sum:maxSum;
        }
        return maxSum;
	}
}
