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
import java.util.NoSuchElementException;


/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Creatnewgrade extends JFrame {

    
    /**elements*/
    private JTextField textField;
    /**elements*/
    private JTextField textField1;
    /**elements*/
    private JTextField textField2;

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Creatnewgrade frame = new Creatnewgrade();
                    frame.setVisible(true);
                } 
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 
     * @param username
     *            String
     * @param assignment
     *            String
     * @param score
     *            double
     * @return boolean
     */
    public boolean correctInformation(String username, String assignment,
            double score) {
        try {

            CreatgradeBook.mgb.addGrade(username, assignment, score);
        } 
        catch (NoSuchElementException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * 
     * @param s
     *            String
     * @return boolean
     */
    public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } 
        catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Create the frame.
     */
    public Creatnewgrade() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel("Input Grade Information");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 24));
        lblSearchByStudent.setBounds(56, 10, 331, 60);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("Student username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(40, 80, 151, 31);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(251, 83, 177, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Create");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isDouble(textField2.getText())
                        && correctInformation(textField.getText(),
                                textField1.getText(),
                                Double.parseDouble(textField2.getText()))) {
                    String username = textField.getText();
                    String assignment = textField1.getText();
                    double score = Double.parseDouble(textField2.getText());
                    CreatgradeBook.mgb.addGrade(assignment, username, score);
                    new Newgrade().setVisible(true);
                } 
                else {
                    new ErrorInformationGrades().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(143, 267, 205, 50);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel1 = new JLabel("Assignment Name");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel1.setBounds(40, 114, 167, 53);
        contentPane.add(lblNewLabel1);

        textField1 = new JTextField();
        textField1.setBounds(249, 127, 179, 31);
        contentPane.add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("New Grade");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel2.setBounds(40, 180, 137, 31);
        contentPane.add(lblNewLabel2);

        textField2 = new JTextField();
        textField2.setBounds(249, 176, 179, 31);
        contentPane.add(textField2);
        textField2.setColumns(10);
    }

}
