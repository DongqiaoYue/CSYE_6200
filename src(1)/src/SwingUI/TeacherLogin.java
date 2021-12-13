package SwingUI;

import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherLogin {
    private JTextField userName;
    private JPasswordField passWord;
    private JButton login;
    private JButton back;
    private JPanel loginPanel;

    private static JFrame frame = new JFrame("Teacher Login Page");
    private static TeacherLogin loginForm = new TeacherLogin();

    public static JFrame getFrame() {
        return frame;
    }

    public static TeacherLogin getForm() {
        return loginForm;
    }

    public TeacherLogin() {
        DayCare dayCare = DayCare.getDayCare();
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back to main page
                JFrame frame = TeacherLogin.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get login info
                String username = userName.getText().trim();
                String password = String.valueOf(passWord.getPassword());
                if (dayCare.LogIn(username, password)) {
                    dayCare.enrollAllStudents();
                    JFrame frame = TeacherLogin.getFrame();
                    frame.dispose();
                    StudentList studentListForm = StudentList.getForm();
                    studentListForm.init();
                } else {
                    Object[] options = { "Try Again" };
                    JOptionPane.showOptionDialog(null, "Username or Password wrong", "Login check failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }
            }
        });
    }

    public void init() {
        JFrame frame = TeacherLogin.getFrame();
        frame.setContentPane(TeacherLogin.getForm().loginPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
