import java.util.Scanner;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		 System.out.println("\n Enter number of stairs ");
	     int numOfStairs = scan.nextInt();
	     System.out.println("\n Enter number of steps a person can climb at a time ");
	     int numOfSteps = scan.nextInt();
	     int result=countWays(numOfStairs,numOfSteps);
	     System.out.printf("Number of ways the person can climb %d stairs taking upto %d steps at time is %d", numOfStairs,numOfSteps,result);
	     result=countWaysDP(numOfStairs,numOfSteps);
	     System.out.printf("\nDP -->Number of ways the person can climb %d stairs taking upto %d steps at time is %d", numOfStairs,numOfSteps,result);
	}
	
	public static int countWays(int numOfStairs,int numOfSteps){
		int n =numOfStairs+1;
		int noOfWays[] = new int[n];
		if(n<=2)
			return 1;
		int secondLast=1,last=1;
		int current=0;
		for (int i=2; i<n; i++){
			current=secondLast+last;
			secondLast=last;
			last=current;
		}
		return current;
	}
	
	public static int countWaysDP(int numOfStairs,int numOfSteps){
		int n =numOfStairs+1;
		int noOfWays[] = new int[n];
		noOfWays[0] = 1; 
		noOfWays[1] = 1;
		for (int i=2; i<n; i++)
		{
			noOfWays[i] = 0;
		   for (int j=1; j<=numOfSteps && j<=i; j++)
			   noOfWays[i] += noOfWays[i-j];
		}
        	return noOfWays[n-1];
	}

}
