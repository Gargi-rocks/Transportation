package learner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class manage_custom extends javax.swing.JFrame implements ActionListener {
    JButton button;
    JLabel label;
    static JTable table;
    PreparedStatement ps = null;
    bridge newt;
    String[] columnNames = {"Customer Name","State","Contact Number", "Email Id", "Gender","Father's Name"};

    public void table2()
    {
        newt = new bridge();
        newt.connected();
        setTitle("Transport Manangement System");
        setSize(300, 300);
        getContentPane().setBackground(Color.getHSBColor(57,57,350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height =getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);
        button = new JButton("search");
        button.setBounds(100,130,100,20);
        button.addActionListener(this);
        add(button);

        label = new JLabel("ALL CUSTOMER DETAILS");
        label.setBounds(60,90,300,30);
        add(label);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        button = (JButton)ae.getSource();
        System.out.println("Showing Table Data.......");
        showTableData();
    }

    public void showTableData()
    {

        JFrame frame1 = new JFrame("Customer Details");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\13.jpg").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        int width = frame1.getWidth();
        int height = frame1.getHeight();
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
       // frame1.setLocation(north, east);
        background.setBounds(0, 0, screenWidth, screenHeight);
        frame1.add(background);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        table.setBounds(40,80,500,300);
        String fir= "";
        String state= "";
        String con = "";
        String email = "";
        String gend = "";
        String fath = "";
        try
        {
            String sql = "select Name,state,contact_no,email_id,gender, fathers_name from sign_up WHERE user_id LIKE 'Cus%';";
            ps = newt.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            FileOutputStream fout=new FileOutputStream("C:\\Users\\hp\\Desktop\\Garginew2.txt");
            int i =0;
            while(rs.next())
            {
                fir = rs.getString("Name");
                state = rs.getString("State");
                con = rs.getString("contact_no");
                email = rs.getString("email_id");
                gend = rs.getString("gender");
                fath = rs.getString("fathers_name");
                model.addRow(new Object[]{fir, state, con, email,gend,fath});
                i++;
                System.out.println(i);
                String s= String.valueOf(fir) + ", "+String.valueOf(state)  + ", "+ String.valueOf(con) + ", "+ String.valueOf(email) + ", "+ String.valueOf(gend) + ", "+ String.valueOf(fath) + "\n";
                byte b[]=s.getBytes();
                fout.write(b);
            }
            try{
                fout.close();
                System.out.println("success...");
            }catch(Exception e){System.out.println(e);}
            if(i <1)
            {
                JOptionPane.showMessageDialog(null, "No Record Found","Error", JOptionPane.ERROR_MESSAGE);
            }
            if(i==1)
            {
                System.out.println(i+" Record Found");
            }
            else
            {
                System.out.println(i+" Records Found");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame1.add(scroll);
        frame1.setVisible(true);
        frame1.setSize(screenWidth,screenHeight);
    }

    public static void main(String args[])
    {
        manage_custom sr = new manage_custom();
        sr.table2();
    }
}
