/* Perform in-place sorting of a stack .
 * The basic idea is to use the system stack and recursion.
*/
import java.util.ListIterator;
import java.util.Stack;
	 
	public class SortStackInPlace {
	    // Recursive Method to insert an item x in sorted way
	    static void sortedInsert(Stack<Integer> s, int x)
	    {
	        // Base case: Either stack is empty or newly inserted item is greater than top (more than all existing)
	        if (s.isEmpty() || x > s.peek())
	        {
	            s.push(x);
	            return;
	        }
	      
	        // If top is greater, remove the top item and recur
	        int temp = s.pop();
	        sortedInsert(s, x);
	      
	        // Put back the top item removed earlier
	        s.push(temp);
	    }
	      
	    // Method to sort stack
	    static void sortStack(Stack<Integer> s)
	    {
	        if (!s.isEmpty())
	        {
	            // Remove the top item
	            int x = s.pop();
	            // Sort remaining stack
	            sortStack(s);
	            // Push the top item back in sorted stack
	            sortedInsert(s, x);
	        }
	    }
	     
	    static void printStack(Stack<Integer> s)
	    {
	       ListIterator<Integer> iter = s.listIterator();
	       // Iterate from bottom to top
	       while(iter.hasNext())
	    	   iter.next();
	        
	       // printing from top to bottom
	       while(iter.hasPrevious())
	           System.out.print(iter.previous()+" ");
	    }
	   
	    public static void main(String[] args) 
	    {
	        Stack<Integer> s = new Stack<>();
	        s.push(30);
	        s.push(-5);
	        s.push(18);
	        s.push(14);
	        s.push(-3);
	      
	        System.out.println("Stack elements before sorting: ");
	        printStack(s);
	      
	        sortStack(s);
	      
	        System.out.println(" \n\nStack elements after sorting:");
	        printStack(s);
	      
	    }
	}
