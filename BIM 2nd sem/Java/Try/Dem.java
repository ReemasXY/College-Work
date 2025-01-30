import java.util.*;

public class Dem{
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        int [][]arr={{1,2,4},{1,2},{2,3,4,2,5}};
       
        for(int []x: arr){
            for(int y:x)
            {
                System.out.print(" "+y);
            }
            System.out.println("\n");
        }
      
        
}
}