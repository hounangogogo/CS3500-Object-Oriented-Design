package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class SingleAss extends JFrame {

    /**elements*/
    static JLabel lblNewLabel = new JLabel("XXXXXX");
    /**elements*/
    static JLabel lblXxxxxx = new JLabel("XXXXXX");

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SingleAss frame = new SingleAss();
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
    public SingleAss() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblThisAssignmentGrade = new JLabel("This Assignment Grade:");
        lblThisAssignmentGrade.setFont(new Font("Calibri", Font.BOLD, 25));
        lblThisAssignmentGrade.setHorizontalAlignment(SwingConstants.CENTER);
        lblThisAssignmentGrade.setBounds(29, 22, 380, 46);
        contentPane.add(lblThisAssignmentGrade);

        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(86, 78, 267, 79);
        contentPane.add(lblNewLabel);

        JLabel lblCurrentGrade = new JLabel("Student's Current Grade:");
        lblCurrentGrade.setFont(new Font("Calibri", Font.ITALIC, 20));
        lblCurrentGrade.setBounds(29, 206, 207, 60);
        contentPane.add(lblCurrentGrade);
        lblXxxxxx.setFont(new Font("Times New Roman", Font.BOLD, 20));

        lblXxxxxx.setHorizontalAlignment(SwingConstants.CENTER);
        lblXxxxxx.setBounds(231, 215, 122, 40);
        contentPane.add(lblXxxxxx);
    }

}
