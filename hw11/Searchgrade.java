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

import java.awt.SystemColor;
import java.awt.Color;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class Searchgrade extends JFrame {


    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Searchgrade frame = new Searchgrade();
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
    public Searchgrade() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setForeground(SystemColor.textHighlight);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Grades");
        btnNewButton.setForeground(new Color(220, 20, 60));
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchslection().setVisible(true);
            }
        });
        btnNewButton.setBounds(55, 114, 140, 146);
        contentPane.add(btnNewButton);

        JButton btnNewButton1 = new JButton("<html>" + "Section" + "<br>"
                + "general" + "</html>");
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Searchbysection().setVisible(true);

            }
        });
        btnNewButton1.setForeground(new Color(70, 130, 180));
        btnNewButton1.setFont(new Font("Calibri", Font.BOLD, 24));
        btnNewButton1.setBounds(245, 114, 140, 146);
        contentPane.add(btnNewButton1);

        JLabel lblSelectByWhat = new JLabel("What do you want to select?");
        lblSelectByWhat.setFont(new Font("Calibri", Font.BOLD, 25));
        lblSelectByWhat.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectByWhat.setBounds(85, 22, 342, 61);
        contentPane.add(lblSelectByWhat);
    }

}
