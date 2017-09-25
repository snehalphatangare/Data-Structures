package Github;

import Github.LinkedList.Node;

public class MergeTwoSortedLL {
	
	//Create a dummy node (no need of linked list)
	public static Node mergeTwoLists(Node l1, Node l2) {
		LinkedList dummy= new LinkedList();
		Node head = dummy.new Node(-1);
        Node temp=head;
        while(l1!=null && l2!=null){
            if(l1.data < l2.data){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1==null)
            temp.next=l2;
        else if(l2==null)
            temp.next=l1;
        return head.next;
    }
	
	public static Node mergeTwoListsRecursive(Node l1, Node l2) {
		LinkedList dummy= new LinkedList();
		//Node head = dummy.new Node(-1);
        Node head;
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        
        if(l1.data < l2.data){
            head=l1;
            head.next=mergeTwoListsRecursive(l1.next,l2);
        }else{
        	head=l2;
        	head.next=mergeTwoListsRecursive(l1,l2.next);
        }
       
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.append(1);
		l1.append(2);
		l1.append(3);
		LinkedList l2 = new LinkedList();
		l2.append(2);
		l2.append(4);
		l1.printList();
		System.out.println("");
		l2.printList();
		System.out.println("\nREcursively Merged sorted linked list is: ");
		 Node resultHead=mergeTwoListsRecursive(l1.head,l2.head);
        Node tnode = resultHead;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
		 
	     resultHead=mergeTwoLists(l1.head,l2.head);
		 System.out.println("\nMerged sorted linked list is: ");
		tnode = resultHead;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
        
       
	}

}
