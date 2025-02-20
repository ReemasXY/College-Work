/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;
import javax.swing.JOptionPane;
public class SinglyList {
    static Node head =null;
    
    public static void main(String[] args) {
        InsertAtFirst(500);
        InsertAtFirst(400);
        InsertAtFirst(600);
        InsertAtFirst(700);
        InsertAtLast(800);         
        InsertAtSpeciPos(500);
        traverse();
    }
    
    
    public static void InsertAtFirst(int data)
    {
       Node node = new Node(data,null);
       if(head==null)
       {
           head =node;
       }
       else
       {
           node.next = head;
           head = node;
       }
       
       
    }
    
    
    public static void InsertAtLast(int data)
    {
       Node node = new Node(data,null);
       Node temp = head;
       if(head==null)
       {
           head =node;
       }
       else
       {
           while(temp.next!=null)
           {
               temp = temp.next;
           }
           temp.next = node;
          
       }
       
       
    }
    
    
    
      public static void InsertAtSpeciPos(int data)
    {
         Node node = new Node(data,null);
       //Scanner sc = new Scanner(System.in);   
       //System.out.println("Please Enter the position where you want to insert !!!");
       int pos = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the position where you want to insert !!!"));
       
       int size=0;
       Node temp = head;
       while(temp!=null)
       {
          temp = temp.next;
          size++;
       }
       
       if(pos > size)
       {
         JOptionPane.showMessageDialog(null, "Sorry !!! Unable to insert at your position");  
       }
       else
       {
         temp = head;
         int i=1;
         while(i<pos-1)
         {
             temp= temp.next;
             i++;
         }
         
         node.next= temp.next;
         temp.next = node;
            
           
       }
       
       
       
       
    }
    
    
    
    
    //displaying all element of list
    public static void traverse()
    {
        Node temp = head;
        System.out.print("{");
        while(temp!=null)
        {
            System.out.print(temp.data + "\t"); 
            temp= temp.next;
        }
        
    }
    
}
// Creation of node

class Node
{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
}


