package SwingUI;

import neu.edu.csye6200.ClassRoom;
import neu.edu.csye6200.DayCare;
import neu.edu.csye6200.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Classrooms {

    private JPanel classesPanel;
    private JTable table1;
    private JTextArea SchoolInfo;
    private JComboBox comboBox1;
    private JButton classroomDetailsButton;
    private JButton backButton;
    private JTextField textField1;
    private JButton createReportFileButton;


    private static JFrame frame = new JFrame("Classrooms Page");
    private static Classrooms classes;

    public static JFrame getFrame(){
        return frame;
    }

    public static Classrooms getForm(){
        classes = new Classrooms();
        return classes;
    }

    public Classrooms() {
        DayCare dayCare = DayCare.getDayCare();
        String schoolInfo = dayCare.findSchoolInfo();
        SchoolInfo.append(schoolInfo);

        Vector<Vector<String>> allClassRoomsInfo = dayCare.findAllClassRoomsInfo();
        String[] identifier = new String[]{"Classroom ID", "Classroom Capacity", "Classroom Status", "Age Range"};
        table1.setModel(new DefaultTableModel(allClassRoomsInfo, new Vector(Arrays.asList(identifier))));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = Classrooms.getFrame();
                MainForm mainForm = MainForm.getForm();
                frame.dispose();
                mainForm.init();
            }
        });

        for (Vector<String> row : allClassRoomsInfo){
            comboBox1.addItem(row.get(0));
        }

        classroomDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.valueOf((String) comboBox1.getModel().getSelectedItem());
                dayCare.setCurrentClassRoom(value);
                JFrame frame = Classrooms.getFrame();
                Groups groups = Groups.getForm();
                frame.dispose();
                groups.init();
            }
        });
        createReportFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fileName = textField1.getText().trim() + ".txt";
                    FileUtils.write(fileName, dayCare.getSchool());
                }catch (Exception ec){
                    Object[] options = { "Ok" };
                    JOptionPane.showOptionDialog(null, "Some errors happen, you may check the director", "Export report failed.",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                }
            }
        });
    }

    public void init() {
        JFrame frame = Classrooms.getFrame();
        frame.setContentPane(Classrooms.getForm().classesPanel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800) / 2,(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 600) / 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DayCare dayCare = DayCare.getInstance();
        dayCare.enrollAllStudents();
        Classrooms.getForm().init();
    }
}
