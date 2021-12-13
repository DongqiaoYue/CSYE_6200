package SwingUI;

import neu.edu.csye6200.DayCare;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class Groups {
    private JPanel groupPanel;
    private JTable table1;
    private JButton groupDetailsButton;
    private JComboBox comboBox1;
    private JButton backButton;
    private JTextArea ClassRoomInfo;

    private static JFrame frame = new JFrame("Classrooms Page");
    private static Groups classes;

    public static JFrame getFrame(){
        return frame;
    }

    public static Groups getForm(){
        classes =new Groups();
        return classes;
    }

    public Groups() {

        DayCare dayCare = DayCare.getDayCare();
        int currentClassRoom = dayCare.getCurrentClassRoom();
        ClassRoomInfo.append(dayCare.findClassRoomInfoByID(currentClassRoom));
        Vector<Vector<String>> groups = dayCare.findGroupsInfoByClassRoomID(currentClassRoom);
        String[] identifier = new String[]{"Group ID", "Teacher", "Student Count", "Student Capacity"};
        table1.setModel(new DefaultTableModel(groups, new Vector(Arrays.asList(identifier))));
        for (Vector<String> row : groups){
            comboBox1.addItem(row.get(0));
        }
        groupDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.valueOf((String) comboBox1.getModel().getSelectedItem());
                int teacherID = dayCare.findTeacherIdByGroupId(value);
                dayCare.setCurrentTeacher(teacherID);
                JFrame frame = Groups.getFrame();
                StudentList studentList = StudentList.getForm();
                frame.dispose();
                studentList.init();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = Groups.getFrame();
                Classrooms classrooms = Classrooms.getForm();
                frame.dispose();
                classrooms.init();
            }
        });

    }

    public void init() {
        JFrame frame = Groups.getFrame();
        frame.setContentPane(Groups.getForm().groupPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        Groups.getForm().init();
    }
}
