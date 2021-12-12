package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegister {
    private JTextField userName;
    private JPasswordField passwords;
    private JButton backButton;
    private JButton submit;
    private JPanel registerPanel;

    private static JFrame frame = new JFrame("Student Register Page");
    private static StudentRegister registerForm = new StudentRegister();

    public static JFrame getFrame() {
        return frame;
    }

    public static StudentRegister getForm() {
        return registerForm;
    }

    public StudentRegister() {
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
            }
        });
    }

    public void init() {
        JFrame frame = StudentRegister.getFrame();
        frame.setContentPane(StudentRegister.getForm().registerPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
