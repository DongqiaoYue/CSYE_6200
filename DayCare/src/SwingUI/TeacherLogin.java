package SwingUI;

import javax.swing.*;
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
                if (!username.isEmpty() && !password.isEmpty()) {
                    JFrame frame = TeacherLogin.getFrame();
                    frame.dispose();
                    TeacherForm teacherForm = TeacherForm.getForm();
                    teacherForm.init();
                } else {
                    Object[] options = { "OK" };
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "Password check failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }
            }
        });
    }

    public void init() {
        JFrame frame = TeacherLogin.getFrame();
        frame.setContentPane(TeacherLogin.getForm().loginPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
