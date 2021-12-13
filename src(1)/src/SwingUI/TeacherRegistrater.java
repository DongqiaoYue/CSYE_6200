package SwingUI;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.Teacher;
import sun.security.util.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TeacherRegistrater {
    private JTextField TeacherName;
    private JPasswordField TeacherPassword;
    private JButton submitButton;
    private JButton backButton;
    private JTextField TeacherAge;
    private JPanel TeacherPanel;

    private static JFrame frame = new JFrame("Student Register Page");
    private static TeacherRegistrater teacherRegistrater;

    public static JFrame getFrame() {
        return frame;
    }

    public static TeacherRegistrater getForm() {
        teacherRegistrater = new TeacherRegistrater();
        return teacherRegistrater;
    }

    public TeacherRegistrater(){
        DayCare dayCare = DayCare.getDayCare();



        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Name = TeacherName.getText().trim();
                String Age = TeacherAge.getText().trim();
                String Password = TeacherAge.getText().trim();

                if (Name.length() != 0 &&
                Age.length() != 0 &&
                Password.length() != 0){

                    int teacherID = dayCare.getTeacherCount() + 1;
                    String teacherCsv = teacherID + ","
                            + Name + ","
                            + Age + ","
                            + "600";
                    dayCare.insertTeacher(teacherCsv);
                    dayCare.LogIn(Name, "0000");

                    dayCare.enrollAllStudents();
                    Object[] options = { "Continue" };
                    JOptionPane.showOptionDialog(null, "Congratulation, you have registered successfully, you may be assigned with students when there are unassigned students next time you start the program", "Registration success.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                    JFrame frame = TeacherRegistrater.getFrame();
                    StudentList studentList = StudentList.getForm();
                    frame.dispose();
                    studentList.init();

                }else {
                    Object[] options = { "Try Again" };
                    JOptionPane.showOptionDialog(null, "Blanks are not allowed", "Registration failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = TeacherRegistrater.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });

    }

    public void init() {
        JFrame frame = TeacherRegistrater.getFrame();
        frame.setContentPane(TeacherRegistrater.getForm().TeacherPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        TeacherRegistrater.getForm().init();
    }
}


