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
public class ChangeGrade extends JFrame {

    /** elements */
    private JTextField textField;
    /** elements */
    private JTextField textField1;
    /** elements */
    private JTextField textField2;

    /**
     * 
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangeGrade frame = new ChangeGrade();
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
    public ChangeGrade() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel(
                "Update Grade For Single Assignment");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 20));
        lblSearchByStudent.setBounds(56, 10, 331, 60);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("Student username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(28, 83, 157, 57);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(197, 95, 190, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Update");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isDouble(textField2.getText())
                        && CreatgradeBook.mgb.changeGrade(textField1.getText(),
                                textField.getText(),
                                Double.parseDouble(textField2.getText()))) {
                    String username = textField.getText();
                    String assignment = textField1.getText();
                    double score = Double.parseDouble(textField2.getText());
                    CreatgradeBook.mgb.changeGrade(username, assignment, score);
                    new Updatedgrade().setVisible(true);

                } 
                else {
                    new NoSuchAssignmentandStudent().setVisible(true);
                }
            }

        });
        btnNewButton.setBounds(164, 255, 166, 60);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel1 = new JLabel("Assignment Name");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel1.setBounds(28, 129, 157, 60);
        contentPane.add(lblNewLabel1);

        textField1 = new JTextField();
        textField1.setBounds(197, 143, 190, 32);
        contentPane.add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("New Grade");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel2.setBounds(28, 184, 112, 47);
        contentPane.add(lblNewLabel2);

        textField2 = new JTextField();
        textField2.setBounds(197, 188, 190, 32);
        contentPane.add(textField2);
        textField2.setColumns(10);
    }

}
