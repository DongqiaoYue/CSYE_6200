package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm {
    private JPanel studentForm;
    private JTextArea teacher;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JTextArea textArea9;
    private JTextArea textArea10;
    private JTextArea textArea11;
    private JTextArea textArea12;
    private JButton backButton;

    private static JFrame frame = new JFrame("Student Information");
    private static StudentForm studentInfo = new StudentForm();

    public static JFrame getFrame(){
        return frame;
    }

    public static StudentForm getForm(){
        return studentInfo;
    }

    public StudentForm() {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = StudentForm.getFrame();
                StudentLogin loginForm = StudentLogin.getForm();
                frame.dispose();
                loginForm.init();
            }
        });
    }

    public void init() {
        JFrame frame = StudentForm.getFrame();
        frame.setContentPane(StudentForm.getForm().studentForm);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
