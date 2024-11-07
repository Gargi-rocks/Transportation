package learner;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class About {
    JLabel l,l1,l0,l2,l3,l4,l5,l6,l7;
    About(){
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setTitle("Transport Management System");
        f.getContentPane().setBackground(Color.pink);
        f.setSize(600, 580);
        f.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_DEFAULT));
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = f.getWidth();
        int height = f.getHeight();

        f.setSize(screenWidth,screenHeight);
        l0 = new JLabel("hii");
        l0.setBounds(10,200,250,300);
        ImageIcon image = new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\TMS_Photoes\\rosebox-BFdSCxmqvYc-unsplash.jpg").getImage().getScaledInstance(l0.getWidth(), l0.getHeight(), Image.SCALE_DEFAULT));
        l0.setIcon(image);
        f.add(l0);
        f.setResizable(false);

        l= new JLabel("<html><font size='17' color=#E67E22>ABOUT THE APPLICATION</font> </html>");
        l.setBounds(400,10,500,30);
        l.setFont(new Font("Algerian", Font.PLAIN, 25));
        f.add(l);

        l1= new JLabel("<html><font size='5' color=#A716E2>The Transport Management System’ is developed in such a way that user can access every functionality easily.<br> This system is user friendly. User can easily create bills, book transport trip and create expense report.</font> </html>");
        l1.setBounds(300,120,1000,100);
        l1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        f.add(l1);

       l2= new JLabel("<html><font size='5' color=#4DA312> The maintenance of the old transport system is also very low.<br> The old transport system also less Secure and user has to do extra-clerical work because this old system does not generate each and every records.</font> </html>");
        l2.setBounds(300,220,1000,100);
        l2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        f.add(l2);

        l3= new JLabel("<html><font size='5' color=#1354C8 >As user has to do many works manually then it is very difficult to stop irregularities in maintaining the record.<br> And company need very intelligent and diligent employee to keep the records of transport related expenses.<br> So solving all these problems we have developed this project Transport management system.</font> </html>");
        l3.setBounds(300,320,1000,100);
        l3.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        f.add(l3);

        l4= new JLabel("<html><font size='5' color=#1F618D> Through our project Customer can easily track the Transportation status whether the Goods are delivered or not.<br> Also The employee can update the status of work so that Admin can allot new Work to the employee.<br> In short this project ensures transparency for the customer with Security.</font> </html>");
        l4.setBounds(300,400,1000,150);
        l4.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        f.add(l4);

        l5= new JLabel("<html><font size='5' color=Black> ALL RIGHTS RESERVED  @safar.PVT.LMTD.</font> </html>");
        l5.setBounds(10,600,1000,30);
        l5.setFont(new Font("Aerial", Font.PLAIN, 25));
        f.add(l5);

        l6= new JLabel("<html><font size='6' color=Black> CONTACT</font> </html>");
        l6.setBounds(1050,540,150,30);
        l6.setFont(new Font("Aerial", Font.PLAIN, 25));
        f.add(l6);

        l7= new JLabel("<html><font size='4' color=Black> Bijnor Surendra Nagar<br> Pincode- 246701<br> guptagargi003@gmail.com<br> +91-9410025602 </font> </html>");
        l7.setBounds(1050,520,500,200);
        l7.setFont(new Font("Aerial", Font.PLAIN, 25));
        f.add(l7);

        f.setVisible(true);
    }
    public static void main(String[] args){
        About obj= new About();
    }
}
