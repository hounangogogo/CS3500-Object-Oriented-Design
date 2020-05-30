package gradebook;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class ErrorInformationAssignments extends JFrame {


    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ErrorInformationAssignments frame = 
                            new ErrorInformationAssignments();
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
    public ErrorInformationAssignments() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("<html>" + "Can't add" + "<br>"
                + " such Assignment" + "<br>" + "please check the " + "<br>"
                + "information you input!" + "</html>");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 13, 482, 329);
        contentPane.add(lblNewLabel);
    }
}
