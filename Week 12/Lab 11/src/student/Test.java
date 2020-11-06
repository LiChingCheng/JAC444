package student;

import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {

    private static JButton writeButton;
    private static JButton readButton;
    private static JButton exitButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Student Information");
        frame.setLayout(new GridBagLayout());
        frame.setSize(500,400);

        JPanel panel = new JPanel(new GridBagLayout());
        //panel.setSize(450, 300);
        panel.setBounds(0,0,1000,1000);
        Menu(panel);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void Menu(JPanel panel) {
        panel.removeAll();
        GridBagConstraints total = new GridBagConstraints();

        writeButton = new JButton("Insert Student");
        total.gridx = 0;
        total.gridy = 0;
        total.gridwidth = 2;
        total.gridheight = 1;
        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(writeButton, total);

        writeButton.addActionListener(e -> {
            WriteStudent.writeStudent(panel);
        });

        readButton = new JButton("Read Student");
        total.gridx = 0;
        total.gridy = 1;
        total.gridwidth = 2;
        total.gridheight = 1;
        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(readButton, total);

        readButton.addActionListener(e -> {
            ReadStudent.readStudent(panel);
        });

        exitButton = new JButton("Exit");
        total.gridx = 0;
        total.gridy = 3;
        total.gridwidth = 2;
        total.gridheight = 1;
        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(exitButton, total);

        exitButton.addActionListener(e -> System.exit(0));
        panel.validate();
        panel.repaint();
    }
}
