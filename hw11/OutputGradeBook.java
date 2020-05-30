package gradebook;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class OutputGradeBook extends JFrame {


    /**elements*/
    static JTextField textField = new JTextField();

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OutputGradeBook frame = new OutputGradeBook();
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
    public OutputGradeBook() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Output");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.setBounds(147, 184, 203, 63);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    CreatgradeBook.mgb.outputGradeBookFile(textField.getText()
                            .toString());
                } 
                catch (FileNotFoundException e1) {

                    e1.printStackTrace();
                }
                new GetGradeBook().setVisible(true);
            }
        });
        JLabel lblNewLabel = new JLabel(".txt");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(56, 71, 83, 57);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(114, 88, 236, 42);
        contentPane.add(textField);
        textField.setColumns(10);
    }
}
