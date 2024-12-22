
package airlinemanagement;
import javax.swing.*;  // used to create frame
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener // JFrame to create frame ActionListener to perform action on buttons
{
    
    public Home()
    {
       
        setLayout(null);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("airlinemanagement/icons/front.jpg")); // add image
        JLabel image = new JLabel(il);
        image.setBounds(0,0,1600,800);
        add(image);
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU !");
        heading.setBounds(500,40,1000,40);
        heading.setForeground(Color.black); // set font color
        heading.setFont(new Font("Tahoma",Font.PLAIN,38)); // set font and size=36       
        image.add(heading);
        
        JMenuBar menubar = new  JMenuBar(); // Create menu bar
        setJMenuBar(menubar); // show menubar on frame
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
       
        JMenuItem flightDetails = new JMenuItem("Flight Deatils");
        flightDetails.addActionListener(this);
        details.add(flightDetails );
        
         JMenuItem CustomerDeatils = new JMenuItem("Add Customer Deatils");
         CustomerDeatils.addActionListener(this);
        details.add(CustomerDeatils );
        
         JMenuItem bookFlight = new JMenuItem("Book Flight");
         bookFlight.addActionListener(this);
        details.add(bookFlight);
        
         JMenuItem journeyDeatils = new JMenuItem("Journey Details");
          journeyDeatils.addActionListener(this);
        details.add(journeyDeatils);
        
         JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
         ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
         JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
       
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass );
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); // set full length frame
       
        setVisible(true); // frame is visible
    }
    
    public void actionPerformed(ActionEvent ae) // add functionality to buttons
    {
       String text = ae.getActionCommand();
       
       if(text.equals("Add Customer Deatils"))
       {
           new AddCustomer();
       }
       else if(text.equals("Flight Deatils"))
       {
           new FlightInfo();
       }
       else if(text.equals("Book Flight"))
       {
           new BookFlight();
       }
       else if(text.equals("Journey Details"))
       {
           new  JourneyDetails();
       }
       else if(text.equals("Cancel Ticket"))
       {
           new Cancle();
       }
       else if(text.equals("Boarding Pass"))
       {
           new BoardingPass();
       }
              
    }
    
    public static void main(String args[])
    {
        new Home();
    }
}