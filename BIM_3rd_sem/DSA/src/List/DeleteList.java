
package List;


public class DeleteList {
    static Node head =null;
    
    public static void main(String[] args) {
        InsertAtFirst(100);
        InsertAtFirst(200);
        InsertAtFirst(300);
        InsertAtFirst(400);
        InsertAtFirst(500);
        traverse();
        deleteFromSpecificPosition(3);
        DeleteFromFirst();
        DeleteFromLast();
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
    public static void DeleteFromFirst()
    {
        if(head==null)
        {
           System.out.println("List is empty"); 
        }
        else{
            System.out.println("\n Data being deleted  from first is "+head.data);
            head=head.next;
    }
}
     public static void DeleteFromLast()
    {
        if(head==null)
        {
           System.out.println("List is empty"); 
        }
        else{
     Node temp1=head;
     Node temp2=head;
     while(temp2.next!=null)
     {
         temp1=temp2;
         temp2=temp2.next;
     }
     temp1.next=null;
       System.out.println("\n Data being deleted  from last is "+temp2.data);
     temp2=null;
    }
}
       // Method to delete node from specific position
    public static void deleteFromSpecificPosition(int pos) {
        if (head == null) {
            System.out.println("Nothing to delete");
        } else {
            Node temp1 = head;
            int count = 1;
            Node temp2;
            while (temp1 != null) {
                count++;
                temp2 = temp1;
                temp1 = temp1.next;
                if (count == pos) {
                    temp2.next = temp1.next;
                    break;
                }
            }
            System.out.println("\n Data being delted from "+ pos+ " position is " + temp1.data);
        }
}
}
class Node
{
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

