/*
 * Check if SLL has Loop. If yes, find loop length. Also remove Loop
 */
package LinkedList.SLL;

//import LinkedList.SLL.LinkedList.Node;

public class DectectLoop {
	Node head;  // head of list
    int length=0;
    /* Linked list Node*/
    public class Node
    {
        int data;
        Node next;
        public Node(int d) {data = d; next = null; }
    }
    
    public boolean isEmpty(){
		return head==null;
	} 
    
    /* Appends a new node at the end.  */
    public Node append(int new_data)
    {
        Node new_node = new Node(new_data);
 
        if (head == null)
        {
            head = new Node(new_data);
            return head;
        }
 
        new_node.next = null;
 
        Node last = head; 
        while (last.next != null)
            last = last.next;
 
        last.next = new_node;
        length++;
        return new_node;
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
    
    /*
     * Floyd’s Cycle-Detection Algorithm
     * Traverse linked list using two pointers.  Move one pointer by one and other pointer by two. 
     * If these pointers meet at some node then there is a loop.  If pointers do not meet then linked list doesn’t have loop.
     */
    private static Boolean detectLoop(Node head){
    	Node slow=head,fast=head;
    	while(fast!=null && fast.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    		//The pointers can meet at any point inside the loop
    		if(slow==fast){
    			System.out.println("The linked list contains a loop");
    		//	System.out.printf("slow= %d, fast=%d", slow.data,fast.data);
    			int length=findLoopLength(slow);
    			System.out.println("Loop length="+length);
    			breakLoop(head,length);
    			return true;
    		}
    	}
    	return false;
    }
    
    //Start from the meeting point(not necessarily the loop head. It can be any node inside loop) and traverse until the same point, counting the length along
    private static int findLoopLength(Node loopHead){
    	Node temp=loopHead;
    	int length=0;
    	while(temp.next!=loopHead){
    		temp=temp.next;
    		length++;
    	}
    	return length+1;
    }
    
   /*
    * 1st detect loop using Floyd's Cycle detection algo.
    * Then to remove loop,Get loop head. Then remove loop
    */
    private static void breakLoop(Node head,int loopLength){
    	//Get the Loop Head
    	// Fix one pointer to head
    	Node ptr1 = head;
    	// And the other pointer to k nodes after head
        Node ptr2 = head;
        for (int i = 0; i < loopLength; i++) {
            ptr2 = ptr2.next;
        }
        
        /*  Move both pointers at the same pace,they will meet at loop starting node. This meeting point is Loop Head */
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
 
        // Get pointer to the last node in loop
        ptr2 = ptr2.next;
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }
        /* Set the next node of the loop ending node to remove the loop */
        ptr2.next = null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DectectLoop l1 = new DectectLoop();
		l1.append(1);
		Node Node2=l1.append(2);
		l1.append(3);
		l1.append(4);
		Node Node5=l1.append(5);
		Node5.next=Node2;
		
		
		Boolean isLoop=detectLoop(l1.head);
		if(!isLoop){
			System.out.println("The linked list does not contain a loop");
		}
		else
			l1.printList();
	}

}
