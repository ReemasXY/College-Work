/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;


public class DoubllyLinkedListDemo {
    public static void main(String[] args) {
      DoublyLinkedList list = new DoublyLinkedList();
      System.out.println("\nAfter Inserting elements at First: ");
      list.insertionAtFirst(100);
      list.insertionAtFirst(200);
      list.insertionAtFirst(300);
      list.traverse();
      System.out.println("\nAfter Inserting elements at Last: ");
      list.insertionAtLast(400);
      list.insertionAtLast(500);
      list.traverse();
      System.out.println("\nDeleting from the First node :");
      list.deleteFromFirst();
      list.traverse();
      System.out.println("\nDeleting from the Last node :");
      list.deleteFromLast();
      list.traverse();
      
    }
}

class Node
{
    
    int data;
    Node next;
    Node Previous;

    public Node(int data, Node next, Node Previous) {
        this.data = data;
        this.next = next;
        this.Previous = Previous;
    }
    
}

class DoublyLinkedList
{
    Node head =null;
    public void insertionAtFirst(int data)
    {
         Node node = new Node(data,null,null);
        if(head==null)
        {
           
            head =node;
        }
        else
        {
           head.Previous =node;
           node.next = head;
           head =node;
        }
    }
    
    public void insertionAtLast(int data)
    {
         Node node = new Node(data,null,null);
        if(head==null)
        {
           
            head =node;
        }
        else
        {
          Node temp=head;
          while(temp.next!=null)
          {
              temp =temp.next;
          }
          temp.next=node;
          node.Previous =temp;
        }
    }
    
    public void deleteFromFirst()
    {
      if(head==null)
            System.out.println("Nothing to Delete !!!!");
      else
      {
          System.out.println("Data being deleted is : " + head.data);
          head = head.next;
          head.Previous = null;
      }
    }
    
    public void deleteFromLast()
    {
      if(head==null)
            System.out.println("Nothing to Delete !!!!");
      else
      {
          Node temp=head;
          while(temp.next!=null)
          {
              temp =temp.next;
          }
                   
          System.out.println("Data being deleted is : " + temp.data);
          temp.Previous.next =null;
         
      }
    }
            
            
    
    public void traverse()
    {
        Node temp =head;
        while(temp!=null)
        {
            System.out.print(temp.data + "  ");
            temp = temp.next;
            
        }
    }
}