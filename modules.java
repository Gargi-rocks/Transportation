package learner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.Objects;

public class modules implements ActionListener {
    JLabel l,l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    int x, y;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;

    void employee(String usediid, String name1, String contactw1, String emaild1, String fname1, String pathI, String tou) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        f.setSize(screenWidth, screenHeight);
        f.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_DEFAULT));
        f.setResizable(false);

         f.setLayout(new BorderLayout());
         JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\TMS_Photoes").getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, screenWidth, screenHeight);
        f.add(background);
        background.setLayout(null);

        l = new JLabel("<html><font size='17' color=#E67E22>W<span style=\"font-variant: small-caps;\">ELCOME</smalcap> TO TRANSPORT MANAGEMENT SYSTEM</font> </html>");
        l.setBounds(200,5,1000,50);
        l.setFont(new Font("Arial", Font.PLAIN, 25));
        background.add(l);

        // photo
        l7 = new JLabel();
        l7.setBounds(950, 70, 140, 95);
        l7.setIcon(new ImageIcon(new ImageIcon(pathI, "Logo").getImage().getScaledInstance(l7.getWidth(), l7.getHeight(), Image.SCALE_DEFAULT)));
        l7.setText(pathI);
        background.add(l7);

        //master module
        l1 = new JLabel("<html><font size='5' color=#F4D03F> MASTER MODULE </font> </html>");
        l1.setBounds(120,90,200,30);
        l1.setFont(new Font("Arial", Font.BOLD, 18));
        l1.setBackground(Color.white);
        background.add(l1);

        b1 = new JButton("Fare Management");
        b1.setBounds(120,270,150,30);
        b1.setFont(new Font("Arial", Font.PLAIN,15 ));
        background.add(b1);

        b2 = new JButton("Add Employee");
        b2.setBounds(120,120,150,30);
        b2.setFont(new Font("Arial", Font.PLAIN,15 ));
        b2.addActionListener(this);
        background.add(b2);

        b3 = new JButton("Delivery Status");
        b3.setBounds(120,150,150,30);
        b3.setFont(new Font("Arial", Font.PLAIN, 15));
        b3.addActionListener(this);
        background.add(b3);

        b4 = new JButton("Manage employee");
        b4.setBounds(120,180,150,30);
        b4.setFont(new Font("Arial", Font.PLAIN, 15));
        b4.addActionListener(this);
        background.add(b4);

        b5 = new JButton("Manage Customer");
        b5.setBounds(120,210,150,30);
        b5.setFont(new Font("Arial", Font.PLAIN, 15));
        b5.addActionListener(this);
        background.add(b5);

        b13 = new JButton("Delivery Allotment");
        b13.setBounds(120,240,150,30);
        b13.setFont(new Font("Arial", Font.PLAIN, 15));
        b13.addActionListener(this);
        background.add(b13);

        //vehicle module
        l2 = new JLabel("<html><font size='5'  color=#dc7633> VEHICLE MODULE </font> </html>\");");
        l2.setBounds(250,320,200,30);
        l2.setFont(new Font("Arial", Font.BOLD, 18));
        l2.setBackground(Color.white);
        background.add(l2);

        b6 = new JButton("Add vehicle");
        b6.setBounds(250,360,150,30);
        b6.setFont(new Font("Arial", Font.PLAIN, 15));
        b6.addActionListener(this);
        background.add(b6);

        b7 = new JButton("Manage Vehicle");
        b7.setBounds(250,390,150,30);
        b7.setFont(new Font("Arial", Font.PLAIN, 15));
        background.add(b7);
        b7.addActionListener(this);

        //bilty module
        l0 = new JLabel("<html><font size='5' color=#F4D03F> BILTY MODULE </font> </html>\");");
        l0.setBounds(250,420,200,30);
        l0.setFont(new Font("Arial", Font.BOLD, 18));
        l0.setBackground(Color.white);
        background.add(l0);

        b8 = new JButton("Add Bilty");
        b8.setBounds(250,450,150,30);
        b8.setFont(new Font("Arial", Font.PLAIN, 15));
        b8.addActionListener(this);
        background.add(b8);

        //customer module
        l3 = new JLabel("<html><font size='5' color=#F4D03F> CUSTOMER MODULE </font> </html>\");");
        l3.setBounds(10,320,200,30);
        l3.setFont(new Font("Arial", Font.BOLD, 18));
        l3.setBackground(Color.white);
        background.add(l3);

        b9 = new JButton("Delivery Status");
        b9.setBounds(10,360,150,30);
        b9.setFont(new Font("Arial", Font.PLAIN, 15));
        b9.addActionListener(this);
        background.add(b9);

        //contact button
        b10 = new JButton("Contact Us");
        b10.setBounds(1000,610,200,30);
        b10.setFont(new Font("Arial", Font.PLAIN, 18));
        background.add(b10);

        //employee module
        l6 = new JLabel("<html><font size='5' color=#2ecc71> EMPLOYEE MODULE </font> </html>\");");
        l6.setBounds(10,390,200,30);
        l6.setFont(new Font("Arial", Font.BOLD, 18));
        l6.setBackground(Color.white);
        background.add(l6);

        b11 = new JButton("Status Update");
        b11.setBounds(10,420,150,30);
        b11.setFont(new Font("Arial", Font.PLAIN, 15));
        b11.addActionListener(this);
        background.add(b11);

        b12 = new JButton("Work Status");
        b12.setBounds(10,450,150,30);
        b12.setFont(new Font("Arial", Font.PLAIN, 15));
        b12.addActionListener(this);
        background.add(b12);

        //label for id's
        l4= new JLabel("<html><font size='5' color=#D35400 > USER_ID </font> </html>\");");
        l4.setFont(new Font("Arial", Font.BOLD, 10));
        l4.setBounds(1000,120,300,30);
        background.add(l4);

        l5 = new JLabel("Text Color: RED");
        l5.setForeground (Color.RED);
        l5.setText(usediid);
        l5.setBounds(1400, 150, 200, 30);
        background.add(l5);

        b14 = new JButton("ABOUT");
        b14.setBounds(20,610,200,30);
        b14.setFont(new Font("Arial", Font.PLAIN, 18));
        b14.addActionListener(this);
        background.add(b14);

        //details labelS
        l8 = new JLabel("<html><font size='5' color=#CCFF00> CUSTOMER NAME :-</font> </html>\");");
        l8.setBounds(900,180,120,50);
        l8.setFont(new Font("Arial", Font.BOLD, 18));
        l8.setBackground(Color.white);
        background.add(l8);

        l12 = new JLabel("Text Color: RED");
        l12.setForeground (Color.RED);
        l12.setBounds(1050, 200, 200, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 18));
        l12.setText(name1);
        background.add(l12);

        l9 = new JLabel("<html><font size='5' color=#CCFF00> FATHER's NAME :-</font> </html>\");");
        l9.setBounds(900,250,120,50);
        l9.setFont(new Font("Arial", Font.BOLD, 18));
        l9.setBackground(Color.white);
        background.add(l9);

        l13 = new JLabel("Text Color: RED");
        l13.setForeground (Color.RED);
        l13.setBounds(1050, 260, 200, 30);
        l13.setFont(new Font("Arial", Font.BOLD, 18));
        l13.setText(fname1);
        background.add(l13);

        l10 = new JLabel("<html><font size='5' color=#CCFF00> CONTACT NO :-</font> </html>\");");
        l10.setBounds(900,320,120,50);
        l10.setFont(new Font("Arial", Font.BOLD, 18));
        l10.setBackground(Color.white);
        background.add(l10);

        l14 = new JLabel("Text Color: RED");
        l14.setForeground (Color.RED);
        l14.setBounds(1050, 320, 120, 30);
        l14.setFont(new Font("Arial", Font.BOLD, 18));
         l14.setText(contactw1);
        background.add(l14);

        l11 = new JLabel("<html><font size='5' color=#CCFF00> EMAIL ID :-</font> </html>\");");
        l11.setBounds(900,380,120,30);
        l11.setFont(new Font("Arial", Font.BOLD, 18));
        l11.setBackground(Color.white);
        background.add(l11);

        l15 = new JLabel("Text Color: RED");
        l15.setForeground (Color.RED);
        l15.setBounds(1050, 380, 200, 30);
        l15.setFont(new Font("Arial", Font.BOLD, 18));
        l15.setText(emaild1);
        background.add(l15);

        l16 = new JLabel("<html><font size='5' color=#CCFF00> Type of User :-</font> </html>\");");
        l16.setBounds(900,440,250,30);
        l16.setFont(new Font("Arial", Font.BOLD, 18));
        l16.setBackground(Color.white);
        background.add(l16);

        l17 = new JLabel("Text Color: RED");
        l17.setForeground (Color.RED);
        l17.setBounds(1050, 440, 200, 30);
        l17.setFont(new Font("Arial", Font.BOLD, 18));
        l17.setText(tou);
        background.add(l17);

        if(Objects.equals(tou, "Customer")){
            b3.setVisible(false);
            b2.setVisible(false);
            b1.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
            b6.setVisible(false);
            l2.setVisible(false);
            b7.setVisible(false);
            l6.setVisible(false);
            b11.setVisible(false);
            b12.setVisible(false);
            l1.setVisible(false);
            b13.setVisible(false);
            l0.setBounds(250,320,200,30);
            b8.setBounds(250,360,150,30);

        }
        if(Objects.equals(tou, "Employee")){
            b3.setVisible(false);
            b2.setVisible(false);
            b1.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
            b9.setVisible(false);
            l3.setVisible(false);
            b8.setVisible(false);
            l0.setVisible(false);
            l1.setVisible(false);
            b13.setVisible(false);
            l6.setBounds(250,200,200,30);
            b11.setBounds(250,230,150,30);
            b12.setBounds(250,260,150,30);
        }

        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent oEvent) {
        if (oEvent.getSource() == b2) { // check if Action is triggered by JButton
            employee_1 obj1 = new  employee_1();
            obj1.details();
        }
        if (oEvent.getSource() == b6) { // check if Action is triggered by JButton
            vehicle_1 obj = new vehicle_1();
            obj.details();
        }
        if (oEvent.getSource() == b7) { // check if Action is triggered by JButton
            vehicle_2 obj = new vehicle_2();
            obj.report();
        }
        if(oEvent.getSource()==b4){
            manage_emp sr = new manage_emp();
            sr.table23();
        }
        if(oEvent.getSource()==b5){
            manage_custom sr = new manage_custom();
            sr.table2();
        }
        if(oEvent.getSource()==b13){
            alloting obj = new alloting();
            obj.details();
        }
        if(oEvent.getSource()==b12){
            allotments sr = new allotments();
            sr.delivery();
        }
        if(oEvent.getSource()==b8){
            delivery_1 obj = new delivery_1();
            obj.details_1();
        }
        if(oEvent.getSource()==b3){
            status_update update = new status_update();
            update.table();
        }
        if(oEvent.getSource()==b9){
            status_update update = new status_update();
            update.table();
        }
        if(oEvent.getSource()==b11){
            SearchClientFrm myFrame = new SearchClientFrm();
            myFrame.setSize(900,300);
            myFrame.setVisible(true);
            myFrame.setLocation(200,10);
        }
        if(oEvent.getSource()==b14){
           About obj = new About();

        }
    }


}

