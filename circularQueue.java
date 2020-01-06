import java.io.*;
public class circularQueue{
	static int front=-1,rear=-1;
	static int size=4;
	public static void push(int[] queue,int data)
	{
		if((front == 0 && rear == size-1) || (rear == (front-1)%(size-1)))
		{
			System.out.println("Queue is full can't insert");
		}
		else if(front==-1)
		{
			front=rear=0;
			queue[rear]=data;
		}
		else if(rear == (size-1) && front != 0)
		{
			rear=0;
			queue[rear]=data;
		}
		else
		{
			rear++;
			queue[rear]=data;
		}
	}


	public static void pop(int[] queue)
	{
		if(front==-1)
		{
			System.out.println("queue is empty");
		}
		else if(front==rear)
		{
			front= -1;
			rear= -1;
		}
		else if(front==size-1)
		{
			front=0;
		}
		else
		{
			front++;
		}

	}
	public static void peek(int[] queue)
	{
		System.out.println(queue[front]);
	}
	public static void print(int[] queue)
	{
		if(front==-1)
		{
			System.out.println("the queue is empty");
		}
		if (rear >= front) 
   		{ 
        	for (int i = front; i <= rear; i++) 
        	{
        		System.out.print(queue[i]+" ");
        	}
            
    	} 
   		else
    	{ 
       	    for (int i = front; i < size; i++)
       	 	{
       	 		System.out.print(queue[i]+" ");
       	 	}  
        	for (int i = 0; i <= rear; i++) 
        	{
        		System.out.print(queue[i]+" ");
        	}
    	} 
    	System.out.println(" ");
	}
	public static void search(int[] queue,int data)
	{
		boolean flag = false;
		if(front==-1)
		{
			System.out.println("the queue is empty");
		}
		if (rear >= front) 
   		{ 
        	for (int i = front; i <= rear; i++) 
        	{
        		if(queue[i]==data)
        		{
        			flag = true;
        		}
        	}
            
    	} 
   		else
    	{ 
       	    for (int i = front; i < size; i++)
       	 	{
       	 		if(queue[i]==data)
        		{
        			flag = true;
        		}	
       	 	}  
        	for (int i = 0; i <= rear; i++) 
        	{	
        		if(queue[i]==data)
        		{
        			flag = true;
        		}
        	}
    	} 
    	if(flag==true)
    	{
    		System.out.println("we found it...");
    	}
    	else
    	{
    		System.out.println("not found it...");
    	}
	}
	public static void main(String[] args) {
		int[] queue = new int[size];
		push(queue,4);
		push(queue,5);
		push(queue,6);
		push(queue,7);
		pop(queue);
		pop(queue);
		push(queue,8);
		push(queue,9);
		print(queue);
		search(queue,8);
		search(queue,10);		
	}
}