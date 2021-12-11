package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JTextField userName;
    private JPasswordField passWord;
    private JButton login;
    private JButton back;
    private JPanel loginPanel;

    private static JFrame frame = new JFrame("Login Page");
    private static LoginForm loginForm = new LoginForm();

    public static JFrame getFrame() {
        return frame;
    }

    public static LoginForm getForm() {
        return loginForm;
    }

    public LoginForm() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get login info
                String username = userName.getText().trim();
                String password = String.valueOf(passWord.getPassword());
                if (username.isEmpty()) {
                    Object[] options = { "OK" };
                    JOptionPane.showOptionDialog(null, "Click OK to continue", "FBIWarning:Password check failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                } else {

                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back to main page
                JFrame frame = LoginForm.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });
    }

    public void init() {
        JFrame frame = LoginForm.getFrame();
        frame.setContentPane(LoginForm.getForm().loginPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
