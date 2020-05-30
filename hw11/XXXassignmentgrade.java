package gradebook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextArea;

/**
 * Assignment class
 * 
 * @author Zhen
 * @version 2014-04-10
 */
public class XXXassignmentgrade extends JFrame {


    /**elements*/
    static TextArea textArea = new TextArea();

    /**
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    XXXassignmentgrade frame = 
                            new XXXassignmentgrade();
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
    public XXXassignmentgrade() {
        JPanel contentPane;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(180, 180, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textArea.setBounds(0, 0, 617, 399);
        contentPane.add(textArea);
    }

}
