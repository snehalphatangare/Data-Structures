package Github;

import java.util.Scanner;

class LinkedList
{
    Node head;  // head of list
    int length=0;
    /* Linked list Node*/
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    
    public boolean isEmpty(){
		return head==null;
	} 
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
        length++;
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
        length++;
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
        length++;
        return;
    }
    
    public void insertAtPosition(int new_data, int position){
    	Node newNode = new Node(new_data);
		if(position<=0)System.out.println("Position must be Positive Integer");
		else if(position>length) append(new_data);
		else if(position == 1) push(new_data);
		else{
				Node temp = head;
				for(int i=0;i<position-1;i++){
					temp = temp.next;
				}
				
				newNode.next = temp.next;
				temp.next = newNode;
				
				length++;
				
			}
	}
    
    public void removeFromFirst(){
		
		if(head == null)System.out.println("List is already Empty");
		else if(head.next==null){
			head = null;
			length--;
		}
		else{
			Node temp = head;
			head = temp.next;
			temp.next = null;
			length--;
		}
		
	}
	
	public void removeFromEnd(){
		
		if(head!=null){
			if(head.next==null) head = null;
			else{
				Node last = head.next;
				Node temp = head;
			
				while(last.next!=null){
					last = last.next;
					temp = temp.next;
				}
			
				temp.next=null;
				last=null;
			}
		length--;
		}else System.out.println("List is already Empty");
		
	}
	
	public void removeAtPosition(int position){
		
		if(position<=0) System.out.println("Enter positive number");
		else if(position>length) System.out.println("No Node at this position");
		else if(position==length) removeFromEnd();
		else if(position==1) removeFromFirst();
		else{
			Node temp = head;
			for(int i=1;i<position-1;i++){
				temp = temp.next;
			}
			temp.next = temp.next.next;
			length--;
		}
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
            System.out.println("4. check empty");
            System.out.println("5. delete at First");
            System.out.println("6. delete at Last");
            System.out.println("7. delete at position");
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
	            case 3 : 
	                System.out.println("Enter integer element to insert");
	                int num = scan.nextInt() ;
	                System.out.println("Enter position");
	                int pos = scan.nextInt() ;
	                llist.insertAtPosition(num, pos);
	                break; 
	            case 4 : 
	                System.out.println("Empty status = "+ llist.isEmpty());
	                break;            
	            case 5 :
	            	llist.removeFromFirst();
	            	break;
	            case 6:
	            	llist.removeFromEnd();
	            	break;
	            case 7:
	            	System.out.println("Enter position");
		            pos = scan.nextInt() ;
	            	llist.removeAtPosition(pos);
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
