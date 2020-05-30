package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Gradebookmain extends JFrame {


    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gradebookmain frame = new Gradebookmain();
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
    public Gradebookmain() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton2 = new JButton("Create new");
        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Add().setVisible(true);
            }
        });
        btnNewButton2.setFont(new Font("Calibri", Font.BOLD, 25));
        btnNewButton2.setBounds(72, 53, 302, 43);
        contentPane.add(btnNewButton2);

        JButton btnNewButton3 = new JButton("Search Grade");
        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchgrade().setVisible(true);

            }
        });
        btnNewButton3.setFont(new Font("Calibri", Font.BOLD, 25));
        btnNewButton3.setBounds(72, 109, 302, 38);
        contentPane.add(btnNewButton3);

        JButton btnNewButton5 = new JButton("Update Grade");
        btnNewButton5.setFont(new Font("Calibri", Font.BOLD, 25));
        btnNewButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeGrade().setVisible(true);
            }
        });
        btnNewButton5.setBounds(72, 160, 302, 45);
        contentPane.add(btnNewButton5);

        JLabel lblGradeBook = new JLabel("Grade Book");
        lblGradeBook.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 35));
        lblGradeBook.setBounds(126, 10, 179, 43);
        contentPane.add(lblGradeBook);

        JButton btnNewButton = new JButton("Current Grades");
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 25));

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CurrentGrade.textArea.setText(CreatgradeBook.mgb
                        .outputCurrentGrades());
                new CurrentGrade().setVisible(true);
            }
        });
        btnNewButton.setBounds(72, 218, 302, 46);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton("OutPut GradeBook");
        btnNewButton1.setFont(new Font("Calibri", Font.BOLD, 25));

        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new OutputGradeBook().setVisible(true);
            }
        });
        btnNewButton1.setBounds(72, 277, 302, 43);
        contentPane.add(btnNewButton1);
    }
}
