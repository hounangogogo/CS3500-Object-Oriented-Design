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
public class Searchbyassignment extends JFrame {


    /**elements*/
    private JTextField textField;

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Searchbyassignment frame = 
                            new Searchbyassignment();
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
     * @return boolean
     */
    public boolean correctAssignment(String assignment) {
        try {

            CreatgradeBook.mgb.outputAssignmentGrades(assignment);
        } 
        catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Create the frame.
     */
    public Searchbyassignment() {
        
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByAssignment = new JLabel("Grades For Assignment");
        lblSearchByAssignment.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByAssignment.setFont(new Font("Calibri", Font.BOLD, 25));
        lblSearchByAssignment.setBounds(82, 10, 269, 47);
        contentPane.add(lblSearchByAssignment);

        JLabel lblNewLabel = new JLabel("Assignment Name: ");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(28, 90, 163, 55);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(229, 88, 207, 62);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (correctAssignment(textField.getText())) {
                    XXXassignmentgrade.textArea.setText(CreatgradeBook.mgb
                            .outputAssignmentGrades(textField.getText()));
                    new XXXassignmentgrade().setVisible(true);
                } 
                else {
                    new NoSuchAssignment().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(151, 197, 176, 62);
        contentPane.add(btnNewButton);
    }

}
