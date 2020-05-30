package gradebook;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Add extends JFrame {

    
  

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add frame = new Add();
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
    public Add() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("What do you want to add?");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(52, 20, 347, 37);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton(
                "Click here to Create New Assignment");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Creatnewgassignment().setVisible(true);
            }
        });
        btnNewButton.setBounds(89, 70, 284, 61);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton(
                "Click here to Create New Student");
        btnNewButton1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Createnewstudent().setVisible(true);
            }
        });
        btnNewButton1.setBounds(89, 156, 284, 61);
        contentPane.add(btnNewButton1);

        JButton btnNewButton2 = new JButton("Click here to Create New Grade");
        btnNewButton2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Creatnewgrade().setVisible(true);
            }
        });
        btnNewButton2.setBounds(89, 261, 284, 54);
        contentPane.add(btnNewButton2);
    }

}
