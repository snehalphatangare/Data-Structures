import java.util.Arrays;

/*Given an array of integers, find the maximum and minimum of the array.
Find the answer in minimum number of comparisons.
*/
public class FindMaxAndMin {
	//Approach 1
	//Iterate and compare every element with other to find min and max element.
	//For n elements, (n-1) comparisons required. Therefore, to find both min and max 2(n-1) comparisons required
	public static void findMinMax(int[] arr){
		int min_Index=0;
		int max_Index=0;
		for (int i=1;i<arr.length;i++){
			if(arr[i] < arr[min_Index])
				min_Index=i;
			else if(arr[i] > arr[max_Index])
				max_Index=i;
		}
		System.out.println("Min element is "+arr[min_Index]);
		System.out.println("Max element is "+arr[max_Index]);
	}
		/*Approach 2 - using Pairs
		Split array into pairs of two. Find min,max of each pair. Then compare min of 1 pair with min of next pair to find min between then. Compare that min with
		min of next pair. Same for max.
		For each pair, 3 comparisons (1 to find min,max between them two. 2,3 to find min,max between min,max of pair and overall min,max obtained so far.
		For n elements, n/2 pairs. Total comparison = n/2 *3 =1.5 n comparisons required.
		*/
		public static void findMinMaxUsingPairs(int[] arr){
			int max = arr[0];
			int min = arr[0];
			int i = 0;
			 for (; i < arr.length / 2; i++)
			 {
			   int num1 = arr[i * 2];
			   int num2 = arr[i * 2 + 1];
			   if (num1 >= num2)
			   {
				   if (num1 > max)
					   max = num1;
				   if (num2 < min)
					   min = num2;
			   }
			   else
			   {
				   if (num2 > max)
					   max = num2;
				   if (num1 < min)
					   min = num1;
			   }
			  }
			 //If one element left. Compare this last element
			  if (i * 2 < arr.length)
			  {
			   int num = arr[i * 2];
			   if (num > max)
				   max = num;
			   if (num < min)
				   min = num;
			  }
			  System.out.println("minimum= " + min);
			  System.out.println("maximum= " + max);
		}
		
		/*Next Approach - using triplets
		Split array into pairs of three. Find min,max of each pair. Then compare min of 1 pair with min of next pair to find min between then. Compare that min with
		min of next pair. Same for max.
		For each pair, 5 comparisons (3 to find min,max between them two. 2 to find min,max between min,max of pair and overall min,max obtained so far.
		For n elements, n/3 triplets. Total comparison = n/3 *5 =1.6 n comparisons required. Therefore, not very effective.
		*/
		
		/*Approach 3 - Divide and Conquer
		Divide the array into two parts and compare the maximums and minimums of the the two parts to get the maximum and the minimum of the the whole array.
		No.Of comparisons= NOfCom(Left)+NOfCom(Right)+2 = NOfCom(n/2)+NOfCom(n/2)+2= 2(NOfCom(n/2))+2
		For n elements, T(n)=2*T(n/2)+2
		*/
		public static MinMax findMinMaxDivideNConquer(int[] arr,int low,int high){
			MinMax finalMinMax,mmLeft,mmRight;
			int mid;
			/* If there is only on element */
			if (low == high)
			{
			     return new MinMax(arr[low],arr[low]);
			}    
			/* If there are two elements */
			  if (high == low + 1)
			  {  
			     if (arr[low] > arr[high])  
			     {
			    	 return new MinMax(arr[high],arr[low]);
			     }  
			     else
			     {
			    	 return new MinMax(arr[low],arr[high]);
			     }  
			  }
			  // If there are more than 2 elements
			  mid = (low + high)/2;  
			  mmLeft = findMinMaxDivideNConquer(arr, low, mid);
			  mmRight = findMinMaxDivideNConquer(arr, mid+1, high); 
			  
			return new MinMax(Math.min(mmLeft.min, mmRight.min), Math.max(mmLeft.max, mmRight.max));
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 3, 5, 1, 2, 6, 9, 2, 10, 11};
		findMinMax(arr);
		findMinMaxUsingPairs(arr);
		MinMax finalMinMax=findMinMaxDivideNConquer(arr,0,arr.length-1);
		System.out.println("Min element = "+finalMinMax.min);
		System.out.println("Max element = "+finalMinMax.max);
	}
	
	
}
 class MinMax
{
	 public int min;
	 public int max;
	 public MinMax(int min, int max)
	 {
	  this.min = min;
	  this.max = max;
	 }
}  


      
