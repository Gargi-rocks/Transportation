package learner;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delivery_1 extends JFrame implements ActionListener{
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l0,l11,l12,l13,l14,l15;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JTextArea a1,a2;
    JButton b1,b2;
    int rand;
    String cr , customer_name, sender_no, receiver_name, reciever_no, sender_aadhar_no, cr_no, total_dis, total_cost , from_add , to_addr ,user_id;
    PreparedStatement prep = null;
    bridge newt_2;

    void details_1() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newt_2 = new bridge();
        newt_2.connected();
        setLayout(null);
        setSize(800, 700);
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
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\TMS_Photoes\\2534028.jpg").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, 680, 680);
        add(background);
        background.setLayout(null);


        l= new JLabel("<html><font size='6' color=red>   DELIVERY DETAILS </font> </html>\");");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(270,20,500,50);
        background.add(l);

        l1= new JLabel("<html><font size='5' color=#6E2C00> Customer Name </font> </html>\");");
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l1.setBounds(15,70,300,30);
        background.add(l1);

        t1 = new JTextField();
        t1.setBounds(15, 100, 200, 30);
        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t1.setBorder(border1);
        background.add(t1);

        l2= new JLabel("<html><font size='5' color=#6E2C00>Sender's Contact No </font> </html>\");");
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setBounds(15,140,200,30);
        background.add(l2);

        t2 = new JTextField();
        t2.setBounds(15, 170, 200, 30);
        Border border2 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t2.setBorder(border2);
        background.add(t2);

        l3= new JLabel("<html><font size='5' color=#6E2C00>Reciever's Name </font> </html>\")/.;");
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setBounds(15,210,200,30);
        background.add(l3);

        t3 = new JTextField();
        t3.setBounds(15, 240, 200, 30);
        Border border3 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t3.setBorder(border3);
        background.add(t3);

        l4= new JLabel("<html><font size='5' color=#6E2C00> Reciever's Contact No. </font> </html>\");");
        l4.setFont(new Font("Arial", Font.PLAIN, 20));
        l4.setBounds(15,280,200,30);
        background.add(l4);

        t4 = new JTextField();
        t4.setBounds(15,310 , 200, 30);
        Border border4 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t4.setBorder(border4);
        background.add(t4);

        l5= new JLabel("<html><font size='5' color=#6E2C00>User_id</font> </html>\");");
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setBounds(15,350,200,30);
        background.add(l5);

        t5 = new JTextField();
        t5.setBounds(15,380 , 200, 30);
        Border border5 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t5.setBorder(border5);
        background.add(t5);

        l6= new JLabel("<html><font size='5' color=#6E2C00> Sender's Aadhar no.</font> </html>\");");
        l6.setFont(new Font("Arial", Font.PLAIN, 20));
        l6.setBounds(15,420,300,30);
        background.add(l6);

        t6 = new JTextField();
        t6.setBounds(15,450 , 200, 30);
        Border border6 = BorderFactory.createLineBorder(Color.BLACK, 2);
        t6.setBorder(border6);
        background.add(t6);


        l8= new JLabel("Address of Transport :-");
        l8.setFont(new Font("Arial", Font.PLAIN, 20));
        l8.setBounds(400,70,300,30);
        background.add(l8);

        l9= new JLabel("<html><font size='5' color=#6E2C00>FROM</font> </html>\");");
        l9.setFont(new Font("Arial", Font.BOLD, 18));
        l9.setBounds(400,100,100,30);
        background.add(l9);

        a1 = new JTextArea();
        JScrollPane scrollableTextArea = new JScrollPane(a1);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setBounds(400, 130, 330,140);
        Border bold = BorderFactory.createLineBorder(Color.BLACK, 2);
        a1.setBorder(bold);
        background.add(scrollableTextArea);

        l0= new JLabel("<html><font size='5' color=#78281F>TO</font> </html>\");");
        l0.setFont(new Font("Arial", Font.BOLD, 18));
        l0.setBounds(400,290,100,30);
        background.add(l0);

        a2 = new JTextArea();
        JScrollPane scrollableTextArea2 = new JScrollPane(a2);
        scrollableTextArea2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea2.setBounds(400, 320, 330,140);
        Border bold1 = BorderFactory.createLineBorder(Color.BLACK, 2);
        a2.setBorder(bold1);
        background.add(scrollableTextArea2);

        // button
        b1=new JButton("CONFIRM");
        b1.setBounds(320,550,100,30);
        b1.addActionListener(this);
        background.add(b1);


        l7= new JLabel("<html><font size='4' color=#78281F>TOTAL DISTANCE</font> </html>\");");
        l7.setFont(new Font("Arial", Font.PLAIN, 15));
        l7.setBounds(15,490,300,30);
        background.add(l7);
        l7.setVisible(false);

        l11= new JLabel();
        l11.setFont(new Font("Arial", Font.PLAIN, 15));
        Border border7 = BorderFactory.createLineBorder(Color.BLACK, 2);
        l11.setBounds(15,520,200,30);
        l11.setBorder(border7);
        background.add(l11);
        l11.setVisible(false);

        l12= new JLabel("<html><font size='4' color=#78281F>TOTAL COST</font> </html>\");");
        l12.setFont(new Font("Arial", Font.PLAIN, 15));
        l12.setBounds(15,560,300,30);
        background.add(l12);
        l12.setVisible(false);

        l13= new JLabel();
        l13.setFont(new Font("Arial", Font.PLAIN, 15));
        Border border8 = BorderFactory.createLineBorder(Color.BLACK, 2);
        l13.setBounds(15,590,200,30);
        l13.setBorder(border8);
        l13.setVisible(false);
        background.add(l13);

        l14= new JLabel("<html><font size='4' color=#78281F>CR No</font> </html>\");");
        l14.setFont(new Font("Arial", Font.PLAIN, 15));
        l14.setBounds(500,490,300,30);
        l14.setVisible(false);
        background.add(l14);

        l15= new JLabel();
        l15.setFont(new Font("Arial", Font.PLAIN, 15));
        Border border9 = BorderFactory.createLineBorder(Color.BLACK, 2);
        l15.setBounds(500,520,200,30);
        l15.setBorder(border9);
        l15.setVisible(false);
        background.add(l15);

        setVisible(true);
        setResizable(false);

        b2=new JButton("PAYMENT");
        b2.setBounds(600,600,100,30);
        b2.addActionListener(this);
        background.add(b2);
        b2.setVisible(false);
    }
    public void cr() {
        int max = 10000;
        int min = 1;
        int range = max - min + 1;
        for (int i = 1; i < 10000; i++) {
            rand = (int) (Math.random() * range) + min;
        }
    }
    void get_data(){
       customer_name =String.valueOf(t1.getText());
        sender_no = String.valueOf(t2.getText());
       receiver_name = String.valueOf(t3.getText());
        reciever_no = String.valueOf(t4.getText());
        user_id = String.valueOf(t5.getText());
        sender_aadhar_no = String.valueOf(t6.getText());
        total_cost = String.valueOf(l13.getText());
        total_dis= String.valueOf(l11.getText());
        cr_no= String.valueOf(l15.getText());
        from_add = String.valueOf(a1.getText());
        to_addr = String.valueOf(a2.getText());
    }
    public void datastore() throws SQLException {

        get_data();
        try {
            String qualI = "Data has been Insert";
            String sql = "insert into bilty values ('" + customer_name+ "', '" + sender_no + "', '" +receiver_name+ "', '" + reciever_no + "', '" +sender_aadhar_no + "', '" +total_dis + "', '" +total_cost +"', '" +cr_no + "', '" +from_add + "', '" +to_addr + "','" +user_id + "')";
            prep = newt_2.con.prepareStatement(sql);
            prep.execute();
            JOptionPane.showMessageDialog(this, qualI);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void actionPerformed (ActionEvent e){

        if (e.getSource() == b1) {
            cr();
            b2.setVisible(true);
            l7.setVisible(true);
            l11.setVisible(true);
            l12.setVisible(true);
            l13.setVisible(true);
            l14.setVisible(true);
            l15.setText(String.valueOf(rand));
            l15.setVisible(true);

        }
        if(e.getSource()==b2){
            try {
                datastore();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args) {
       delivery_1 obj = new delivery_1();
        obj.details_1();
    }
}
