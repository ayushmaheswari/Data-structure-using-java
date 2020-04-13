import java.io.*;
public class queue
{

	static int front=-1,rear=-1;
	public static void push(int[] queue,int data)
	{
		if(front==rear && front==-1)
		{
			front=0;
			rear = 0;
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
		if(front == rear && front==-1)
		{
			System.out.println("underflow");
		}
		else if(front==rear)
		{
			front = -1;
			rear = -1;
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
		if(front == rear && front==-1)
		{
			System.out.println("queue not exist");
		}
		else
		{
			for(int i= front;i<=rear;i++)
		{
			System.out.print(queue[i]+" ");
		}
		System.out.println();
		}
		
	}
	public static void search(int[] queue,int data)
	{

		boolean flag = false;

		if(front == rear && front==-1)
		{
			System.out.println("queue not exist");
		}

		for(int i=front;i<=rear;i++)
		{
			if(queue[i]==data)
			{
				flag = true;
			}
		}
		if(flag == true)
		{
			System.out.println("element in the queue...");
		}
		else
		{
			System.out.println("element not in the queue...");
		}

	}

	public static void main(String[] args) {
		int[] queu =  new int[500];
		push(queu,1);
		push(queu,2);
		pop(queu);
		print(queu);
		push(queu,100);
		push(queu,200);
		push(queu,300);
		print(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		pop(queu);
		print(queu);
		push(queu,100);
		push(queu,200);
		push(queu,300);
		print(queu);



	}
}
