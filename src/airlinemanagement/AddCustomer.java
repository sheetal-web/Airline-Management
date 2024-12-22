
package airlinemanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer  extends JFrame implements ActionListener
{
    
    JTextField tfname,tfphone,tfaadhar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    public AddCustomer()
            {
                getContentPane().setBackground(Color.WHITE);
                setLayout(null);
                
                JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
                heading.setBounds(220,20,500,35);
                heading.setFont(new Font("Tahoma",Font.PLAIN,34));
                heading.setForeground(Color.BLUE);
                add(heading);
                
                // NAME INPUT 
                JLabel lblname = new JLabel("NAME");
                lblname.setBounds(60,80,150,25);
                lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
                add(lblname);
                
                 tfname = new JTextField();
                tfname.setBounds(220,80,150,25);
                add(tfname);
                
                
                // NATIONALITY INPUT 
                  JLabel lblnationality = new JLabel("NATIONALITY");
                lblnationality.setBounds(60,130,150,25);
                lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
                add(lblnationality);
                
                tfnationality = new JTextField();
                 tfnationality.setBounds(220,130,150,25);
                add( tfnationality);
                
                // AADHAR INPUT
                JLabel lblaadhar = new JLabel("AADHAAR NO.");
                lblaadhar.setBounds(60,180,150,25);
                lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
                add(lblaadhar);
                
               tfaadhar= new JTextField();
                 tfaadhar.setBounds(220,180,150,25);
                add(tfaadhar);
                
                // ADDRESS INPUT
                
                JLabel lbladdress = new JLabel("ADDRESS");
                 lbladdress.setBounds(60,230,150,25);
                lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
                add( lbladdress);
                
                 tfaddress= new JTextField();
                 tfaddress.setBounds(220,230,150,25);
                add(tfaddress);
                
                // RADIO BUTTONS
                
                 JLabel lblgender = new JLabel("GENDER");
                 lblgender.setBounds(60,280,150,25);
               lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
                add(lblgender);
                
                // to select only one radio button
                
                ButtonGroup gendergroup = new ButtonGroup();
                
                
               rbmale = new JRadioButton("Male");
                rbmale.setBounds(220,280,70,25);
                rbmale.setBackground(Color.WHITE);
                add(rbmale);
                
                  rbfemale = new JRadioButton("Female");
                rbfemale.setBounds(300,280,70,25);
                rbfemale.setBackground(Color.WHITE);
                add(rbfemale);
                
                gendergroup.add(rbmale);
                gendergroup.add(rbfemale);
                
                // PHONE NO. INPUT 
                
                JLabel lblphone = new JLabel("MOBILE NO.");
                lblphone.setBounds(60,330,150,25);
                lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
                add(lblphone);
                
                 tfphone= new JTextField();
                 tfphone.setBounds(220,330,150,25);
                add(tfphone);
                
                // save button
                
                JButton save = new JButton("Save");
                save.setBackground(Color.BLACK);
                save.setForeground(Color.WHITE);
                save.setBounds(220,380,150,30);
                save.addActionListener(this);
                add(save);
                
                ImageIcon image= new ImageIcon(ClassLoader.getSystemResource("airlinemanagement/icons/emp.png"));
                JLabel lblimage = new JLabel(image);
                lblimage.setBounds(450,80,280,400);
                add(lblimage);
                
                setSize(900,600);
                setLocation(300,150);
                setVisible(true);
            }
    
    public void actionPerformed(ActionEvent ae) // add functionality to save button
    {
         String name = tfname.getText();
         String nationality = tfnationality.getText();
         String phone = tfphone.getText();
         String address = tfaddress.getText();   
         String aadhar = tfaadhar.getText();
         String gender=null;
         
         if(rbmale.isSelected())
         {
             gender="Male";
         }
         else
         {
             gender="Female";
         }
        try
        {
             JDBCcon c = new JDBCcon();
             
             String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
             c.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Customer details added Successfully !");
             
             setVisible(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
            public static void main(String args[])
            {
                new AddCustomer();
            }
}
