package learner;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class alloting extends javax.swing.JFrame implements ActionListener {
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JComboBox c1,c2;
    JTextArea a1,a2;
    Statement stmt;
    PreparedStatement ps = null;
    String employee_id,employee_name,license_no,contact_no,cr_no,from_add,to_addr;
    bridge newt;
    ResultSet rs;
    JButton b;
    void details(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(700, 700);
        getContentPane().setBackground(Color.getHSBColor(10,15,51));
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height = getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);

        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\14.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(0, 0, 700, 700);
        add(background);
        background.setLayout(null);
        setResizable(false);

        newt = new bridge();
        newt.connected();

        l = new JLabel("<html><font size='6' color=red> DELIVERY ALLOTMENT </font> </html>\");");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(200,10,300,50);
        background.add(l);

        l1= new JLabel("<html><font size='5' color=green> EMPLOYEE ID </font> </html>\");");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBounds(50,70,200,30);
        background.add(l1);

        JPanel p = new JPanel();
        String ty[]={"CHOOSE ID"};
        c1 = new JComboBox(ty);
        c1.setBounds(50, 100, 200, 30);
        c1.addActionListener(this);
        background.add(c1);

        l8= new JLabel("<html><font size='5' color=green> CR NO. </font> </html>\");");
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setBounds(50,360,200,30);
        background.add(l8);

        JPanel p1 = new JPanel();
        String cr[]={"CHOOSE CR"};
        c2 = new JComboBox(cr);
        c2.setBounds(50, 390, 200, 30);
        c2.addActionListener(this);
        background.add(c2);

        String sql = "select user_id FROM employee_1";
        try {
            stmt = newt.con2.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String user= rs.getString("user_id");
                System.out.println(user);
                c1.addItem(rs.getString("user_id"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        String sql1 = "select cr_no FROM bilty";
        try {
            stmt = newt.con3.createStatement();
            rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                String user= rs.getString("cr_no");
                System.out.println(user);
                c2.addItem(rs.getString("cr_no"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        l2= new JLabel("<html><font size='5' color=green> EMPLOYEE NAME </font> </html>\");");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(50,140,200,30);
        background.add(l2);

        l3= new JLabel("Name of Emp");
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setBounds(50,170,300,30);
        l3.setVisible(false);
        background.add(l3);

        l4= new JLabel("<html><font size='5' color=green> LICENSE NO. </font> </html>\");");
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setBounds(50,210,200,30);
        background.add(l4);

        l5= new JLabel("integer");
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setBounds(50,240,200,30);
        l5.setVisible(false);
        background.add(l5);

        l6= new JLabel("<html><font size='5' color=green> CONTACT NO. </font> </html>\");");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setBounds(50,280,200,30);
        background.add(l6);

        l7= new JLabel("number");
        l7.setFont(new Font("Arial", Font.PLAIN, 20));
        l7.setBounds(50,320,200,30);
        l7.setVisible(false);
        background.add(l7);

        l9= new JLabel("<html><font size='5' color=green> PICKUP ADDRESS </font> </html>\");");
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setBounds(50,430,300,30);
        background.add(l9);

        a1 = new JTextArea();
        JScrollPane scrollableTextArea = new JScrollPane(a1);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(50, 460, 200,60);
        Border bold = BorderFactory.createLineBorder(Color.BLACK, 2);
        a1.setBorder(bold);
        a1.setVisible(false);
        background.add(scrollableTextArea);

        l10= new JLabel("<html><font size='5' color=green> DESTINATION ADDRESS </font> </html>\");");
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setBounds(50,530,300,30);
        background.add(l10);

        a2 = new JTextArea();
        JScrollPane scrollableTextArea2 = new JScrollPane(a2);
        scrollableTextArea2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea2.setBounds(50, 560, 200,60);
        Border bold1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        a2.setBorder(bold1);
        a2.setVisible(false);
        background.add(scrollableTextArea2);

        b= new JButton("CONFIRM");
        b.setBounds(350,530,100,30);
        b.addActionListener(this);
        background.add(b);

        setVisible(true);
    }
    public static void main(String[] args) {
       alloting obj = new alloting();
       obj.details();
    }
    public void takedata() {
        employee_id= String.valueOf(c1.getItemAt(c1.getSelectedIndex()));
        employee_name = String.valueOf(l3.getText());
        contact_no = String.valueOf(l7.getText());
        license_no = String.valueOf(l5.getText());
        from_add = String.valueOf(a1.getText());
        to_addr = String.valueOf(a2.getText());
        cr_no= String.valueOf(c2.getItemAt(c2.getSelectedIndex()));
    }
    public void datastore()
    {
        takedata();
        try {
                String sql = "insert into allotment values ('" + employee_id + "', '" + employee_name + "', '" +license_no + "', '" + contact_no + "', '" + from_add + "', '" + to_addr + "', 'On the way','" + cr_no + "')";
                ps = newt.con6.prepareStatement(sql);
                ps.execute();
            }

        catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s= "allotment confirmed";
       if(e.getSource()==b){
           datastore();
           JOptionPane.showMessageDialog(this,s);
       }
        if(e.getSource() == c1)
        {
            employee_id = String.valueOf(c1.getItemAt(c1.getSelectedIndex()));
            System.out.println(employee_id);
            String sql2 = "select Name,contact_no,License_no FROM employee_1 WHERE user_id ='"+String.valueOf(c1.getItemAt(c1.getSelectedIndex()))+"'";
            try {
                stmt = newt.con.createStatement();
                rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    l3.setVisible(true);
                    l3.setText(rs.getString("Name"));
                    l7.setVisible(true);
                    l7.setText(rs.getString("contact_no"));
                    l5.setVisible(true);
                    l5.setText(rs.getString("License_no"));
                }
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }
        if(e.getSource() == c2)
        {
            cr_no = String.valueOf(c2.getItemAt(c2.getSelectedIndex()));
            String sql3 = "select from_add,to_add FROM bilty WHERE cr_no = '"+String.valueOf(c2.getItemAt(c2.getSelectedIndex()))+"'";
            try {
                stmt = newt.con.createStatement();
                rs = stmt.executeQuery(sql3);
                while (rs.next()) {
                    a1.setVisible(true);
                    a1.setText(rs.getString("from_add"));
                    a2.setVisible(true);
                    a2.setText(rs.getString("to_add"));

                }
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }
    }
}
