import java.util.Scanner;

class LinkedList
{
    Node head;  // head of list
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
  
        Node new_node = new Node(new_data);
 
        new_node.next = head;
        head = new_node;
    }
 
    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data)
    {
        if (prev_node == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
 
        Node new_node = new Node(new_data);
 
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }
    
    /* Appends a new node at the end.  */
    public void append(int new_data)
    {
        Node new_node = new Node(new_data);
 
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }
 
        new_node.next = null;
 
        Node last = head; 
        while (last.next != null)
            last = last.next;
 
        last.next = new_node;
        return;
    }
 
    /* Print contents of linked list */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
    }
    
    public static void main(String[] args)
	 {
    	Scanner scan = new Scanner(System.in);
        
		LinkedList llist = new LinkedList();
        char ch;
		
		do
        {
            System.out.println("\n Singly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            /*System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("7. delete at First");
            System.out.println("8. delete at Last");*/
            System.out.println("10. insert after given node");
            
            System.out.println("\n Enter your choice");
            int choice = scan.nextInt();            
            switch (choice)
            {
	            case 1 : 
	            	System.out.println("Enter integer element to insert");
	                llist.push(scan.nextInt());                     
	                break;  
	            case 2 : 
	            	System.out.println("Enter integer element to insert");
	                llist.append(scan.nextInt());                     
	                break;  
	            case 10 : 
	            	System.out.println("Enter integer element to insert after");
	                llist.insertAfter(llist.head.next,scan.nextInt());                     
	                break;  
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
            }    
            //  Display List   
            System.out.println("\n Updated Linked list is: ");
            llist.printList();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);    
 
        } while (ch == 'Y'|| ch == 'y');
	     
	 }
    
}



