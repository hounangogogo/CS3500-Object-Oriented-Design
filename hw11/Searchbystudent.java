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
public class Searchbystudent extends JFrame {

 
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
                    Searchbystudent frame = new Searchbystudent();
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
     * @param username String
     * @return boolean
     */
    public boolean correctUsername(String username) {
        try {

            CreatgradeBook.mgb.outputStudentGrades(username);
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
    public Searchbystudent() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel("Grade For Students");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 25));
        lblSearchByStudent.setBounds(82, 10, 269, 47);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("Student username");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(46, 83, 156, 62);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(212, 93, 183, 47);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (correctUsername(textField.getText().toString())) {
                    XXXStudentgrade.textArea.setText(CreatgradeBook.mgb
                            .outputStudentGrades(
                                    textField.getText().toString()));
                    new XXXStudentgrade().setVisible(true);
                } 
                else {
                    new NoSuchStudent().setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(131, 186, 220, 68);
        contentPane.add(btnNewButton);
    }

}
