import java.io.*;
public class DCLL
{
	Node head=null; 
	static class Node{
		int data;
		Node next;
		Node prev;
		Node(int d)
		{
			data=d;
			next=null;
			prev=null;
		}
	}

	public static void traverse(DCLL list)
	{
    Node temp = list.head;  
  
    System.out.printf("\nTraversal in forward direction \n");  
    while (temp.next != list.head)  
    {  
        System.out.print(temp.data+" ");  
        temp = temp.next;  
    }  
    System.out.print(temp.data+" ");  
  
    System.out.printf("\nTraversal in reverse direction \n");  
    Node last = list.head.prev;  
    temp = last;  
    while (temp.prev != last)  
    {  
        System.out.print(temp.data+" ");  
        temp = temp.prev;  
    }  
    System.out.print(temp.data+" ");  
	}

	public static DCLL insertFirst(DCLL list,int data)
	{
		Node new_node = new Node(data);
		if(list.head == null)
		{
			list.head = new_node;  
			new_node.next = list.head;
			new_node.prev =list.head;
		}
		else
		{
		Node last = list.head.prev;  
    	new_node.next = list.head;  
    	new_node.prev = last;  
    	last.next = list.head.prev = new_node;  
    	list.head = new_node;  
		}
		
		return list;
	}

	public static DCLL insertPos(DCLL list,int data,int pos)
	{
		Node new_node = new Node(data);
 		int cou=0;
		if(list.head==null)
        {
        	System.out.println("list is empty");
        }
        else
        {
           Node myPos = list.head;
           pos = pos-2;
           if(pos==-1)
           {
             list = insertFirst(list, data);
           }
     
            while(cou!=pos)
           {
                myPos=myPos.next;
                cou++;
           }
        	new_node.next = myPos.next;
        	new_node.prev = myPos;
        	myPos.next.prev = new_node;
        	myPos.next = new_node;

        }
		
		return list;
	}


	public static DCLL insertLast(DCLL list,int data)
	{
		Node new_node = new Node(data);
		if(list.head == null)
		{
			list.head = new_node;  
			new_node.next = list.head;
			new_node.prev =list.head;
		}
		else
		{
			new_node.prev = list.head.prev;
			list.head.prev.next =new_node;
			list.head.prev = new_node;
			new_node.next = list.head;

		}
		return list;
	}
	public static DCLL deleteFirst(DCLL list)
	{

		Node curr = list.head;
		Node last = list.head.prev;
        if(list.head==null)
        {
            System.out.println("List is already empty");
        }
        else if(list.head == last)
        {
        	list.head = null;
        }
        else
        {
            list.head = list.head.next;
            list.head.prev = last;
            last.next =list.head;
        }
        return list;
	}

	public static DCLL deletePos(DCLL list,int pos)
	{
		Node curr = list.head;
		Node newpo = null;
		int cou=0;
		pos=pos-1;
		if(list.head == null)
		{
			System.out.println("List is already empty");
		}
		else
		{
			while(pos != cou)
			{
				newpo = curr;
            	curr = curr.next;
            	cou++;
			}
			newpo.next = curr.next;
			curr.next.prev = newpo;
			curr.next = null;
			curr.prev = null;
			
		}

		return list;
	}

	public static DCLL deleteLast(DCLL list)
	{
		Node curr = list.head;
		Node last = list.head.prev;
        if(list.head==null)
        {
            System.out.println("List is already empty");
        }
        else if(list.head == last)
        {
        	list.head = null;
        }
        else
        {
            last.prev.next = list.head;
            list.head.prev = last.prev;
        }
        return list;
	}

	public static void main(String[] args) 
	{
		DCLL list = new DCLL();	
		list = insertFirst(list,1);
		list = insertFirst(list,10);
		list = insertFirst(list,100);
		list = insertLast(list,1000);
		list = insertPos(list,22,3);
		traverse(list);
		list = deleteFirst(list);
		traverse(list);
		list = deletePos(list,3);
		traverse(list);
		list = deleteLast(list);
		traverse(list);
		list = deleteLast(list);
		traverse(list);

		
	}

}