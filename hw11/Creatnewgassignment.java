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
public class Creatnewgassignment extends JFrame {

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
                    Creatnewgassignment frame = new Creatnewgassignment();
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
    public Creatnewgassignment() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchByStudent = new JLabel("Input Assignment Information");
        lblSearchByStudent.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchByStudent.setFont(new Font("Calibri", Font.BOLD, 20));
        lblSearchByStudent.setBounds(56, 10, 331, 60);
        contentPane.add(lblSearchByStudent);

        JLabel lblNewLabel = new JLabel("Name");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(43, 61, 137, 31);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(192, 61, 195, 40);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Create");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isDouble(textField1.getText())
                        && isDouble(textField2.getText())) {
                    Assignment assignment = new Assignment();
                    assignment.setName(textField.getText().toString());
                    assignment.setTotalPoints(Integer.parseInt(textField1
                            .getText()));
                    assignment.setPercentOfGrade(Double.parseDouble(textField2
                            .getText()));
                    CreatgradeBook.mgb.addAssignment(assignment);
                    new Newgrade().setVisible(true);
                } 
                else {
                    new ErrorInformationAssignments().setVisible(true);

                }
            }
        });
        btnNewButton.setBounds(152, 239, 182, 41);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel1 = new JLabel("totalPoints");
        lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel1.setBounds(40, 124, 120, 31);
        contentPane.add(lblNewLabel1);

        textField1 = new JTextField();
        textField1.setBounds(197, 122, 190, 33);
        contentPane.add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("percentOfGrade");
        lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel2.setBounds(40, 168, 154, 41);
        contentPane.add(lblNewLabel2);

        textField2 = new JTextField();
        textField2.setBounds(197, 179, 190, 30);
        contentPane.add(textField2);
        textField2.setColumns(10);
    }

}
