public class No7 {

    public static void main(String[] args) {
        int a=10,b=20;
        System.out.println("Example of IF");
        if(a<b)
        {
            System.out.println(a);
        }
        System.out.println("Example of IF ELSE");
        if(a>b)
        {
            System.out.println(a);
        }
        else{
            System.out.println(b);
        }
        System.out.println("Example of IF ELSE IF");
        if(a>b && a<20)
        {
            System.out.println(a);
        }
        else if(a<b && a>10){
            System.out.println(b);
        }
        else {
            System.out.println("None");
        }
        System.out.println("Example of for loop");
        int j;
        for(j=0;j<5;j++)
        {
            System.out.print(j);
        }
        System.out.println("\nExample of while loop");
       j=0;
        while(j<5)
        {
            System.out.print(j);
            j++;
        }
        System.out.println("\nExample of do while loop");
        j=0;
         do{
            System.out.print(j);
            j++;
         }while(j<5);
         System.out.println("\nExample of for each loop");
   int arr[]={1,2,3};
   for (int i : arr) {
    System.out.print(i);
   }
    }
}