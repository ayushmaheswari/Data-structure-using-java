import java.io.*;

public class stack
{
	static int top =-1;

	public static void push(int[] stack,int data)
	{
		top++;
		stack[top] = data;
	}
	public static void pop(int[] stack)
	{
		top--;
	}

	public static void peek(int[] stack)
	{
		System.out.println("peeking element is "+stack[top]);
	}


	public static void print(int[] stack)
	{
		for(int i=top;i>-1;i--)
		{
			System.out.print(stack[i]+" ");
		}
		System.out.println("");
	}

	public static void isHave(int[] stack,int data)
	{
		boolean flag = false;

		for(int i=top;i>-1;i--)
		{
			if(stack[i]==data)
			{
				flag = true;
			}
		}
		if(flag == true)
		{
			System.out.println("element in the stack...");
		}
		else
		{
			System.out.println("element not in the stack...");
		}
	}


	public static void main(String[] args) {

		int stack[] = new int[50];

		push(stack,1);
		push(stack,2);
		push(stack,3);
		push(stack,4);
		push(stack,5);
		push(stack,6);
		push(stack,7);
		push(stack,8);
		push(stack,9);
		push(stack,10);


		print(stack);

		pop(stack);
		pop(stack);
		pop(stack);
		pop(stack);

		print(stack);


		isHave(stack,6);
		isHave(stack,60);
		isHave(stack,2);

		peek(stack);

		pop(stack);
		pop(stack);

		print(stack);


		


		
	}
}