package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
public class Searchslection extends JFrame {


    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Searchslection frame = new Searchslection();
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
    public Searchslection() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Search Selection");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 26));
        lblNewLabel.setBounds(87, 10, 279, 52);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Grades For Students");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchbystudent().setVisible(true);
            }
        });
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
        btnNewButton.setBounds(59, 75, 328, 59);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton("Grades For Assignments");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchbyassignment().setVisible(true);
            }
        });
        btnNewButton1.setFont(new Font("Calibri", Font.BOLD, 20));
        btnNewButton1.setBounds(59, 159, 338, 60);
        contentPane.add(btnNewButton1);

        JButton btnNewButton2 = new JButton("Grade Of Single Assignment");
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchbyusernameandass().setVisible(true);
            }
        });
        btnNewButton2.setFont(new Font("Calibri", Font.BOLD, 20));
        btnNewButton2.setBounds(59, 243, 338, 52);
        contentPane.add(btnNewButton2);
    }

}
