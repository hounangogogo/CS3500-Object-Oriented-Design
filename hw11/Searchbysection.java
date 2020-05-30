package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Searchbysection extends JFrame {

    /**elements*/
    private JTextField textField;
    /**elements*/
    JLabel lblNewLabel4 = new JLabel("XXXXX");
    /**elements*/
    JLabel lblNewLabel5 = new JLabel("XXXXXX");
    /**elements*/
    JLabel lblNewLabel6 = new JLabel("XXXXXXX");
    /**elements*/
    JLabel lblNewLabel7 = new JLabel("XXXXX");

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Searchbysection frame = new Searchbysection();
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

            CreatgradeBook.mgb.average(assignment);
            CreatgradeBook.mgb.max(assignment);
            CreatgradeBook.mgb.min(assignment);
            CreatgradeBook.mgb.median(assignment);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    /**
     * Create the frame.
     */
    public Searchbysection() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Average :");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel.setBounds(21, 10, 92, 32);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel1 = new JLabel("MAX :");
        lblNewLabel1.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel1.setBounds(21, 52, 92, 32);
        contentPane.add(lblNewLabel1);

        JLabel lblNewLabel2 = new JLabel("MIN :");
        lblNewLabel2.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel2.setBounds(196, 52, 92, 32);
        contentPane.add(lblNewLabel2);

        JLabel lblNewLabel3 = new JLabel("Median :");
        lblNewLabel3.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel3.setBounds(196, 10, 92, 32);
        contentPane.add(lblNewLabel3);

        lblNewLabel4.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel4.setBounds(107, 10, 79, 32);
        contentPane.add(lblNewLabel4);

        lblNewLabel5.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel5.setBounds(275, 52, 128, 32);
        contentPane.add(lblNewLabel5);

        lblNewLabel6.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel6.setBounds(275, 7, 128, 38);
        contentPane.add(lblNewLabel6);

        lblNewLabel7.setFont(new Font("Calibri", Font.BOLD, 18));
        lblNewLabel7.setBounds(107, 52, 128, 32);
        contentPane.add(lblNewLabel7);

        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (correctAssignment(textField.getText())) {
                    Double average = CreatgradeBook.mgb.average(textField
                            .getText());
                    Double max = CreatgradeBook.mgb.max(textField.getText());
                    Double min = CreatgradeBook.mgb.min(textField.getText());
                    Double median = CreatgradeBook.mgb.median(textField
                            .getText());
                    lblNewLabel4.setText(String.valueOf(average));
                    lblNewLabel7.setText(String.valueOf(max));
                    lblNewLabel5.setText(String.valueOf(min));
                    lblNewLabel6.setText(String.valueOf(median));

                } 
                else {
                    new NoSuchAssignment().setVisible(true);
                }
            }
        });
        btnSearch.setBounds(159, 224, 148, 65);
        contentPane.add(btnSearch);

        textField = new JTextField();
        textField.setBounds(139, 148, 168, 38);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblInputAssignmentName = new JLabel("Input Assignment name");
        lblInputAssignmentName.setHorizontalAlignment(SwingConstants.CENTER);
        lblInputAssignmentName.setFont(new Font("Calibri", Font.BOLD, 18));
        lblInputAssignmentName.setForeground(Color.BLACK);
        lblInputAssignmentName.setBounds(78, 97, 257, 41);
        contentPane.add(lblInputAssignmentName);
    }
}
