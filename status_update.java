package learner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class status_update extends javax.swing.JFrame   {
    String[] columnNames = {"Employee Name","Employee id","contact no.","Licence Number", "CR NO.", "Pickup address","Destination","Status"};
    static JTable table;
    PreparedStatement ps = null;
    bridge newt;
    JLabel l;
    void table() {
        newt = new bridge();
        newt.connected();
        setTitle("Transport Manangement System");
        setSize(700, 600);
        getContentPane().setBackground(Color.getHSBColor(57, 57, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height = getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);

        setLayout(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);





        JPanel pn2 = new JPanel();
        pn2.setLayout(new BoxLayout(pn2,BoxLayout.Y_AXIS));
        table = new JTable();
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        table.setBounds(40, 80, 500, 300);
        String emp = "";
        String con = "";
        String lisc = "";
        String cr = "";
        String from = "";
        String to = "";
        String empna = "";
        String sa = "";

        try {
            String sql = "SELECT allotment.employee_id, allotment.employee_name, allotment.license_no,allotment.contact_no,allotment.cr_no,allotment.from_add,allotment.to_addr,allotment.Current_status FROM allotment ";
            ps = newt.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                empna = rs.getString("employee_name");
                emp = rs.getString("employee_id");
                con = rs.getString("contact_no");
                lisc = rs.getString("license_no");
                cr = rs.getString("cr_no");
                from = rs.getString("from_add");
                to = rs.getString("to_addr");
                sa = rs.getString("Current_status");

                model.addRow(new Object[]{empna, emp, con, lisc, cr, from, to,sa});
                i++;
                System.out.println(i);
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        add(scroll);
        setVisible(true);
    }

    public static void main(String args[])
    {
        status_update update = new status_update();
        update.table();
    }
}
