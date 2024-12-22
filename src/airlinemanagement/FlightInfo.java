
package airlinemanagement;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame
{
    
    public FlightInfo()
    {
         getContentPane().setBackground(Color.WHITE); // frame color 
        setLayout(null);
        
        JTable table = new JTable(); // class to create table
         try
         {
               JDBCcon c = new JDBCcon();
               
               ResultSet rs = c.s.executeQuery("select * from flight");
               table.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e)
            {
                e.printStackTrace();
            }
         
         JScrollPane jsp = new JScrollPane(table);
         jsp.setBounds(0,0,800,500);
         add(jsp);
         
        
         setSize(800,500); // set length and breadth
        setLocation(400,250); // frame will appear 600 units away from left 
        setVisible(true); // frame is visible
    }
    public static void main(String args[])
    {
       new FlightInfo();
    }
}
