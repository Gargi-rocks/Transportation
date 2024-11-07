package learner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class allotments extends javax.swing.JFrame {
    String[] columnNames = {"Employee Name","Employee id","contact no.","Licence Number", "CR NO.", "Pickup address","Destination"};
    static JTable table;
    PreparedStatement ps = null;
    bridge newt;
    void delivery(){
        newt = new bridge();
        newt.connected();
        setTitle("Transport Manangement System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        int width = this.getWidth();
        int height = this.getHeight();
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;


        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        table.setBounds(40,80,500,300);
        String emp= "";
        String con= "";
        String lisc = "";
        String cr = "";
        String from = "";
        String to = "";
        String empna = "";
        try
        {
            String sql = "SELECT employee_id, employee_name, license_no,contact_no,cr_no,from_add,to_addr FROM allotment " ;
            ps = newt.con6.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i =0;
            while(rs.next())
            {
                empna = rs.getString("employee_name");
                emp = rs.getString("employee_id");
                con = rs.getString("contact_no");
                lisc  = rs.getString("license_no");
                cr = rs.getString("cr_no");
                from = rs.getString("from_add");
                to = rs.getString("to_addr");
                model.addRow(new Object[]{empna,emp, con, lisc,cr,from,to});
                i++;
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
        add(scroll);

        setSize(screenWidth, screenHeight);
        setVisible(true);
    }

    public static void main(String args[])
    {
       allotments sr = new allotments();
        sr.delivery();
    }
}
