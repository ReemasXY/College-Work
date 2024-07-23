public class No2 {
    public static void main(String [] args)
    {
        int []arr= new int[30];
        for(int i=1;i<=30;i++)
        {
            arr[i-1]=i;
        }
        System.out.println("The numbers between 16 and 47 are: ");
        for(int x: arr)
        {
            if(x>=16 && x<=47)
            {
                System.out.print(" "+ x);
            }
        }
    } 
}
