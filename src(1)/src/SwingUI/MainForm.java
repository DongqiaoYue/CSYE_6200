package SwingUI;

import neu.edu.csye6200.DayCare;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class MainForm {
    private JPanel MainPannel;
    private JLabel MainLabel;
    private JButton studentLogin;
    private JButton teacherLogin;
    private JButton studentRegistrationButton;
    private JComboBox CurrentYear;
    private JComboBox CurrentMonth;
    private JButton teacherRegistrationButton;

    private static JFrame frame = new JFrame("Main Page");
    private static MainForm mainForm;

    public static JFrame getFrame(){
        return frame;
    }

    public static MainForm getForm(){
        mainForm = new MainForm();
        return mainForm;
    }

    public String getCurrentDate(){
        String year = (String) CurrentYear.getModel().getSelectedItem();
        String month = (String) CurrentMonth.getModel().getSelectedItem();
        System.out.println(month + "-" + year);
        return month + "-" + year;
    }

    public MainForm() {



        CurrentMonth.addItem(String.valueOf(1));
        CurrentMonth.addItem(String.valueOf(2));
        CurrentMonth.addItem(String.valueOf(3));
        CurrentMonth.addItem(String.valueOf(4));
        CurrentMonth.addItem(String.valueOf(5));
        CurrentMonth.addItem(String.valueOf(6));
        CurrentMonth.addItem(String.valueOf(7));
        CurrentMonth.addItem(String.valueOf(8));
        CurrentMonth.addItem(String.valueOf(9));
        CurrentMonth.addItem(String.valueOf(10));
        CurrentMonth.addItem(String.valueOf(11));
        CurrentMonth.addItem(String.valueOf(12));

        CurrentYear.addItem(String.valueOf(2021));
        CurrentYear.addItem(String.valueOf(2022));
        CurrentYear.addItem(String.valueOf(2023));
        CurrentYear.addItem(String.valueOf(2024));

        DayCare dayCare = DayCare.getDayCare();
        dayCare.createUser();
        studentLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Hello World!");
                dayCare.setUserType("student");
                dayCare.setCurrentDate(getCurrentDate());
                JFrame frame = MainForm.getFrame();
                StudentLogin loginForm = StudentLogin.getForm();
                frame.dispose();
                loginForm.init();
            }
        });
        teacherLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dayCare.setUserType("teacher");
                dayCare.setCurrentDate(getCurrentDate());
                JFrame frame = MainForm.getFrame();
                TeacherLogin loginForm = TeacherLogin.getForm();
                frame.dispose();
                loginForm.init();
            }
        });
        studentRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dayCare.setUserType("student");
                dayCare.setCurrentDate(getCurrentDate());
                JFrame frame = MainForm.getFrame();
                StudentRegister studentRegister = StudentRegister.getForm();
                frame.dispose();
                studentRegister.init();
            }
        });

        teacherRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dayCare.setUserType("teacher");
                dayCare.setCurrentDate(getCurrentDate());
                JFrame frame = MainForm.getFrame();
                TeacherRegistrater teacherRegistrater = TeacherRegistrater.getForm();
                frame.dispose();
                teacherRegistrater.init();

            }
        });
    }

    public void init() {
        Font font = new Font("Dialog",Font.BOLD,14);
        this.initGlobalFontSetting(font);
        JFrame frame = MainForm.getFrame();
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);        frame.setContentPane(MainForm.getForm().MainPannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void initGlobalFontSetting(Font fnt) {
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }


    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        MainForm.getForm().init();
    }
}
