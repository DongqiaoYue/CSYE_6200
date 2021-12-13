package SwingUI;

import neu.edu.csye6200.DayCare;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class StudentList {
    private JPanel stuPanel;
    private JTable AllStudents;
    private JComboBox StudentSelection;
    private JButton studentDetailsButton;
    private JTextArea TeacherInfoTextArea;
    private JTextArea GroupInfoTextArea;
    private JButton backButton;
    private JButton viewAllStudentsButton;


    private static JFrame frame = new JFrame("Students Page");
    private static StudentList stuLst;

    public static JFrame getFrame(){
        return frame;
    }

    public static StudentList getForm() {
        stuLst = new StudentList();
        return stuLst;
    }

    public StudentList() {
        DayCare dayCare = DayCare.getDayCare();

        int currentTeacher = DayCare.getCurrentTeacher();
        List<String> teacherInfo = dayCare.findTeacherInfoById(currentTeacher);
        TeacherInfoTextArea.append("Hello " + teacherInfo.get(1) + "("  +teacherInfo.get(2)+ ")" + "your ID is: " + teacherInfo.get(0));
        String groupInfo = dayCare.findGroupInfoById(currentTeacher);
        GroupInfoTextArea.append(groupInfo);

        String[] identifier = new String[]{"ID", "Name", "Age"};

        Vector<Vector<String>> allsttudentsInfo =  dayCare.findAllStudentsInfoByID(currentTeacher);
        AllStudents.setModel(new DefaultTableModel(allsttudentsInfo, new Vector(Arrays.asList(identifier))));

        for (Vector<String> row : allsttudentsInfo){
            StudentSelection.addItem(row.get(0));
        }

        studentDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = (String) StudentSelection.getSelectedItem();
                dayCare.setCurrentStudent(Integer.valueOf(value));
                JFrame frame = StudentList.getFrame();
                StudentForm studentForm = StudentForm.getForm();
                frame.dispose();
                studentForm.init();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = StudentList.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });

        viewAllStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = StudentList.getFrame();
                Classrooms classrooms = Classrooms.getForm();
                frame.dispose();
                classrooms.init();
            }
        });



    }

    public void init() {
        JFrame frame = StudentList.getFrame();
        frame.setContentPane(StudentList.getForm().stuPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        StudentList.getForm().init();
    }


}
