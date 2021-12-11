package SwingUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Groups {
    private JTable groups;
    private JButton selected;
    private JPanel groupPanel;
    private JLabel groupLabel;

    private static JFrame frame = new JFrame("Classrooms Page");
    private static Groups classes = new Groups();

    public static JFrame getFrame(){
        return frame;
    }

    public static Groups getForm(){
        return classes;
    }

    public Groups() {
        DefaultTableModel tableModel=(DefaultTableModel) groups.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"Room ID","Group Count","Group Capacity","Groups","Low Age","High Age"});
        groups.setRowHeight(30);
        groups.setModel(tableModel);

        selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) groups.getModel();    //获得表格模型
                int selectedRow = groups.getSelectedRow();
                int selectedColumn = groups.getSelectedColumn();
                int group = (int)groups.getValueAt(selectedRow, selectedColumn);
            }
        });
    }

    public void init() {
        JFrame frame = Groups.getFrame();
        frame.setContentPane(Groups.getForm().groupPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
