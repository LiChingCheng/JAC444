package student;
import java.io.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class ReadStudent extends JPanel {

    private static JLabel idLabel;
    private static Student student;
    private static JTextArea textArea;
    private static JButton backButton;
    private static ObjectInputStream input;

    public static void readStudent(JPanel panel) {

        panel.removeAll();
        GridBagConstraints total = new GridBagConstraints();



       // try {
       //     openFile();

            //ID Label
            idLabel = new JLabel("Student");
            total.gridx = 0;
            total.gridy = 0;
            total.gridwidth = 1;
            total.gridheight = 1;
            total.fill = GridBagConstraints.NONE;
            total.anchor = GridBagConstraints.CENTER;
            panel.add(idLabel, total);

            //ID TextField
            textArea = new JTextArea();
            total.gridx = 0;
            total.gridy = 1;
            total.gridwidth = 10;
            total.gridheight = 10;
            total.fill = GridBagConstraints.BOTH;
            total.anchor = GridBagConstraints.CENTER;
            panel.add(textArea, total);

        Connection con = null;
        Statement stmt = null;
        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstDB", "root", "");
            con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");

            while (rs.next()) {
                textArea.append("Student ID: " + rs.getString(1) + "\n" + "First Name: " + rs.getString(2)
                        + "\n" + "Last Name: " + rs.getString(3) + "\n" + "Courses: " + rs.getString(4) + "\n"
                        + "\n");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
                if (con != null)
                    con.close();
            } catch (Exception ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }

//            while (input != null) {
//                student = (Student) input.readObject();
//                System.out.println(student.toString());
//                textArea.append(student.toString() + "\n" + "\n");
//            }

//            closeFile();

//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        backButton = new JButton("Back to Menu");
        total.gridx = 0;
        total.gridy = 20;
        total.gridwidth = 1;
        total.gridheight = 1;
        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(backButton, total);

        backButton.addActionListener(e -> {
            try {
                closeFile();
                Test.Menu(panel);

            } catch (Throwable err) {
                System.out.println(err);
            }
        });

        panel.validate();
        panel.repaint();
    }

    public static void openFile() {
        try { // open file
            input = new ObjectInputStream(new FileInputStream(new File("student.txt")));

        } catch (IOException ioException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public static void closeFile() {
        try {
            if (input != null)
                input.close();
        } catch (IOException ioException) {
            System.err.println("File can not close.");
            System.exit(1);
        }
    }
}
