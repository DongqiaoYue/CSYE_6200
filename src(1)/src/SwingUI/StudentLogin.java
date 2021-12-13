package SwingUI;

import neu.edu.csye6200.DayCare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin {
    private JTextField userName;
    private JPasswordField passWord;
    private JButton login;
    private JButton back;
    private JPanel loginPanel;

    private static JFrame frame = new JFrame("Student Login Page");
    private static StudentLogin loginForm = new StudentLogin();

    public static JFrame getFrame() {
        return frame;
    }

    public static StudentLogin getForm() {
        return loginForm;
    }

    public StudentLogin() {
        DayCare dayCare = DayCare.getDayCare();
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get login info
                String username = userName.getText().trim();
                String password = String.valueOf(passWord.getPassword());
                if (dayCare.LogIn(username, password)) {
                    dayCare.enrollAllStudents();
                    JFrame frame = StudentLogin.getFrame();
                    frame.dispose();
                    StudentForm studentForm = StudentForm.getForm();
                    studentForm.init();
                } else {
                    Object[] options = { "Try Again" };
                    JOptionPane.showOptionDialog(null, "Username or Password wrong", "Login check failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back to main page
                JFrame frame = StudentLogin.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });
    }

    public void init() {
        JFrame frame = StudentLogin.getFrame();
        frame.setContentPane(StudentLogin.getForm().loginPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
