package learner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.io.*;
import javax.swing.border.Border;
class frame_2 extends javax.swing.JFrame implements ActionListener{
    int screenWidth, screenHeight;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11;
    JButton b1,b2,b4;
    File file;
    JTextField t1,t2,t3,t4,t8,t9,t0;
    JPasswordField t5;
    JComboBox b,b3;
    String Name,States, path_image, email_id, password, confirm_password,tou,gender,contact_No,fath_name,answer, DOB;
    int  rand;
    bridge newt;
    JFileChooser fileChooser;
    PreparedStatement ps = null;
    frame_2(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650, 700);
        getContentPane().setBackground(Color.getHSBColor(57,57,350));
        newt = new bridge();
        newt.connected();
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height = getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);
        setResizable(false);

        l = new JLabel("SIGN UP YOUR ACCOUNT !");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(180, 20, 300, 30);
        add(l);

        //label for photo
        l7 = new JLabel();
        l7.setBounds(220, 70, 140, 95);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        l7.setBorder(border);
        add(l7);

        //button for photo
        b2 = new JButton("UPLOAD");
        b2.setBounds(220, 165, 140, 30);
        b2.addActionListener(this);
        add(b2);

        l1 = new JLabel("Name");
        l1.setFont(new Font("Arial", Font.PLAIN, 15));
        l1.setBounds(50, 190, 200, 30);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(50, 220, 200, 30);
        add(t1);

        l2 = new JLabel("State");
        l2.setFont(new Font("Arial", Font.PLAIN, 15));
        l2.setBounds(360, 190, 200, 30);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(360, 220, 200, 30);
       add(t2);

        l3 = new JLabel("Contact number");
        l3.setFont(new Font("Arial", Font.PLAIN, 15));
        l3.setBounds(50, 260, 200, 30);
       add(l3);

        t3 = new JTextField();
        t3.setBounds(50, 290, 200, 30);
       add(t3);

        l4 = new JLabel("Email Id");
        l4.setFont(new Font("Arial", Font.PLAIN, 15));
        l4.setBounds(360, 260, 200, 30);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(360, 290, 200, 30);
        add(t4);

        l5 = new JLabel("Password");
        l5.setFont(new Font("Arial", Font.PLAIN, 15));
        l5.setBounds(50, 330, 200, 30);
       add(l5);

        t5 = new  JPasswordField();
        t5.setBounds(50, 360, 200, 30);
        add(t5);

        l6 = new JLabel("Type of User");
        l6.setFont(new Font("Arial", Font.PLAIN, 15));
        l6.setBounds(360, 330, 200, 30);
        add(l6);

        l8 = new JLabel("GENDER");
        l8.setFont(new Font("Arial", Font.PLAIN, 15));
        l8.setBounds(50, 400, 200, 30);
        add(l8);

        String gender[]= { "Male","Female","Others"};
        b3= new JComboBox(gender);
        b3.setBounds(50, 430, 200, 30);
        add(b3);
        b3.addActionListener(this);

        l9 = new JLabel("DOB");
        l9.setFont(new Font("Arial", Font.PLAIN, 15));
        l9.setBounds(360, 400, 200, 30);
        add(l9);

        t8 = new JTextField();
        t8.setBounds(360, 430, 200, 30);
        add(t8);

        l0 = new JLabel("Father's Name");
        l0.setFont(new Font("Arial", Font.PLAIN, 15));
        l0.setBounds(50, 470, 200, 30);
        add(l0);

        t9 = new JTextField();
        t9.setBounds(50, 500, 200, 30);
        add(t9);

        l11 = new JLabel("Confirm Password");
        l11.setFont(new Font("Arial", Font.PLAIN, 15));
        l11.setBounds(360, 470, 200, 30);
        add(l11);

        t0 = new JPasswordField();
        t0.setBounds(360, 500, 200, 30);
        add(t0);

        String toe[]= { "Admin","Employee","Customer"};
        b= new JComboBox(toe);
        b.setBounds(360, 360, 200, 30);
        add(b);
        b.addActionListener(this);

        b1 = new JButton("SIGN IN");
        b1.setBounds(260, 550, 100, 30);
        add(b1);
        b1.addActionListener(this);

        b4 = new JButton("CANCEL");
        b4.setBounds(260, 590, 100, 30);
        add(b4);
        b4.addActionListener(this);

        setVisible(true);

    }
    public void takedata()
    {
        Name = String.valueOf(t1.getText());
        States = String.valueOf(t2.getText());
        contact_No = String.valueOf(t3.getText());
        email_id = String.valueOf(t4.getText());
        password = String.valueOf(t5.getText());
        DOB = String.valueOf(t8.getText());
        fath_name = String.valueOf(t9.getText());
        confirm_password = String.valueOf(t0.getText());
    }
    public void dropdata()
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t8.setText("");
        t0.setText("");
        t9.setText("");
    }
    public void passwrd(){
        String str;
        int max = 10000;
        int min = 1;
        int range = max - min + 1;
        for (int i = 0; i < 10000; i++) {
            rand = (int) (Math.random() * range) + min;
        }
        str=String.valueOf(t1.getText());
        int l = str.length();
        String arr[] = new String[l];
        char a= str.charAt(0);
        int f = str.charAt(0);
        char b = (char) (f+2);
        answer=tou.concat(String.valueOf(a)+String.valueOf(b)+""+rand);
    }
    public void datastore()
    {
        takedata();

        try {
            if (password.compareTo(confirm_password) == 0) {
                String sql = "insert into sign_up values ('" + Name + "', '" + contact_No + "', '" + States + "', '" + email_id + "', '" + password + "', '" + tou + "', '" + gender + "', '" + DOB + "' , '" + fath_name + "', '" + path_image + "', '" + answer + "')";
                ps = newt.con.prepareStatement(sql);
                ps.execute();
                dropdata();
            }
            else {
                JOptionPane.showMessageDialog(this, "Sorry Try again");
                dropdata();
            }
            }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s= "you are signed in";
        if(e.getSource() == b1) {
                passwrd();
            datastore();
            String s1 = "Please save, Your user_id is" + answer;
            JOptionPane.showMessageDialog(this, s);
            JOptionPane.showMessageDialog(this, s1);
        }
        if(e.getSource() == b2)
        {
            fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                file = fileChooser.getSelectedFile();
                l7.setIcon(new ImageIcon(new ImageIcon(file.getAbsolutePath(), "FrameLogo").getImage().getScaledInstance(l7.getWidth(), l7.getHeight(), Image.SCALE_DEFAULT)));
                try {
                    path_image = (file.getCanonicalPath()).replace("\\","\\\\");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                l7.setText("Open command canceled");
            }
        }
        if(e.getSource() == b)
        {
            tou = String.valueOf(b.getItemAt(b.getSelectedIndex()));
        }
        if(e.getSource() == b3)
        {
            gender = String.valueOf(b3.getItemAt(b3.getSelectedIndex()));
        }
        if(e.getSource()==b4){
            dropdata();
        }
    }
}
public class sec_page
{
    public static void main(String[] args) {
        frame_2 obj = new frame_2();
    }
}
