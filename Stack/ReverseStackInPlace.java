
import java.util.ListIterator;
import java.util.Stack;

/*
 In-place = Use system call stack i.e Recursion
 For recursion, recursively solve the problem for smaller inputs. I.e recursively call same function.
 User Base condition + Hypothesis + Induc
*/
public class ReverseStackInPlace {
  public static void main(String args[]) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(30);
    s.push(-5);
    s.push(18);
    s.push(14);
    s.push(-3);
    System.out.println("Stack elements before reverse: ");
    printStack(s);
    
    reverseStack(s);
    
System.out.println("Stack elements after reverse: ");
    printStack(s);
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
    
    // Method to reverse stack
    static void reverseStack(Stack<Integer> s)
    {
        //base condition (Smallest possible valid input): No need to reverse if stack empty or size=1
        if (s.isEmpty() || s.size() ==1)
        return;
        
        //Recursively call for smaller inputs
         // Remove the top item
        int temp = s.pop();
        // Reverse remaining stack
        reverseStack(s);
        // Insert the popped item back in reversed stack. Insert at bottom
        insertAtBottom(s, temp);
        
    }
    
    // Method to insert an element at bottom of stack
    static void insertAtBottom(Stack<Integer> s, Integer ele)
    {
        //base condition (Smallest possible valid input)
        if (s.isEmpty()) {
            s.push(ele);
            return;
        }
        
        //Recursively call for smaller inputs
         // Remove the top item
        int temp = s.pop();
        // Insert at bottom for remaining stack
        insertAtBottom(s, ele);
        // Insert back the popped item at the top
        s.push(temp);
        
    }
    
}
