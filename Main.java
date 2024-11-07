package learner;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
class login extends Component implements ActionListener {
    JLabel l, l1, l2,l3;
    JButton  b1, b2,b3;
    JTextField t, t1;
    JComboBox b7;
    String tou3, useid, passw;
    Connection connection;
    login() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setTitle("Transport Management");
        f.setSize(600, 580);
        f.getContentPane().setBackground(Color.pink);
        f.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = f.getWidth();
        int height = f.getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        f.setLocation(north, east);
        f.setResizable(false);
        l = new JLabel();
        l.setBounds((width / 2) - 30, 30, 50, 60);
        l.setIcon(new ImageIcon(new ImageIcon("D:\\Gargi\\TMS_Photoes\\Login_Front_Image.png", "Logo").getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT)));
        f.add(l);

        l1 = new JLabel("<html><font size='5' color=#6C3483 > USER_ID </font> </html>\");");
        l1.setBounds(50, 100, 100, 30);
        f.add(l1);
        l1.setBackground(Color.BLUE);

        t = new JTextField();
        t.setBounds(50, 130, 200, 30);
        f.add(t);

        t1 = new JPasswordField();
        t1.setBounds(50, 215, 200, 30);
        f.add(t1);

        l2 = new JLabel("<html><font size='5' color=#6C3483 > PASSWORD </font> </html>\");");
        l2.setBounds(50, 180, 120, 30);
        f.add(l2);

        b3 = new JButton("EXIT");
        b3.setBounds((width / 2) - 55, 460, 100, 30);
        b3.addActionListener(this);
        f.add(b3);

        b1 = new JButton("LOGIN");
        b1.setBounds((width / 2) - 140, 400, 100, 30);
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds((width / 2) + 20, 400, 100, 30);
        b2.addActionListener(this);
        f.add(b2);

        l2 = new JLabel("<html><font size='5' color=#6C3483 > TYPE OF USER </font> </html>\");");
        //l2.setBackground(Color.white);
        l2.setBounds(50, 265, 320, 30);
        f.add(l2);

        l3 = new JLabel("hii");
        l3.setBounds(300,130,250,180);
        ImageIcon image = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\Saved Pictures\\caravan-trucks-cargo-transportation-concept-23576201.png").getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_DEFAULT));
         l3.setIcon(image);
         f.add(l3);

        String Tof[] = {"Admin", "Customer", "Employee"};
        b7 = new JComboBox(Tof);
        b7.setBounds(50, 295, 200, 30);
        b7.addActionListener(this);
        f.add(b7);

        f.setVisible(true);
        f.setLocation(north, east);
    }
    public void datapick()
    {
        useid = String.valueOf(t.getText());
        passw = String.valueOf(t1.getText());
    }

    public void actionPerformed(ActionEvent oEvent) {
        if(oEvent.getSource() == b7)
        {
            tou3 = String.valueOf(b7.getItemAt(b7.getSelectedIndex()));
        }
        if(oEvent.getSource() == b3)
        {
            frame_1 obj = new frame_1();
        }
        if(oEvent.getSource() == b2)
        {
            t.setText(" ");
            t1.setText(" ");
        }

        if (oEvent.getSource() == b1) {
            datapick();
            String sql = "SELECT * FROM sign_up;";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TSM", "root", "Gargi@003");
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String user= rs.getString("user_id");
                    String pass= rs.getString("password");
                    String tou1= rs.getString("tou");
                    String name= rs.getString("Name");
                    String contact= rs.getString("contact_no");
                    String emaid= rs.getString("email_id");
                    String fname= rs.getString("fathers_name");
                    String pathI = rs.getString("image_path");
                    if(user.equals(useid) && pass.equals(passw) && tou1.equals(tou3))
                    {
                            modules obj = new modules();
                            obj.employee(String.valueOf(useid),String.valueOf(name),String.valueOf(contact),String.valueOf(emaid),String.valueOf(fname),String.valueOf(pathI),String.valueOf(tou1));
                            break;
                    }

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
     public class Main {
    public static void main ( String [] args){

        login obj = new login ();
    }
     }