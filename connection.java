package learner;

import javax.swing.*;
import java.awt.*;

public class connection {
    void connects() {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        JFrame f = new JFrame();
        f.setSize(screenWidth,screenHeight);
        f.getContentPane().setLayout(new FlowLayout());
        JLabel textArea = new JLabel();
        textArea.setText("<html>\n" +
                "<head>\n" +
                "    <title>\n" +
                "        EVENTS\n" +
                "    </title>\n" +
                "    <style>\n" +
                "            body{\n" +
                "                background-color: cadetblue;\n" +
                "                margin: 25px;\n" +
                "                text-align: justify;\n" +
                "            }\n" +
                "            .meet1{\n" +
                "               font-family: Brush Script MT;\n" +
                "               font-size: 30px;\n" +
                "            }\n" +
                "            .tre\n" +
                "            {\n" +
                "                font-family: Colon MT;\n" +
                "                font-size: 40px;\n" +
                "                text-align: center;\n" +
                "            }\n" +
                "            .wed{\n" +
                "                display: table;\n" +
                "                padding: 2px;\n" +
                "                font-size: 5em;\n" +
                "                margin: 0;\n" +
                "            }\n" +
                "            .inner{\n" +
                "                float: left;\n" +
                "                width: 30%;\n" +
                "                font-family:cursive;\n" +
                "                text-align: justify;\n" +
                "\t        color: #d1d639;\n" +
                "\t        font-size: 0.6em;\n" +
                "\t         padding: 0px 20 10px 20;\n" +
                "\t         line-height: 1.6em;\n" +
                "            }\n" +
                "\n" +
                "            .inner2{\n" +
                "                float: right;\n" +
                "                width: 30%;\n" +
                "                font-family:cursive;\n" +
                "\t        color: #DE1D1D ;\n" +
                "\t        font-size: 0.6em;\n" +
                "\t         padding: 0px   0 10px 20;\n" +
                "\t         line-height: 1.8em;\n" +
                "            }\n" +
                "            .inner3{\n" +
                "                float:center;\n" +
                "                width: 20%;\n" +
                "                font-family: cursive;\n" +
                "\t        color: #693fb3;\n" +
                "\t        font-size: 0.6em;\n" +
                "\t         padding: 0px 0 10px 0;\n" +
                "\t         line-height: 1.4em;\n" +
                "            }\n" +
                "            .img1{\n" +
                "                width: 50%;\n" +
                "                height: 100%;\n" +
                "            }\n" +
                "            img{\n" +
                "                width:200;\n" +
                "                height:200;\n" +
                "            }\n" +
                "        </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1 align=\"center\" class=\"tre\">Meetings & Event Spaces at Taj Palace, New Delhi</h1>\n" +
                "<p class =\"meet1\"> Our hotel offers 07 individual breakout rooms as well as large pillar-less ballroom that opens</p><p class =\"meet1\"> into the lush green lawns and can accommodate more than 750 people.</p><p class =\"meet1\"> This versatility allows us to accommodate a range of business meetings or gatherings.</p></body></html>"+
        "<a href=\"#\"><img src=\"C:\\Users\\hp\\IdeaProjects\\learner\\Image\\wedding.webp\" alt =\"Hello\" title=\"\"></a>");
        textArea.setBounds(10, 10, screenWidth,screenHeight);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);

        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        f.getContentPane().add(scrollableTextArea);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main ( String [] args){

       connection obj= new connection();
       obj.connects();
    }

}
