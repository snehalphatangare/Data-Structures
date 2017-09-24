import java.util.Arrays;
import java.util.Scanner;

public class ArrayCircularQueue {
	static final int MAX = 2;
	int front, rear, size;
    int array[] = new int[MAX];
      
    public ArrayCircularQueue() {
         front  = -1; 
         rear = - 1;
         array = new int[MAX];
         //Initialize queue with -1(only for printing purpose. to help debug)
         for(int i=0;i<MAX;i++){
        	 array[i]=-1;
         }
           
    }
      
    // Queue is full when front>rear by 1
    boolean isFull(ArrayCircularQueue queue)
    {  return (front==(rear+1)%MAX);
    }
      
    // Queue is empty when front == rear
    boolean isEmpty(ArrayCircularQueue queue)
    {  return (front ==  -1 && rear ==-1); }
      
    // Method to add an item to the queue. 
    // 1. Check if queue is full 2. Increase rear. 3. Insert element at rear
    void enqueue( int item)
    {
    	if (isFull(this)){
        	System.out.println("********Queue FUll*******");
            return ;
        }
        else if(isEmpty(this))
        	front=rear=0;
        else
        	rear=(rear+1)%MAX;
    	System.out.println("new rear="+rear);
        array[rear]=item;
        System.out.println(item+ " enqueued to queue");
    }
      
    // Method to remove an item from queue.  
    // 1. Check is queue is empty 2.Get the element at front. 3. Increment front
    Object dequeue()
    {
    	if (isEmpty(this)){
        	System.out.println("*******Queue Empty*******");
        	return null;
    	}  
        int item=array[front];
        array[front]=-1;
        if(front==rear)
        	front=rear=-1;
        else 
        	front=(front+1)%MAX;
        return item;
    }
      
    void print(){
    	/*if(front>=0){
	    	for(int i=front;i<=rear;i++){
				System.out.print(array[i]+" -- ");
			}
	    	System.out.println("null");
    	}*/
    	//System.out.println(Arrays.toString(array));
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayCircularQueue q = new ArrayCircularQueue();
		char ch;
		
		do
        {
            System.out.println("\n Queue Operations\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            
            System.out.println("\n Enter your choice");
            int choice = scan.nextInt();            
            switch (choice)
            {
	            case 1 : 
	            	System.out.println("Enter integer element to put in queue");
	                q.enqueue(scan.nextInt());                     
	                break;  
	            case 2 : 
	                q.dequeue();                     
	                break; 
	            default : 
	                System.out.println("Wrong Entry \n ");
	                break;  
            }
            //  Display Stack   
            System.out.println("\n Updated Queue is: ");
            q.print();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);    
 
        } while (ch == 'Y'|| ch == 'y');
	}

}
