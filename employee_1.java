package learner;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.PreparedStatement;

class employee_1 extends javax.swing.JFrame implements ActionListener{
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b;
    String employee_name,age,blood_gr,contact_no,license_no,permanent_add,adhar_no,user_id;
    PreparedStatement ps = null;
    bridge newt;

    employee_1() {
    }

    void details() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        newt = new bridge();
        newt.connected();
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
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\TMS_Photoes\\cover-1.jpg").getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, 680, 680);
        add(background);
        background.setLayout(null);


        l= new JLabel("<html><font size='6' color=#B71C1C> ADD EMPLOYEE DETAILS </font> </html>\");");
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setBounds(190,0,400,40);
        background.add(l);

        l1= new JLabel("<html><font size='5' color=#000063> Employee Name </font> </html>\");");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setBounds(15,60,300,30);
        background.add(l1);

        t1 = new JTextField();
        t1.setBounds(15, 90, 200, 30);
        background.add(t1);

        l2= new JLabel("<html><font size='5' color=#000063> Age </font> </html>\");");
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setBounds(15,130,200,30);
        background.add(l2);

        t2 = new JTextField();
        t2.setBounds(15, 160, 200, 30);
        background.add(t2);

        l3= new JLabel("<html><font size='5' color=#000063>Blood Group </font> </html>\");");
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setBounds(15,200,200,30);
        background.add(l3);

        t3 = new JTextField();
        t3.setBounds(15, 230, 200, 30);
        background.add(t3);

        l4= new JLabel("<html><font size='5' color=#000063> Contact No. </font> </html>\");");
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setBounds(15,270,200,30);
        background.add(l4);

        t4 = new JTextField();
        t4.setBounds(15,300 , 200, 30);
        background.add(t4);

        l5= new JLabel("<html><font size='5' color=#000063> License No. </font> </html>\");");
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setBounds(15,340,200,30);
        background.add(l5);

        t5 = new JTextField();
        t5.setBounds(15,370 , 200, 30);
        background.add(t5);

        l6= new JLabel("<html><font size='5' color=#000063> Permanent Address</font> </html>\");");
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setBounds(15,410,200,30);
        background.add(l6);

        t6 = new JTextField();
        t6.setBounds(15,440 , 200, 30);
        background.add(t6);

        l7= new JLabel("<html><font size='5' color=#000063> Aadhar No. </font> </html>\");");
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setBounds(15,480,200,30);
        background.add(l7);

        t7 = new JTextField();
        t7.setBounds(15,510 , 200, 30);
        background.add(t7);

        l8= new JLabel("<html><font size='5' color=#000063> UserId No. </font> </html>\");");
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setBounds(15,550,200,30);
        background.add(l8);

        t8 = new JTextField();
        t8.setBounds(15,580 , 200, 30);
        background.add(t8);

        b=new JButton("ADD");
        b.setBounds(500,580,100,30);
        b.addActionListener(this);
        background.add(b);

        setVisible(true);
    }
    public void takedata() {
        employee_name = String.valueOf(t1.getText());
        age = String.valueOf(t2.getText());
        blood_gr = String.valueOf(t3.getText());
        contact_no = String.valueOf(t4.getText());
        license_no = String.valueOf(t5.getText());
       permanent_add = String.valueOf(t6.getText());
        adhar_no = String.valueOf(t7.getText());
        user_id = String.valueOf(t8.getText());
    }
    public void datastore()
    {
        takedata();
        try {

            String sql = "insert into employee_1 values ('"+employee_name+"', '"+age+"', '"+blood_gr+"', '"+contact_no+"', '"+license_no+"', '"+permanent_add+"' , '"+adhar_no+"', '"+user_id+"')";
            ps = newt.con.prepareStatement(sql);
            ps.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try{
            FileOutputStream fout=new FileOutputStream("C:\\Users\\hp\\Desktop\\Garginew1.txt");
            String s = employee_name+"', '"+age+"', '"+blood_gr+"', '"+contact_no+"', '"+license_no+"', '"+permanent_add+"' , '"+adhar_no+"', '"+user_id;
            byte b[]=s.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        }catch(Exception e){System.out.println(e);}


        /*try{
            FileInputStream fin=new FileInputStream("C:\\Users\\hp\\Desktop\\Garginew1.txt");
            int i=0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
        }catch(Exception e){System.out.println(e);}*/
    }
    public void actionPerformed(ActionEvent e) {
        String s = "Data has been inserted";
        if (e.getSource() == b) {
            datastore();
            JOptionPane.showMessageDialog(this, s);
        }
    }
    public static void main(String[] args) {
        employee_1 obj = new employee_1();
        obj.details();
    }
}
