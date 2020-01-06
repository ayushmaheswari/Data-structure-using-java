import java.io.*;

public class DLL
{
	Node head;

	static class Node
	{
		int data;
		Node prev;
		Node next;
		Node(int d) 
        { 
            data = d; 
            next = null; 
            prev = null;
        } 

	}

	public static void traverseFirst(DLL list)
	{
		Node curr = list.head;
        if(curr==null)
        {
            System.out.print("List is empty");
        }
        while(curr != null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println("");
	}


	public static void reverse(DLL list)
	{
		Node temp = null; 
        Node current = list.head; 
  
        while (current != null) { 

        	/// link swapping 

            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp; 

            current = current.prev; 
        } 
  
        
        if (temp != null) { 
            list.head = temp.prev; 
        } 

	}

	public static DLL insertFirst(DLL list,int data)
	{
		Node new_node = new Node(data);

		if(list.head==null)
        {
            list.head = new_node;
        }
        else
        {
        	new_node.prev = null;
			new_node.next = list.head;
			list.head.prev = new_node;
			list.head = new_node; 
        }
		
		return list;
	}

	public static DLL insertLast(DLL list,int data)
	{
		Node new_node = new Node(data);

		if(list.head==null)
        {
            list.head = new_node;
        }
        else
        {
        	Node last = list.head;
            while(last.next!=null)
            {
                last=last.next;
            }

        	new_node.next = null;
        	last.next = new_node;
        	new_node.prev = last;
        }
		
		return list;
	}

	public static DLL insertPos(DLL list,int data,int pos)
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


	public static DLL deleteFirst(DLL list)
	{
		Node curr = list.head;
		if(list.head == null)
		{
			System.out.println("List is already empty");
		}
		else if(curr.next == null)
		{
			list.head = null; 
		}
		else
		{
			list.head = curr.next;
			curr.next.prev= null;
		}
		return list;
	}

	public static DLL deleteLast(DLL list)
	{
		Node curr = list.head;
		Node newpo = null;
		if(list.head == null)
		{
			System.out.println("List is already empty");
		}
		else if(curr.next == null)
		{
			list.head = null; 
		}
		else
		{
			while(curr.next != null)
			{
				newpo = curr;
				curr = curr.next;
			}
			newpo.next = null;
		}
		return list;
	}


	public static DLL deletePos(DLL list,int pos)
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


	public static void main(String[] args) {
		
		DLL list = new DLL();

		list = insertFirst(list,5);
		list = insertFirst(list,15);
		list = insertFirst(list,25);

		traverseFirst(list);
		reverse(list);
		traverseFirst(list);

		list = insertLast(list,50);
		list = insertLast(list,150);
		list = insertLast(list,250);

		traverseFirst(list);
		reverse(list);
		traverseFirst(list);

		list = insertPos(list,5000,4);
		list = insertPos(list,50000,6);

		traverseFirst(list);

		list = deleteFirst(list);
		list = deleteFirst(list);

		traverseFirst(list);
		reverse(list);
		traverseFirst(list);

		list = deleteLast(list);
		list = deleteLast(list);

		traverseFirst(list);
		reverse(list);
		traverseFirst(list);

		list = deletePos(list,2);
		list = deletePos(list,2);
		traverseFirst(list);


	}
}