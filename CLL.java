import java.io.*;
public class CLL{
	public Node head=null,tail=null;
	static class Node{
		int data;
		Node next;
		Node(int d)
		{
			data =d;
			next=null;
		}
	}
	public static void traverse(CLL list)
	{
		    Node current = list.head;  
            if(list.head == null) {  
                System.out.println("List is empty");  
            }  
            else {
                 do{  
                    System.out.print(current.data+" ");  
                    current = current.next;  
                }while(current != list.head);  
                System.out.println();  
            }  
	}

	public static void search(CLL list,int num)
	{
		    Node curr = list.head;  
		    boolean check = false;
            if(list.head == null) {  
                System.out.println("List is empty");  
            }  
            else {
                 do{  
                    if(curr.data == num)
            	{
                	check = true;
            	}
                    curr = curr.next;  
                }while(curr != list.head);

                 if(check == true)
        		{
            		System.out.println("we found it..");
        		}
        		else
        		{
            		System.out.println("not in the list");
        		}  
            }  
	}


	public static CLL insertFirst(CLL list,int data)
	{
		 Node newNode = new Node(data);  
            if(list.head == null) { 
                list.head = newNode;  
                list.tail = newNode;  
                newNode.next = list.head;  
            }  
            else {
                Node temp = list.head;  
                newNode.next = temp;  
                list.head = newNode;  
                list.tail.next = list.head;  
            }  
            return list;
	}


	public static CLL insertPos(CLL list,int data,int pos)
	{
		Node new_node = new Node(data);
        int cou=0;
        new_node.next = null;
        if(list.head==null)
        {
            System.out.println("overflow");
        }
        else
        {
           Node myPos = list.head;
           pos = pos-2;
           if(pos==-1)
           {
             list = insertFirst(list, data);
           }
           else
           {
            while(cou!=pos)
           {
                myPos = myPos.next;
                cou++;
           }
           new_node.next = myPos.next;
           myPos.next = new_node;
           }
           
        }
        return list;
         
	}

	public static CLL insertLast(CLL list,int data)
	{
		 Node newNode = new Node(data);  
            if(list.head == null){ 
                list.head = newNode;  
                list.tail = newNode;  
                newNode.next = list.head;  
            }  
            else{
           		list.tail.next = newNode;
           		list.tail = newNode;
           		list.tail.next = list.head;
            }  
            return list;
	}


    public static CLL rotation(CLL list)
    {
        Node curr = list.head,prev = null ;

        if(list.head==null)
        {
            System.out.println("List is already empty");
        }

        else if(curr.next == curr)
        {
            list.head = null;
        }
        else
        {
            list.head = curr.next;
        }
        return list;
    }

    public static CLL deleteFirst(CLL list)
    {
        Node curr = list.head;

        if(list.head==null)
        {
            System.out.println("List is already empty");
        }
        else
        {
            if(list.head!=list.tail)
            {
                list.head = curr.next;
                list.tail.next = list.head;
            }
            else
            {
                list.head = null;
                list.tail = null;
            }
         
        }
        return list;
    }
    public static CLL deletePos(CLL list,int pos)
    {

        Node curr = list.head,prev = null ;
        int cou = 0;
        pos = pos-1;

        if(list.head==null)
        {
            System.out.println("List is already empty");
        }

        else if(curr.next == null)
        {
            list = deleteFirst(list);
        }
        
        else
        {
           while(pos!=cou)
           {
            prev = curr;
            curr = curr.next;
            cou++;
           }

           prev.next = curr.next;
        }
        return list;
    }

    public static CLL deleteLast(CLL list)
    {
        Node curr = list.head;

        if(list.head==null)
        {
            System.out.println("List is already empty");
        }
        else
        {
            if(list.head!=list.tail)
            {
                Node current = list.head;  
                while(current.next != list.tail) {  
                    current = current.next;  
                }  
                list.tail = current;  
                list.tail.next = list.head;  
            } 
            else
            {
                list.head = null;
                list.tail = null;
            }
         
        }
        return list;
    }


	public static void main(String[] args){
		CLL list = new CLL();
		list = insertFirst(list,12);
		list = insertFirst(list,10);

		list = insertLast(list,2);
		list = insertLast(list,6);
		list = insertLast(list,60);

		list = insertPos(list,60000,3);
		list = insertPos(list,200,5);

		
		traverse(list);
		search(list,600);
	    search(list,1111);

        list = deletePos(list,3);
        traverse(list);

        list = deleteFirst(list);
        traverse(list);

        list = deleteLast(list);
        traverse(list);

        list = deletePos(list,3);
        traverse(list);

        list = rotation(list);
        traverse(list);

        list = rotation(list);
        traverse(list);

        list = rotation(list);
        traverse(list);

	}
}