package gradebook;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class CreatgradeBook extends JFrame {

    
    /**elements*/
    private JTextField txtInitialtxt;
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
                    CreatgradeBook frame = new CreatgradeBook();
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
    public CreatgradeBook() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtInitialtxt = new JTextField();
        txtInitialtxt.setHorizontalAlignment(SwingConstants.CENTER);
        txtInitialtxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
        txtInitialtxt.setText("initial.txt");
        txtInitialtxt.setBounds(89, 88, 267, 65);
        contentPane.add(txtInitialtxt);
        txtInitialtxt.setColumns(10);

        JButton btnNewButton = new JButton("Create");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mgb = MyGradeBook.initializeWithFile(txtInitialtxt.getText()
                        .toString());
                new Gradebookmain().setVisible(true);
            }
        });

        JLabel lbltxtFile = new JLabel(".txt file:");
        lbltxtFile.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lbltxtFile.setBounds(10, 91, 80, 45);
        contentPane.add(lbltxtFile);

        btnNewButton.setBounds(111, 208, 245, 73);
        contentPane.add(btnNewButton);
    }
}
