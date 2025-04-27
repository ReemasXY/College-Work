
package hospitalmanagementsystem;

class DNode{
    String []arr;
    DNode next,previous;

    public DNode(String[] arr) {
        this.arr = arr;
        this.next = null;
        this.previous = null;
    }

  
}
public class DoctorList {
    DNode head;
    public DoctorList()
    {
        head=null;
    }
    public void Insert(String[]arr)
          
    {
        DNode node= new DNode(arr);
        if(head==null){
            head=node;
//            tail=node;
        }
        else{
            node.next=head; //insert at beginning
            head.previous=node;
            head=node;
        }
    }

    public String[][] traverseandconvert()
    {
              int rowCount = 0;
         DNode temp=head;
          while(temp!=null)
          {
             rowCount++;
              temp=temp.next;
          }
          
           // Prepare data
        String[][] data = new String[rowCount][6];
   

        temp = head;
        int i = 0;
        while (temp != null) {
            data[i][0] = temp.arr[0];
            data[i][1] = temp.arr[1];
            data[i][2] = temp.arr[2];
            data[i][3] = temp.arr[3];
            data[i][4] = temp.arr[4];
            data[i][5] = temp.arr[5];
            temp = temp.next;
            i++;
        }
        return data;
    }
}
