package SwingUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentList {
    private JPanel stuPanel;
    private JTable students;
    private JButton selected;
    private JLabel stuLabel;

    private static JFrame frame = new JFrame("Students Page");
    private static StudentList stuLst = new StudentList();

    public static JFrame getFrame(){
        return frame;
    }

    public static StudentList getForm(){
        return stuLst;
    }

    public StudentList() {
        DefaultTableModel tableModel = (DefaultTableModel) students.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"Room ID","Group Count","Group Capacity","Groups","Low Age","High Age"});
        students.setRowHeight(30);
        students.setModel(tableModel);

        selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) students.getModel();    //获得表格模型
                int selectedRow = students.getSelectedRow();
                int selectedColumn = students.getSelectedColumn();
//                int group = (int)students.getValueAt(selectedRow, selectedColumn);

                JFrame frame = StudentList.getFrame();
                StudentForm stuFrm = StudentForm.getForm();
                frame.dispose();
                stuFrm.init();
            }
        });
    }

    public void init() {
        JFrame frame = StudentList.getFrame();
        frame.setContentPane(StudentList.getForm().stuPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
