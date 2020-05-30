package gradebook;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class GetGradeBook extends JFrame {

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GetGradeBook frame = new GetGradeBook();
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
    public GetGradeBook() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Success!!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 128, 51);
        contentPane.add(lblNewLabel);
    }

}
