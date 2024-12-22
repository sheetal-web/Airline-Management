
package airlinemanagement;
import javax.swing.*;  // used to create frame
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener // JFrame to create frame ActionListener to perform action on buttons
{
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login()
    {
       
        getContentPane().setBackground(Color.WHITE); // frame color 
        setLayout(null);
       
        // creating username and password fields
        
        JLabel lblusername = new JLabel("Username"); // JLabel is used to write on frame
        lblusername.setBounds(20,20,100,20); // set label 
        add(lblusername); // it will make username visible on screen
        
        tfusername = new JTextField(); // it will add text area 
        tfusername.setBounds(130,20,200,20); // set length n breadth
        add( tfusername); // it will make text area visible on screen
        
        JLabel lblpassword = new JLabel("Password"); // JLabel is used to write on frame
        lblpassword.setBounds(20,60,100,20); // set label 
        add(lblpassword); // it will make password visible on screen
        
          tfpassword = new JPasswordField(); // it will add password area 
        tfpassword.setBounds(130,60,200,20); // set length n breadth
        add( tfpassword); // it will make password area visible on screen
        
        
        // creating buttons 
        
         reset = new JButton("Reset"); // create button
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this); // to perform action on click
        add(reset);
        
         submit = new JButton("Submit"); // create button
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this); // to perform action on click
        add(submit);
        
          close = new JButton("Close"); // create button
        close.setBounds(120,160,120,20);
        close.addActionListener(this); // to perform action on click
        add(close);
        
        // setting frame size
        
        setSize(600,400); // set length and breadth
        setLocation(600,250); // frame will appear 600 units away from left 
        setVisible(true); // frame is visible
    }
    
    public void actionPerformed(ActionEvent ae) // add functionality to buttons
    {
        if(ae.getSource() == submit)
        {
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try
            {
                JDBCcon c = new JDBCcon();
                
                String query = "select * from login where username = '"+username+"' and password ='"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next())
                {
                   new Home();
                     setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    setVisible(false);
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        else if (ae.getSource() == close)
        {
            setVisible(false); // to close frame
        }
        
        else if (ae.getSource() == reset)
         {
             tfusername.setText(""); // to revome existing text and replace with empty
             tfpassword.setText("");
         }
                
              
    }
    
    public static void main(String args[])
    {
        new Login();
    }
}
