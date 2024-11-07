package learner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class vehicle_2 extends JFrame implements ActionListener {
    JButton b;
    JRadioButton rb1;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    String   chassis_no,Date_of_service,brakes,spark_plugs, oil_filter,Battery,radiator, air_filter;
     int rt2 = 0;
    bridge newt_1;
    PreparedStatement ps_1 = null;
    void report(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650, 700);
        getContentPane().setBackground(Color.getHSBColor(57,57,350));
        newt_1 = new bridge();
        newt_1.connected();
        setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = getWidth();
        int height = getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        setLocation(north, east);
        setResizable(false);

        setLayout(new BorderLayout());
        //setContentPane(new JLabel((Icon) new ImageIcon("C:\\Users\\hp\\Downloads\\traffic-vehicle-urban-reflections-city (1).jpg")));
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\arseny-togulev-xTXIAVRI3rA-unsplash.jpg").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, 680, 680);
        add(background);
        background.setLayout(null);

        l= new JLabel("<html><font size='6' color=red> VEHICLE MAINTAINANCE </font> </html>\");");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(190,20,300,50);
        background.add(l);

        l1= new JLabel("<html><font size='5' color=#000063> Chassis No. </font> </html>\");");
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l1.setBounds(15,70,200,30);
        background.add(l1);

        t1 = new JTextField();
        t1.setBounds(15, 100, 200, 30);
        background.add(t1);

        l2= new JLabel("<html><font size='5' color=#000063> Date of Servicing</font> </html>\");");
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setBounds(15,140,200,30);
        background.add(l2);

        t2 = new JTextField();
        t2.setBounds(15, 170, 200, 30);
        background.add(t2);

        l3= new JLabel("<html><font size='5' color=#000063>Brakes </font> </html>\");");
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setBounds(15,210,200,30);
        background.add(l3);

        t3 = new JTextField();
        t3.setBounds(15, 240, 200, 30);
        background.add(t3);

        l4= new JLabel("<html><font size='5' color=#000063> Spark Plugs </font> </html>\");");
        l4.setFont(new Font("Arial", Font.PLAIN, 20));
        l4.setBounds(15,280,200,30);
        background.add(l4);

        t4 = new JTextField();
        t4.setBounds(15,310 , 200, 30);
        background.add(t4);

        l5= new JLabel("<html><font size='5' color=#000063> Oil Filter </font> </html>\");");
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setBounds(15,350,200,30);
        background.add(l5);

        t5 = new JTextField();
        t5.setBounds(15,380 , 200, 30);
        background.add(t5);

        l6= new JLabel("<html><font size='5' color=#000063> Battery </font> </html>\");");
        l6.setFont(new Font("Arial", Font.PLAIN, 20));
        l6.setBounds(15,420,200,30);
        background.add(l6);

        t6 = new JTextField();
        t6.setBounds(15,450 , 200, 30);
        background.add(t6);

        l7= new JLabel("<html><font size='5' color=#000063> Radiator </font> </html>\");");
        l7.setFont(new Font("Arial", Font.PLAIN, 20));
        l7.setBounds(15,490,200,30);
        background.add(l7);

        t7 = new JTextField();
        t7.setBounds(15,520 , 200, 30);
        background.add(t7);

        l8= new JLabel("<html><font size='5' color=#000063> Air Filter </font> </html>\");");
        l8.setFont(new Font("Arial", Font.PLAIN, 20));
        l8.setBounds(15,560,200,30);
        background.add(l8);

        t8= new JTextField();
        t8.setBounds(15,590 , 200, 30);
        background.add(t8);

        rb1=new JRadioButton("UPDATE");
        rb1.setBounds(300,500,150,30);
        background.add(rb1);
        b=new JButton("INSERT");
        b.setBounds(330,550,80,30);
        background.add(b);
        rb1.addActionListener(this);
        b.addActionListener(this);

        setVisible(true);
        setLocation(north, east);
    }
    public void get_data(){
        chassis_no =String.valueOf(t1.getText());
        Date_of_service = String.valueOf(t2.getText());
        brakes = String.valueOf(t3.getText());
        spark_plugs = String.valueOf(t4.getText());
        oil_filter = String.valueOf(t5.getText());
        Battery = String.valueOf(t6.getText());
       radiator= String.valueOf(t7.getText());
        air_filter = String.valueOf(t8.getText());
    }
    public void datastore() throws SQLException {
        String qual = "Data has been updated";
        String qualI = "Data has been Insert";
        String qual2 = "Data not found";
        get_data();
        if (rt2 == 0) {
            try {

                String sql = "insert into vehicle_2 values ('" + chassis_no + "', '" + Date_of_service + "', '" + brakes + "', '" + spark_plugs + "', '" + oil_filter + "', '" + Battery + "', '" + radiator + "', '" + air_filter + "')";
                ps_1 = newt_1.con.prepareStatement(sql);
                ps_1.execute();
                JOptionPane.showMessageDialog(this, qualI);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (rt2 == 1) {
            try {
                String sq = "UPDATE vehicle_2 SET chassis_no='" + String.valueOf(t1.getText()) + "', d_of_servicing='" + String.valueOf(t2.getText()) + "', brakes='" + String.valueOf(t3.getText()) + "', spark_plugs='" + String.valueOf(t4.getText()) + "', oil_filter='" + String.valueOf(t5.getText()) + "', battery='" + String.valueOf(t6.getText()) + "', radiator='" + String.valueOf(t7.getText()) + "', air_filter='" + String.valueOf(t8.getText()) + "' WHERE chassis_no = '" + String.valueOf(t1.getText()) + "'";
                ps_1 = newt_1.con.prepareStatement(sq);
                ps_1.execute();
                JOptionPane.showMessageDialog(this, qual);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, qual2);
        }
        }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==rb1) {
            String qu = "data should be filled in every field";
            String qu1 = "data not found";
            // If condition to check if jRadioButton2 is selected.
            if (rb1.isSelected()) {
                if(String.valueOf(t1.getText()).compareTo("") == 0 && String.valueOf(t2.getText()).compareTo("") == 0 &&  String.valueOf(t3.getText()).compareTo("") == 0  &&  String.valueOf(t4.getText()).compareTo("") == 0  &&  String.valueOf(t5.getText()).compareTo("") == 0  &&  String.valueOf(t6.getText()).compareTo("") == 0  &&  String.valueOf(t7.getText()).compareTo("") == 0  &&  String.valueOf(t8.getText()).compareTo("") == 0)
                {
                    JOptionPane.showMessageDialog(this, qu);
                }
                 else
                 {
                    rt2 = 1;
                    // MessageDialog to show information selected radio buttons.
                }
            }
        }
        if(e.getSource()==b){

            try {
                datastore();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public static void main(String[] args){
        vehicle_2 obj = new vehicle_2();
        obj.report();
    }

}
