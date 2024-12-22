
package airlinemanagement;
import java.sql.*;

public class JDBCcon 
{
     Connection c;
        Statement s;
    public JDBCcon()
    {
       
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "sheetal");
            s = c.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}