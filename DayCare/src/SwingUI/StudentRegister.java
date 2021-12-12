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
    private JTextField age;
    private JTextField family;
    private JTextField address;
    private JTextField phone;
    private JTextField classroom;
    private JTextField group;
    private JTextField hib;
    private JTextField dtap;
    private JTextField polio;
    private JTextField hepatitis;
    private JTextField mmr;
    private JTextField varicella;

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
                String Age = age.getText().trim();
                String Family = family.getText().trim();
                String Address = address.getText().trim();
                String Phone = phone.getText().trim();
                String classRoom = classroom.getText().trim();
                String Group = group.getText().trim();
                String Hib = hib.getText().trim();
                String Dtap = dtap.getText().trim();
                String Polio = polio.getText().trim();
                String Hepatitis = hepatitis.getText().trim();
                String Mmr = mmr.getText().trim();
                String Varicella = varicella.getText().trim();

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
