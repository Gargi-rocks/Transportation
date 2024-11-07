package learner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class manage_emp extends javax.swing.JFrame implements ActionListener {
    JButton button;
    JLabel label;
    static JTable table;
    PreparedStatement ps = null;
    bridge newt;
    String[] columnNames = {" Name","Age","Blood Group", "Contact NUmber", "License Number","Permanent Address", "Adhar Number"};

    public void table23()
    {
        newt = new bridge();
        newt.connected();
        setTitle("Employee Details");
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

        label = new JLabel("ALL EMPLOYEE DETAILS");
        label.setBounds(60,90,300,30);
        add(label);
        setResizable(false);
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

        JFrame frame1 = new JFrame("Employee Details");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new BorderLayout());
        frame1.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        frame1.getContentPane().setBackground(Color.getHSBColor(10,15,51));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = frame1.getWidth();
        int height = frame1.getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
       // frame1.setLocation(north, east);
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\14.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
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
        String adhn = "";
        try
        {
            String sql = "select Name,Age,Blood_group,contact_no,License_no,permanent_add, Aadhar_no from employee_1";
            ps = newt.con2.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i =0;
            while(rs.next())
            {
                fir = rs.getString("Name");
                state = rs.getString("Age");
                con = rs.getString("Blood_group");
                email = rs.getString("contact_no");
                gend = rs.getString("License_no");
                fath = rs.getString("permanent_add");
                adhn = rs.getString("Aadhar_no");
                model.addRow(new Object[]{fir, state, con, email,gend,fath,adhn});
                i++;
                System.out.println(i);
            }
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
        frame1.setSize(screenWidth,screenHeight);
        frame1.setVisible(true);
    }

    public static void main(String args[])
    {
        manage_emp sr = new manage_emp();
        sr.table23();
    }
}
