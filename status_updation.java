package learner;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class status_updation {
    public static void main(String[] args) {
        final status_updation example = new status_updation();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                example.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Update the status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(new JTableModel());
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Delivered").setCellRenderer(buttonRenderer);
        table.addMouseListener(new JTableButtonMouseListener(table));

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(500, 200));
        frame.pack();
        frame.setVisible(true);
    }

    public static class JTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private static final String[] COLUMN_NAMES = new String[] {"Employee Name","Employee id","contact no.","Licence Number", "CR NO.", "Pickup address","Destination","Delivered"};
        private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, String.class, String.class, String.class, String.class, String.class, JButton.class};
        String emp = "";
        String cont = null;
        String lisc = "";
        String cr = "";
        String from = "";
        String to = "";
        String empna = "";
        ResultSet rs=null;
         public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

         public int getRowCount() {
            PreparedStatement ps = null;
            bridge newt;
            ResultSet rs = null;
            newt = new bridge();
            newt.connected();
            int i=0;
            try {
                String sql = "SELECT employee_id, employee_name, license_no,contact_no,cr_no,from_add,to_addr FROM allotment";
                ps = newt.con6.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    empna = rs.getString("employee_name");
                    emp = rs.getString("employee_id");
                    cont = rs.getString("contact_no");
                    lisc = rs.getString("license_no");
                    cr = rs.getString("cr_no");
                    from = rs.getString("from_add");
                    to = rs.getString("to_addr");
                    i++;
                }
                if (i < 1) {
                    JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (i == 1) {
                    System.out.println(i + " Record Found");
                } else {
                    System.out.println(i + " Records Found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            return i;
        }

        @Override public String getColumnName(int columnIndex) {
            return COLUMN_NAMES[columnIndex];
        }

        @Override public Class<?> getColumnClass(int columnIndex) {
            return COLUMN_TYPES[columnIndex];
        }

        @Override public Object getValueAt(final int rowIndex, final int columnIndex) {
            System.out.println("column"+columnIndex);
            System.out.println("Row"+rowIndex);
            switch (columnIndex) {
                case 0: return empna;
                case 1: return emp;
                case 2: return cont;
                case 3: return lisc;
                case 4: return cr;
                case 5: return from;
                case 6: return to;
                case 7: final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
                    button.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(button),
                                    "Button clicked for row "+rowIndex);
                        }
                    });
                    return button;
                default: return "Error";
            }
        }
    }

    private static class JTableButtonRenderer implements TableCellRenderer {
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton)value;
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            return button;
        }
    }

    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;
        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX());
            int row    = e.getY()/table.getRowHeight();

            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);
                if (value instanceof JButton) {
                    ((JButton)value).doClick();
                }
            }
        }
    }
}