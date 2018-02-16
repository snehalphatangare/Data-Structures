package LinkedList.SLL;

import LinkedList.SLL.LinkedList.Node;

public class RotateList {
		public static Node rotateList(Node head,int k) {
			//FInd length of list
	        if(head==null || head.next==null)
	            return head;
	        Node node=head;
	        int length=0;
	        while(node!=null){
	            length++;
	            node=node.next;
	        }
	        
	        if(k>length)
	            k=k%length;
	        int last=length-k;
	        int count=1;
	        node=head;
	        Node lastNode=null;
	       // System.out.println("node "+node);
	        while(node.next!=null){
	            //System.out.println("At node "+node.data);
	            //Node the new lastNode
	            if(count==last){
	                lastNode=node;
	                //head=node.next;
	            }
	            node=node.next;
	            //System.out.println("Next node "+node.data);
	            count++;
	        }
	        System.out.println("outside node "+node.data);
	        System.out.println("last node "+lastNode.data);
	        System.out.println("new head "+lastNode.next.data);
	        //change next of last node to head
	        node.next=head;
	        head=lastNode.next;
	        lastNode.next=null;
	        return head;
	    }
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			LinkedList l1 = new LinkedList();
			l1.append(1);
			l1.append(2);
			l1.append(3);
			l1.append(4);
			l1.append(5);
			l1.printList();
	        Node newHead=rotateList(l1.head,2);
	        while (newHead != null)
	        {
	            System.out.print(newHead.data+" ");
	            newHead = newHead.next;
	        }
			
		}
}
