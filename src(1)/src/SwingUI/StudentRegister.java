package SwingUI;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.Student;
import neu.edu.csye6200.UserTypeEnum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentRegister {
    private JTextField userName;
    private JPasswordField passwords;
    private JButton backButton;
    private JButton submit;
    private JPanel registerPanel;
    private JTextField age;
    private JTextField family;
    private JTextField address;
    private JTextField phone;
    private JTextField hib;
    private JTextField dtap;
    private JTextField polio;
    private JTextField hepatitis;
    private JTextField mmr;
    private JTextField varicella;

    private static JFrame frame = new JFrame("Student Register Page");
    private static StudentRegister registerForm;

    public static JFrame getFrame() {
        return frame;
    }

    public static StudentRegister getForm() {
        registerForm = new StudentRegister();
        return registerForm;
    }

    public StudentRegister() {

        DayCare dayCare = DayCare.getDayCare();

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back to main page
                JFrame frame = StudentRegister.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = userName.getText().trim();
                String password = String.valueOf(passwords.getPassword());
                String Age = age.getText().trim();
                String Family = family.getText().trim();
                String Address = address.getText().trim();
                String Phone = phone.getText().trim();
                String Hib = hib.getText().trim();
                String Dtap = dtap.getText().trim();
                String Polio = polio.getText().trim();
                String Hepatitis = hepatitis.getText().trim();
                String Mmr = mmr.getText().trim();
                String Varicella = varicella.getText().trim();
                if (username.length() != 0 &&
                        password.length() != 0 &&
                        Age.length() != 0 &&
                        Family.length() != 0 &&
                        Address.length() != 0 &&
                        Phone.length() != 0 &&
                        Hib.length() != 0 &&
                        Dtap.length() != 0 &&
                        Polio.length() != 0 &&
                        Hepatitis.length() != 0 &&
                        Mmr.length() != 0 &&
                        Varicella.length() != 0

                ) {
                    String currentData = dayCare.getCurrentDate();
                    int studentID = dayCare.getStudentCount() + 1;
                    String studentCsv = studentID + ","
                            + username + ","
                            + Age + ","
                            + "60,"
                            + Family + ","
                            + Phone + ","
                            + Address + ","
                            + currentData;
                    String vaccRecord = studentID + ","
                            + Hib + ","
                            + Dtap + ","
                            + Polio + ","
                            + Hepatitis + ","
                            + Mmr + ","
                            + Varicella;

                    for (int i = 0; i < 6; i++){
                        vaccRecord = vaccRecord + "," + currentData;
                    }
                    Student student = Student.parseStudent(studentCsv, currentData);
                    dayCare.addStudent(student);
                    dayCare.insertVaccRecord(vaccRecord);
                    dayCare.createUser();
                    dayCare.setUserType("student");
                    dayCare.LogIn(student.getName(), "0000");
                    JFrame frame = StudentRegister.getFrame();
                    StudentForm studentForm = StudentForm.getForm();
                    frame.dispose();
                    studentForm.init();
                    dayCare.enrollAllStudents();
                    Object[] options = { "Continue" };
                    JOptionPane.showOptionDialog(null, "Congratulation, you will be enrolled automatically next time you start the program", "Registration success.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }else {
                    Object[] options = { "Try Again" };
                    JOptionPane.showOptionDialog(null, "Blanks are not allowed", "Registration failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }

            }
        });
    }

    public void init() {
        JFrame frame = StudentRegister.getFrame();
        frame.setContentPane(StudentRegister.getForm().registerPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        StudentRegister.getForm().init();
    }
}
