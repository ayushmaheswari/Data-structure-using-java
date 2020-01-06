+import java.io.*;

public class LinkedList
{

	Node head;

	static class Node { 
  
        int data; 
        Node next; 
  
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 

    public static LinkedList insertFirst(LinkedList list,int data)
    {

        Node new_node = new Node(data);
        new_node.next = null;
        if(list.head==null)
        {
            list.head = new_node;
        }
        else
        {
           new_node.next = list.head;
           list.head = new_node; 
        }
        return list;
    }



    public static LinkedList insertPos(LinkedList list,int data,int pos)
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

    public static LinkedList insertLast(LinkedList list,int data)
    {

        Node new_node = new Node(data);
        new_node.next = null;
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
            last.next = new_node;
        }
        return list;
    }

    

    public static LinkedList deleteFirst(LinkedList list)
    {

        Node curr = list.head,prev = null ;
        if(list.head==null)
        {
            System.out.println("List is already empty");
        }
        else
        {
           list.head = curr.next; 
        }
        return list;
    }
    public static LinkedList deleteLast(LinkedList list)
    {

        Node curr = list.head,prev = null ;

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
           while(curr.next!=null)
           {
            prev = curr;
            curr = curr.next;
           }
           prev.next = null;
        }
        return list;
    }


    public static LinkedList deletePos(LinkedList list,int pos)
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



    public static void traverse(LinkedList list)
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

    public static void search(LinkedList list,int num)
    {
        Node curr = list.head;
        boolean check = false;
        if(curr==null)
        {
            System.out.print("List is empty ");
        }
        while(curr != null)
        {
            if(curr.data == num)
            {
                check = true;
            }
            curr = curr.next;
        }

        if(check == true)
        {
            System.out.print("we found it..");
        }
        else
        {
            System.out.print("not in the list");
        }
        System.out.println("");

    }


    public static void main(String[] args) {

        LinkedList list = new LinkedList(); 
  
    
        traverse(list);

        list = insertLast(list, 1); 
        list = insertLast(list, 2); 
        list = insertLast(list, 3); 
        list = insertLast(list, 4); 
        list = insertLast(list, 5); 

        traverse(list);

        list = insertFirst(list, 6); 
        list = insertFirst(list, 7); 
        list = insertFirst(list, 8); 
        list = insertFirst(list, 9); 
        list = insertFirst(list, 10);

        traverse(list);

        list = insertPos(list, 100,5); 
        list = insertPos(list, 1000,7);
        list = insertPos(list, 2000,6);
        list = insertPos(list, 3000,4); 
        list = insertPos(list, 4000,1); 
    
        traverse(list);

        list = deleteFirst(list);
        list = deleteFirst(list);
        list = deleteFirst(list);
        list = deleteFirst(list);
        list = deleteFirst(list);

        traverse(list);

        list = deleteLast(list);
        list = deleteLast(list);
        list = deleteLast(list);
        list = deleteLast(list);
        list = deleteLast(list);

         traverse(list);
        list = deletePos(list,5);
        list = deletePos(list,2);
        list = deletePos(list,2);

        traverse(list);
        search(list,7);
        search(list,6);
        search(list,71);

    }

}