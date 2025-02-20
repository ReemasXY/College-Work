/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;
class Node
{
     Node next;
     int data;    
     public Node(int data)
     {
         this.data=data;
         this.next=null;
      
     }
    
}
 public class CircularLinkedList {
      static Node head=null;
    static Node head2=null;
    public static void main(String[] args)
    {
        CircularLinkList(100);
        CircularLinkList(200);
        CircularLinkList(300);
        CircularLinkList(400);
        Traversal();
        
        
    }
     public static void CircularLinkList(int data)
    {
        Node node = new Node(data);
        if(head==null)
        {
            head=node;
            node.next=head;
        }
        else
        {
            Node temp=head;
            while(temp.next!=head)
            {
                temp=temp.next; 
            }
            temp.next=node;
            node.next=head;
        }
    }
      public static void CircularLinkListFromLast(int data1)
    {
        Node node=new Node(data1);
        if(head==null)
        {
            head=node;
            node.next=head;
        }
        else
        {
            Node temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            temp.next=node;
            node.next=head;
            head=node;
        }
    }
      public static void CircularLinkedListDeleteFromFirst()
    {
        if(head==null)
        {
            System.out.println("Nothing to delete");
        }
        else if(head.next==head)
        {
            System.out.println("Deleted Data "+head.data);
        }
        else
        {
            Node temp=head;
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            System.out.println("Deleted Data "+head.data);
            temp.next=head.next;
            head=head.next;
        }
    }
      public static void CircularLinkedListDeleteFromLast()
    {
        if(head==null)
        {
            System.out.println("No Data to be delete");
        }
        else if(head.next==head)
        {
            System.out.println("Data Deleted"+head.data);
        }
        else
        {
            Node temp=head;
            Node temp1=head.next;
            while(temp.next!=head)
            {
                temp1=temp;
                temp=temp.next;
            }
            System.out.println("Deleted data"+temp.next.data);
            temp.next=head;   
        }  
    }
      public static void Traversal()
    {
        if(head==null)
        {
            System.out.println("No Nodes available");
        }
        else
        {
            Node temp=head;
//            System.out.println(temp.data);
//            temp = temp.next;
            while(temp.next!=head)
            {
                System.out.println(temp.data);
               temp=temp.next;
               
            }
        }
}
}

