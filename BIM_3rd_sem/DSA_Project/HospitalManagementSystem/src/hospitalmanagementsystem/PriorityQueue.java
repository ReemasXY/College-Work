/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalmanagementsystem;
class PQueue{
    String[]data;
    int priority;
    PQueue next,prev;

    public PQueue(String[]data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
        this.prev = null;
    }
    
}
public class PriorityQueue {
    PQueue head=null,lastNode=null;
    public void Enqueue(String []data,int priority)
    {
        
        PQueue node= new PQueue(data,priority);
        PQueue temp=head;
       if(temp!=null)
       {
            while(temp.next!=null)
        {
            temp=temp.next;
        }
        lastNode=temp;
       }
        
        if(head == null)
        {
            head= node;
            lastNode=node;
        }
        else if(node.priority> head.priority)
        {
            node.next=head;
            head.prev=node;
            head=node;
        }
        else if(lastNode.priority>=node.priority)
        {
            lastNode.next=node;
            node.prev=lastNode;
            lastNode=node;
        }
        else{
            PQueue temp1= lastNode;
//            PQueue temp2= lastNode.prev;
            while(temp1!=null)
            {
                if(node.priority>temp1.priority)
                {
                    temp1=temp1.prev;
                }
                else{
                    break;
                }
            }
            node.next=temp1.next; 
            temp1.next.prev=node;
            temp1.next=node;
            node.prev=temp1;
            
        }
    }
    public void traverse()
    {
        PQueue temp=head;
        while (temp!=null)
        {
             for (String row : temp.data) {
            System.out.println(row+" ");
        }
             System.out.println("\n");
             temp=temp.next;
        }
    }
    public String [] Dequeue(){
        PQueue temp=head;
        if (head==null)
        {
            return null;
        }
        head=head.next;
        return temp.data;
    }
    public static void main(String[]args)
    {
        PriorityQueue p= new PriorityQueue();
        String [][]data={{"Sameer","1"}, {"Minisha","2"},{"Sid","3"},{"raj","4"},{"Karuna","4"},{"hari","4"}};
                
        p.Enqueue(data[0],1);
        p.Enqueue(data[1],2);
        p.Enqueue(data[2],3);
        p.Enqueue(data[3],4);
        p.Enqueue(data[4],4);
        p.Enqueue(data[5],4);
        p.traverse();
    }
}
