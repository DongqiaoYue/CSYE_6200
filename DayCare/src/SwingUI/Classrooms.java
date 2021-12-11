package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Classrooms {

    private JPanel classesPanel;
    private JButton selected;
    private JTable classroom;

    private static JFrame frame = new JFrame("Classrooms Page");
    private static Classrooms classes = new Classrooms();

    public static JFrame getFrame(){
        return frame;
    }

    public static Classrooms getForm(){
        return classes;
    }

    public Classrooms() {
        DefaultTableModel tableModel=(DefaultTableModel) classroom.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"Room ID","Group Count","Group Capacity","Groups","Low Age","High Age"});
        classroom.setRowHeight(30);
        classroom.setModel(tableModel);

        selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) classroom.getModel();    //获得表格模型
                int selectedRow = classroom.getSelectedRow();
                int selectedColumn = classroom.getSelectedColumn();
                int group = (int)classroom.getValueAt(selectedRow, selectedColumn);
            }
        });
    }

    public void init() {
        JFrame frame = Classrooms.getFrame();
        frame.setContentPane(Classrooms.getForm().classesPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
