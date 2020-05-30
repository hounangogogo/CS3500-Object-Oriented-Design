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
public class Searchbyusernameandass extends JFrame {

    /**elements*/
    private JTextField textField;
    /**elements*/
    private JTextField textField1;

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Searchbyusernameandass frame = 
                            new Searchbyusernameandass();
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
     * @param assignment String
     * @param username String
     * @return boolean
     */
    public boolean correctInformation(String assignment, String username) {
        try {

            CreatgradeBook.mgb.assignmentGrade(assignment, username);
        } 
        catch (NoSuchElementException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Create the frame.
     */
    public Searchbyusernameandass() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel("Grade For Single Assignment");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 25));
        lblSearchByStudent.setBounds(46, 10, 331, 47);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("Student username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(28, 70, 151, 44);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(191, 70, 166, 44);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (correctInformation(textField1.getText(),
                        textField.getText())) {
                    SingleAss.lblNewLabel.setText(String.valueOf(
                            CreatgradeBook.mgb
                            .assignmentGrade(textField1.getText(),
                                    textField.getText())));
                    SingleAss.lblXxxxxx.setText(String
                            .valueOf(CreatgradeBook.mgb.currentGrade(textField
                                    .getText())));
                    new SingleAss().setVisible(true);
                } 
                else {
                    new NoSuchAssignmentandStudent().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(152, 242, 182, 54);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel1 = new JLabel("Assignment Name");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel1.setBounds(28, 159, 151, 38);
        contentPane.add(lblNewLabel1);

        textField1 = new JTextField();
        textField1.setBounds(191, 158, 166, 40);
        contentPane.add(textField1);
        textField1.setColumns(10);
    }

}
