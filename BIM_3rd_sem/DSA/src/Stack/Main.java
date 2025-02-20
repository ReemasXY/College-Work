/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Stack;

class Main {
    public static void main(String[] args) {
       Stack s = new Stack();
       s.push(100);
       s.push(200);
       s.push(300);
       System.out.println("Size of Stack is " + s.size());
       
       s.display();
       int data = s.pop();
       System.out.println("Deleted data is "+ data);
       
       
    }
}

class Stack
{
   final int MAXSIZE =10;
   int []A = new int[MAXSIZE];
   int tos =-1;
   
   public boolean isEmpty()
   {
       if(tos==-1)
       {
           return true;
       }
       return false;
   }
   
   
   public boolean isFull()
   {
     /* return (tos==MAXSIZE-1)?true:false;
     */
       if(tos==MAXSIZE-1)
       return true;
       else
       return false;
   }
   
   public void push(int data)
   {
       if(isFull())
       {
           System.out.println("Stack is Full. You Can not insert any more data into the stack!!!");
       }
       else
       {
          tos++;
          A[tos] = data;
          System.out.println(data + " inserted successfully");
       }
   }
   
public int pop()
{
    int item=0;
    if(isEmpty())
    {
     System.out.println("Stack is Empty. Nothing to delete!!!");   
    }
    else
    {
        item = A[tos];
        tos--;
       
    }
     return item;
}
   
  public void display()
  {
       System.out.print(" [");
      for(int i=0;i<size();i++)
      {
          System.out.print(A[i] +" ");
      }
       System.out.println("]");
  }
  
  public int size()
  {
   return tos+1;
  }
}
