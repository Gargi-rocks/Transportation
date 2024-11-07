package learner;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class EditClientFrm extends JFrame implements ActionListener{
    private SearchClientFrm parent;
    private Client client;
    private int index;
    private JTextField txtNote2;
    private JButton btnUpdate, btnReset;
    public EditClientFrm(SearchClientFrm parent, Client client, int index){
        super("Edit Detail");
        this.parent = parent;
        this.client = client;
        this.index = index;

        txtNote2 = new JTextField(25);
        btnUpdate = new JButton("Update");
        btnReset = new JButton("Reset");

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(1,2));
        content.add(new JLabel("CURRENT STATUS:"));     content.add(txtNote2);
        content.add(btnUpdate);     content.add(btnReset);
        btnUpdate.addActionListener(this);
        btnReset.addActionListener(this);

        initForm();

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initForm(){
        if(client != null){
            txtNote2.setText(client.getNote2());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnClicked = (JButton)e.getSource();
        if(btnClicked.equals(btnReset)){
            initForm();
            return;
        }
        if(btnClicked.equals(btnUpdate)){
            btnUpdateClick();
        }
    }

    private void btnUpdateClick(){
        client.setNote2(txtNote2.getText());
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.editClient(client);
        parent.refreshResultAfterUpdate(index, client);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}

