package SwingUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherForm {
    private JPanel teacherForm;
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
    private JButton selected;

    private static JFrame frame = new JFrame("Teacher Information");
    private static TeacherForm teacherInfo = new TeacherForm();

    public static JFrame getFrame(){
        return frame;
    }

    public static TeacherForm getForm(){
        return teacherInfo;
    }

    public TeacherForm() {

        selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = TeacherForm.getFrame();
                Classrooms classrooms = Classrooms.getForm();
                frame.dispose();
                classrooms.init();
            }
        });
    }

    public void init() {
        JFrame frame = TeacherForm.getFrame();
        frame.setContentPane(TeacherForm.getForm().teacherForm);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
