package SwingUI;

import javax.swing.*;
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
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get login info
                String username = userName.getText().trim();
                String password = String.valueOf(passWord.getPassword());
                if (!username.isEmpty() && !password.isEmpty()) {
                    JFrame frame = StudentLogin.getFrame();
                    frame.dispose();
                    StudentForm studentForm = StudentForm.getForm();
                    studentForm.init();
                } else {
                    Object[] options = { "OK" };
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Password check failed.",
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
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
