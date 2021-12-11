package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private JPanel MainPannel;
    private JLabel MainLabel;
    private JButton studentLogin;
    private JButton teacherLogin;

    private static JFrame frame = new JFrame("Main Page");
    private static MainForm mainForm = new MainForm();

    public static JFrame getFrame(){
        return frame;
    }

    public static MainForm getForm(){
        return mainForm;
    }

    public MainForm() {
        studentLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Hello World!");
                JFrame frame = MainForm.getFrame();
                LoginForm loginForm = LoginForm.getForm();
                frame.dispose();
                loginForm.init();
            }
        });
        teacherLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void init() {
        JFrame frame = MainForm.getFrame();
        frame.setContentPane(MainForm.getForm().MainPannel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainForm.getForm().init();
    }
}
