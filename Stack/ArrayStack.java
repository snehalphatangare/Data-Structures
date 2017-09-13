import java.util.Scanner;

public class ArrayStack {
	
	static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack
 
    ArrayStack()
    {
        top = -1;
    }
    
    boolean isEmpty()
    {
        return (top == -1);
    }
    
    boolean isFull()
    {
        return (top == MAX);
    }
 
    boolean push(int x)
    {
        if (isFull())
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            a[++top] = x;
            return true;
        }
    }
 
    int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            int x = a[top--];
            return x;
        }
    }
    
     void print(){
		
		for(int i=top;i>=0;i--){
			System.out.print(a[i]+" -- ");
		}
	
		System.out.println("Null");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayStack s = new ArrayStack();
		char ch;
		
		do
        {
            System.out.println("\n Stack Operations\n");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            
            System.out.println("\n Enter your choice");
            int choice = scan.nextInt();            
            switch (choice)
            {
	            case 1 : 
	            	System.out.println("Enter integer element to put in stack");
	                s.push(scan.nextInt());                     
	                break;  
	            case 2 : 
	                s.pop();                     
	                break; 
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;  
            }
            //  Display Stack   
            System.out.println("\n Updated Stack is: ");
            s.print();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);    
 
        } while (ch == 'Y'|| ch == 'y');
	}

}
