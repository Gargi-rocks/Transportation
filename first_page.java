package learner;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class frame_1 implements ActionListener {
    JLabel l, l1,l2;
    JButton l3, l4;

    frame_1() {
        JFrame f = new JFrame();
        f.setLayout(null);
        f.setSize(690, 700);
        f.getContentPane().setBackground(Color.BLACK);
        f.setIconImage(new ImageIcon("C:\\Users\\hp\\Downloads\\hong-kong-4046913_1280.jpg", "FrameLogo").getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_DEFAULT));

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int width = f.getWidth();
        int height = f.getHeight();
        int north = (screenWidth - width) / 2;
        int east = (screenHeight - height) / 2;
        f.setLocation(north, east);

        f.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Pictures\\TMS_Photoes\\pexels-quintin-gellar-2199293.jpg").getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_DEFAULT)));
        background.setBounds(05, 05, 680, 680);
        f.add(background);
        background.setLayout(null);

        l = new JLabel("REACH YOUR DESTINATION.. ");
        l.setFont(new Font("Arial", Font.PLAIN, 20));
        l.setBounds(100, 50, 300, 30);
        background.add(l);

        l3 = new JButton("SIGN UP");
        l3.setBounds(500, 100, 100, 30);
        l3.addActionListener(this);
        background.add(l3);

        l4 = new JButton("LOGIN");
        l4.setBounds(500, 170, 100, 30);
        l4.addActionListener(this);
        background.add(l4);

        f.setVisible(true);
        f.setLocation(north, east);
    }

    public void actionPerformed(ActionEvent oEvent) {
        if (oEvent.getSource() == l4) { // check if Action is triggered by JButton
            login obj = new login();
        }
        if (oEvent.getSource() == l3) { // check if Action is triggered by JButton
            frame_2 obj = new frame_2 ();
        }
    }
}
    public class first_page {
        public static void main(String[] args) {
            frame_1 obj = new frame_1();
        }
    }
