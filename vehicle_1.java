package learner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
public class vehicle_1 extends JFrame implements ActionListener {
    JLabel l, l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b;
    PreparedStatement prep = null;
    bridge newt_2;
    String date_o_p,sellers_name,model_name,engine_no,chassis_no,tov;
    JComboBox c3;
    void details() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newt_2 = new bridge();
        newt_2.connected();
        setLayout(null);
        setSize(700, 700);
        getContentPane().setBackground(Color.getHSBColor(0, 0, 85));
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height = getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);
        setResizable(true);

        setLayout(new BorderLayout());
        //setContentPane(new JLabel((Icon) new ImageIcon("C:\\Users\\hp\\Downloads\\traffic-vehicle-urban-reflections-city (1).jpg")));
        JLabel background = new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\traffic-vehicle-urban-reflections-city (1).jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, 680, 680);
        add(background);
        background.setLayout(null);
        //setContentPane(new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\traffic-vehicle-urban-reflections-city (1).jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));

        l = new JLabel("ADD DETAILS OF VEHICLE");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(220, 10, 270, 50);
        background.add(l);

        l1 = new JLabel("<html><font size='5' color=red> Date of Purchase </font> </html>\"); ");
        l1.setFont(new Font("Arial", Font.PLAIN, 17));
        l1.setBounds(15, 100, 200, 30);
        background.add(l1);

        t1 = new JTextField();
        t1.setBounds(15, 130, 400, 30);
        background.add(t1);

        l2 = new JLabel("<html><font size='5' color=red> Seller's Name</font> </html>\"); ");
        l2.setFont(new Font("Arial", Font.PLAIN, 17));
        l2.setBounds(15, 180, 200, 30);
        background.add(l2);

        t2 = new JTextField();
        t2.setBounds(15, 210, 400, 30);
        background.add(t2);

        l3 = new JLabel("<html><font size='5' color=red> Type of vehicle</font> </html>\"); ");
        l3.setFont(new Font("Arial", Font.PLAIN, 17));
        l3.setBounds(15, 260, 400, 30);
        background.add(l3);

        JPanel p = new JPanel();
        String veh[] = {"Mini Truck", "Pickup Truck", "Tank truck", "Truck", "Mini Van", "Dump Truck"};
        JComboBox c3 = new JComboBox(veh);
        c3.setBounds(15, 290, 200, 30);
        background.add(c3);

        l4 = new JLabel("<html><font size='5' color=red> Model Name</font> </html>\"); ");
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        l4.setBounds(15, 340, 200, 30);
        background.add(l4);

        t4 = new JTextField();
        t4.setBounds(15, 370, 400, 30);
        background.add(t4);

        l5 = new JLabel("<html><font size='5' color=red> Engine no.</font> </html>\"); ");
        l5.setFont(new Font("Arial", Font.PLAIN, 17));
        l5.setBounds(15, 420, 200, 30);
        background.add(l5);

        t5 = new JTextField();
        t5.setBounds(15, 450, 400, 30);
        background.add(t5);

        l6 = new JLabel("<html><font size='5' color=red> Chassis no.</font> </html>\");");
        l6.setFont(new Font("Arial", Font.PLAIN, 17));
        l6.setBounds(15, 500, 200, 30);
        background.add(l6);

        t6 = new JTextField();
        t6.setBounds(15, 530, 400, 30);
        background.add(t6);

        b = new JButton("add");
        b.setBounds(300, 600, 100, 30);
        background.add(b);
        b.addActionListener(this);

        setVisible(true);
        setLocation(north, east);
        setResizable(false);
    }

    public void get_data() {
        date_o_p =String.valueOf(t1.getText());
        sellers_name = String.valueOf(t2.getText());
        model_name = String.valueOf(t4.getText());
        engine_no = String.valueOf(t5.getText());
        chassis_no = String.valueOf(t6.getText());

    }

    public void datastore() throws SQLException {

        get_data();
            try {
                String qualI = "Data has been Insert";
                String sql = "insert into vehicle_1 values ('" +date_o_p + "', '" + sellers_name + "', '" + tov + "', '" + model_name + "', '" +engine_no + "', '" + chassis_no + "')";
                prep = newt_2.con.prepareStatement(sql);
                prep.execute();
                JOptionPane.showMessageDialog(this, qualI);
            } catch (Exception e) {
                System.out.println(e);
            }
    }
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == b) {
                try {
                    datastore();

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(e.getSource()==c3){
                tov = String.valueOf(c3.getItemAt(c3.getSelectedIndex()));
            }
        }
        public static void main(String[] args){
            vehicle_1 obj = new vehicle_1();
            obj.details();
        }

}
