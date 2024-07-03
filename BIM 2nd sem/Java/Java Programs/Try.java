import java.util.*;
public class Try{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int num= sc.nextInt();
        sc.close();
        int cpy=num;
        int count=1;
        while(cpy!=0)
        {
            cpy/=10;
            count*=10;
        }
        count/=10;
        System.out.println(count);
while (num!=0) {
    int quo= num/count;
    System.out.println(quo);
    num%=count;
    count/=10;
}
    }
}