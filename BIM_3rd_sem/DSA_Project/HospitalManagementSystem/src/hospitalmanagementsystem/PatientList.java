
package hospitalmanagementsystem;

class PNode{
    String []arr;
    PNode next,previous;

    public PNode(String[] arr) {
        this.arr = arr;
        this.next = null;
        this.previous = null;
    }

  
}
public class PatientList {
    PNode head;
    public PatientList()
    {
        head=null;
    }
    public void Insert(String[]arr)
          
    {
        PNode node= new PNode(arr);
        if(head==null){
            head=node;
//            tail=node;
        }
        else{
            PNode temp=head;
         while(temp.next!=null)
         {
             temp=temp.next;
         }
         temp.next=node;
         node.previous=temp;
                 
        }
    }

    public String[][] traverseandconvert()
    {
              int rowCount = 0;
         PNode temp=head;
          while(temp!=null)
          {
             rowCount++;
              temp=temp.next;
          }
          
           // Prepare data
        String[][] data = new String[rowCount][8];
   

        temp = head;
        int i = 0;
        while (temp != null) {
            data[i][0] = temp.arr[0];
            data[i][1] = temp.arr[1];
            data[i][2] = temp.arr[2];
            data[i][3] = temp.arr[3];
            data[i][4] = temp.arr[4];
            data[i][5] = temp.arr[5];
            data[i][6] = temp.arr[6];
            data[i][7] = temp.arr[7];
            temp = temp.next;
            i++;
        }
        return data;
    }
}
