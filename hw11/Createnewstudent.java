package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Createnewstudent extends JFrame {

    
    /**elements*/
    private JTextField textField;
    /**elements*/
    private JTextField textField1;
    /**elements*/
    private JTextField textField2;
    /**elements*/
    private JTextField textField3;
    /**elements*/
    private static JTextField textField4;

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Createnewstudent frame = new Createnewstudent();
                    frame.setVisible(true);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Createnewstudent() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel("Input Student Information");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 24));
        lblSearchByStudent.setBounds(51, -12, 331, 60);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(12, 36, 93, 31);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(149, 38, 130, 31);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Create");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {

            public boolean isInteger(String s) {
                try {
                    Integer.parseInt(s);
                } 
                catch (NumberFormatException e) {
                    return false;
                }
                // only got here if we didn't return false
                return true;
            }

            public void actionPerformed(ActionEvent e) {

                if (isInteger(textField4.getText())) {
                    Student student = new Student();
                    student.setUsername(textField.getText().toString());
                    student.setFirstName(textField1.getText().toString());
                    student.setLastName(textField2.getText().toString());
                    student.setAdvisor(textField3.getText().toString());
                    student.setGraduationYear(Integer.parseInt(textField4
                            .getText()));
                    CreatgradeBook.mgb.addStudent(student);
                    new Newgrade().setVisible(true);

                } 
                else {
                    new ErrorInformationStudents().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(316, 119, 154, 76);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel1 = new JLabel("firstName");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel1.setBounds(12, 97, 93, 31);
        contentPane.add(lblNewLabel1);

        textField1 = new JTextField();
        textField1.setBounds(149, 82, 132, 31);
        contentPane.add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("lastName");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel2.setBounds(12, 130, 93, 55);
        contentPane.add(lblNewLabel2);

        textField2 = new JTextField();
        textField2.setBounds(149, 129, 132, 26);
        contentPane.add(textField2);
        textField2.setColumns(10);

        JLabel lblAdvisor = new JLabel("advisor");
        lblAdvisor.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblAdvisor.setBounds(12, 198, 77, 15);
        contentPane.add(lblAdvisor);

        textField3 = new JTextField();
        textField3.setBounds(154, 192, 127, 31);
        contentPane.add(textField3);
        textField3.setColumns(10);

        JLabel lblGraduationYear = new JLabel("Graduation year");
        lblGraduationYear.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblGraduationYear.setBounds(12, 256, 139, 21);
        contentPane.add(lblGraduationYear);

        textField4 = new JTextField();
        textField4.setBounds(154, 253, 127, 31);
        contentPane.add(textField4);
        textField4.setColumns(10);
    }
}
