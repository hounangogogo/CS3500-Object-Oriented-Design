package gradebook;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

/**
 * GUI main class for initializing implementation
 * 
 * @author Yuecan Fan, CHao Fang, Haonan Wei, Zhen Wei
 * @version 04/11/2014
 * 
 */
public class Main extends JFrame {

    /**elements*/
    public static MyGradeBook mgb = new MyGradeBook();
    
    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
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
    public Main() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSelectGradeBook = new JLabel("Initiailize Grade book");
        lblSelectGradeBook.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectGradeBook.setFont(new Font("Calibri", Font.BOLD, 30));
        lblSelectGradeBook.setBounds(37, 10, 327, 47);
        contentPane.add(lblSelectGradeBook);

        JButton btnNewGradeBook = new JButton("Empty Grade Book");
        btnNewGradeBook.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewGradeBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new Gradebookmain().setVisible(true);
                mgb = MyGradeBook.initialize();

            }
        });
        btnNewGradeBook.setBounds(131, 85, 233, 74);
        contentPane.add(btnNewGradeBook);

        JButton btnNewButton = new JButton("Initialize with a file");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreatgradeBook().setVisible(true);
            }
        });
        btnNewButton.setBounds(131, 200, 233, 74);
        contentPane.add(btnNewButton);
    }
}
