package SwingUI;

import neu.edu.csye6200.DayCare;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentVaccDetail {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JButton backButton;
    private JTextArea textArea9;
    private JTextArea textArea10;
    private JTextArea textArea11;
    private JTextArea textArea12;
    private JTextArea textArea13;
    private JTextArea textArea14;
    private JTextArea textArea15;
    private JTextArea textArea16;
    private JTextArea textArea17;
    private JTextArea textArea18;
    private JTextArea textArea19;
    private JTextArea textArea20;
    private JTextArea textArea21;
    private JTextArea textArea22;
    private JTextArea textArea23;
    private JTextArea textArea24;
    private JTextArea textArea25;
    private JPanel StudentP2;
    private JPanel Student;
    private JTextPane textPane1;
    private JTextPane textPane2;
    private JTextPane textPane3;
    private JTextPane textPane4;
    private JTextPane textPane5;
    private JTextPane textPane6;

    private static JFrame frame = new JFrame("Student Vaccination Detail");
    private static StudentVaccDetail studentVaccDetail;

    public static JFrame getFrame(){
        return frame;
    }

    public static StudentVaccDetail getForm(){
        studentVaccDetail = new StudentVaccDetail();
        return studentVaccDetail;
    }

    public Color getColor(String str){
        if (str.equals("Compliance")){
            return Color.GREEN;
        }else if (str.equals("Not compliance")){
            return Color.ORANGE;
        }else if (str.equals("Overdue")){
            return Color.RED;
        }
        return Color.BLACK;
    }

    public StudentVaccDetail(){
        DayCare dayCare = DayCare.getDayCare();
        int currentStudent = dayCare.getCurrentStudent();
        List<String> currentDose = dayCare.findVaccRecordInfoByID(currentStudent);
        List<Integer> requiredDose = dayCare.findRequiredDoseByID(currentStudent);
        List<String> updateDate = dayCare.findVaccUpdateDateInfoByID(currentStudent);
        List<String> vaccStatus = dayCare.findVaccStatusByID(currentStudent);

        textArea13.append("Student Age:"+ dayCare.findStudentAgeByID(currentStudent));

        textArea1.append(currentDose.get(0));
        textArea3.append(currentDose.get(1));
        textArea5.append(currentDose.get(2));
        textArea7.append(currentDose.get(3));
        textArea9.append(currentDose.get(4));
        textArea11.append(currentDose.get(5));

        textArea2.append((requiredDose.get(0) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(0)));
        textArea4.append((requiredDose.get(1) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(1)));
        textArea6.append((requiredDose.get(2) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(2)));
        textArea8.append((requiredDose.get(3) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(3)));
        textArea10.append((requiredDose.get(4) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(4)));
        textArea12.append((requiredDose.get(5) == -1) ? "Not applicable" : String.valueOf(requiredDose.get(5)));

        textArea14.append(updateDate.get(0));
        textArea16.append(updateDate.get(1));
        textArea18.append(updateDate.get(2));
        textArea20.append(updateDate.get(3));
        textArea22.append(updateDate.get(4));
        textArea24.append(updateDate.get(5));


        textPane1.setText(vaccStatus.get(0));
        textPane1.setForeground(getColor(vaccStatus.get(0)));

        textPane2.setText(vaccStatus.get(1));
        textPane2.setForeground(getColor(vaccStatus.get(1)));

        textPane3.setText(vaccStatus.get(2));
        textPane3.setForeground(getColor(vaccStatus.get(2)));

        //vaccStatus.set(3, "Not compliance");

        textPane4.setText(vaccStatus.get(3));
        textPane4.setForeground(getColor(vaccStatus.get(3)));

        textPane5.setText(vaccStatus.get(4));
        textPane5.setForeground(getColor(vaccStatus.get(4)));

        //vaccStatus.set(5, "Overdue");

        textPane6.setText(vaccStatus.get(5));
        textPane6.setForeground(getColor(vaccStatus.get(5)));



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = StudentVaccDetail.getFrame();
                StudentForm studentForm = StudentForm.getForm();
                frame.dispose();
                studentForm.init();
            }
        });
    }

    public void init() {
        JFrame frame = StudentVaccDetail.getFrame();
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()) / 2);
        frame.setContentPane(StudentVaccDetail.getForm().Student);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        StudentVaccDetail.getForm().init();
    }

}


