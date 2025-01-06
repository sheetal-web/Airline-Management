
package airlinemanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener
{
    JTable table;
    JTextField pnr;
    JButton show;
    
    public  JourneyDetails ()
    {
         getContentPane().setBackground(Color.WHITE); // frame color 
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font ("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
             
        table = new JTable(); // class to create table
        
         
         JScrollPane jsp = new JScrollPane(table);
         jsp.setBounds(0,100,800,150);
         jsp.setBackground(Color.WHITE);
         add(jsp);
         
        
         setSize(800,500); // set length and breadth
        setLocation(400,150); // frame will appear 600 units away from left 
        setVisible(true); // frame is visible
    }
    
    public void actionPerformed(ActionEvent ae)
    {
          try
         {
               JDBCcon c = new JDBCcon();
               
               ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
               if(!rs.isBeforeFirst())
               {
                   JOptionPane.showMessageDialog(null,"NO Information found");
                   return;
               }
               table.setModel(DbUtils.resultSetToTableModel(rs));
         }
         catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    public static void main(String args[])
    {
       new  JourneyDetails ();
    }
}

