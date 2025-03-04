
package hotelmanagementsystem;
import java.sql.*;
//5 steps in jdbc
public class Conn {
    Connection cn;
    Statement s;//helps to execute sql querries
    Conn(){
   try{
    //Step 1: Register the MYSQL Driver class
    //Step 2 : Creating connection with connection string
    //Step 3: creating the statement 
//    Step 4: executing the statement
//Step 5: Close the connection
        Class.forName("com.mysql.cj.jdbc.Driver"); //this helps to register the jdbc driver
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Sameer22");//local host 3306 is default port of sql
        s= cn.createStatement();
   }
   catch(Exception e)
   {
       e.printStackTrace();
   }
    }
}
