package LinkedList.SLL;

import java.util.HashSet;
import java.util.Set;
import LinkedList.SLL.LinkedList.Node;

/*
 * Remove duplicates from unsorted Linked List such that the result list contains unique elements
 */

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.append(1);
		l1.append(2);
		l1.append(2);
		l1.append(1);
		Node resultHead=removeDuplicates(l1.head);
		Node tnode = resultHead;
        while (tnode != null)
        {
            System.out.print(tnode.data+" ");
            tnode = tnode.next;
        }
	}
	
	/*
	 * Approach1: In-place algo
	 * Use set for unique node values. Use two pointers, prev and curr. If value of curr already in set then point prev.next to curr.next
	 * T.C=O(N) S.C=O(N)
	 */
	private static Node removeDuplicates(Node head){
		Set<Integer> setUniqueValues= new HashSet<Integer>();
		Node prev=null,curr=head;
		if(head==null || head.next==null)
			return head;
		while(curr!=null){
			if(!setUniqueValues.contains(curr.data)){
				setUniqueValues.add(curr.data);
				prev=curr;
				curr=curr.next;
			}
			else{//if duplicate found, change next of previous
				prev.next=curr.next;
				curr=prev.next;
			}
		}
		return head;
	}
	
	/*
	 * Approach2: Sort Linked List and then remove duplicates
	 * T.C=O(NLogN + N) S.C=O(N)
	 */
	
	/*
	 * Similarly do removing duplicates from sorted Linked List. Same solution but no need of Set
	 */

}
