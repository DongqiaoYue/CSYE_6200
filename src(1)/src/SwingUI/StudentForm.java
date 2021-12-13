package SwingUI;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.UserTypeEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentForm {
    private JPanel studentForm;
    private JTextArea teacher;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JTextArea textArea9;
    private JTextArea textArea10;
    private JTextArea textArea11;
    private JTextArea textArea12;
    private JButton backButton;
    private JButton vaccinationDetalsButton;

    private static JFrame frame = new JFrame("Student Information");
    private static StudentForm studentInfo;

    public static JFrame getFrame(){
        return frame;
    }

    public static StudentForm getForm(){
        studentInfo = new StudentForm();
        return studentInfo;
    }

    public StudentForm() {
        DayCare dayCare = DayCare.getDayCare();
        int currentStudent = dayCare.getCurrentStudent();
        List<String> vaccStatus = dayCare.findVaccStatusByID(currentStudent);
        List<String> studentInfo = dayCare.findStudentInfoById(currentStudent);

        teacher.append(studentInfo.get(0));
        textArea1.append(studentInfo.get(1));
        textArea2.append(studentInfo.get(2));
        textArea3.append(studentInfo.get(3));
        textArea4.append(studentInfo.get(4));
        textArea5.append(studentInfo.get(5));
        textArea6.append(studentInfo.get(6));
        textArea7.append(studentInfo.get(7));
        textArea8.append(studentInfo.get(8));
        textArea9.append(studentInfo.get(9));
        textArea10.append(studentInfo.get(10));
        textArea11.append(studentInfo.get(11));
        textArea12.append(studentInfo.get(12));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dayCare.getUserType() == UserTypeEnum.TEACHER){
                    JFrame frame = StudentForm.getFrame();
                    StudentList studentList = StudentList.getForm();
                    frame.dispose();
                    studentList.init();
                }else {
                    JFrame frame = StudentForm.getFrame();
                    MainForm mainForm = MainForm.getForm();
                    frame.dispose();
                    mainForm.init();
                }
            }
        });

        vaccinationDetalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = StudentForm.getFrame();
                StudentVaccDetail studentVaccDetail = StudentVaccDetail.getForm();
                frame.dispose();
                studentVaccDetail.init();
            }
        });
        boolean needCheck = false;
        for (String str: vaccStatus){
            if (str.equals("Overdue") && dayCare.getUserType() == UserTypeEnum.STUDENT){
               needCheck = true;
            }
        }
        if (needCheck){
            Object[] options = { "OK" };
            JOptionPane.showOptionDialog(null, "You have overdue vaccination, please check and update", "Warning.",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        }
    }

    public void init() {
        JFrame frame = StudentForm.getFrame();
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setContentPane(StudentForm.getForm().studentForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        dayCare.createUser();
        dayCare.setUserType("student");
        dayCare.LogIn("Jimmy", "0000");
        int currentStudent = dayCare.getCurrentStudent();
        //System.out.println(dayCare.findStudentNameById(currentStudent));
        StudentForm.getForm().init();
    }


}
