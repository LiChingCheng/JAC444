package student;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class WriteStudent extends JPanel {
    private static JLabel idLabel;
    private static JLabel fNameLabel;
    private static JLabel lNameLabel;
    private static JLabel courseLabel;
    private static JTextField idField;
    private static JTextField fNameField;
    private static JTextField lNameField;
    private static JTextField courseField;
    private static JButton saveButton;
    private static JButton backButton;
    private static ObjectOutputStream output;

    public static void writeStudent(JPanel panel) {
        panel.removeAll();

        openFile();

        GridBagConstraints total = new GridBagConstraints();
        //ID Label
        idLabel = new JLabel("Student ID");
        total.gridx = 0;
        total.gridy = 0;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(idLabel, total);

        //ID TextField
        idField = new JTextField();

        total.gridx = 1;
        total.gridy = 0;
        total.gridwidth = 6;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(idField, total);

        //FirstName Label
        fNameLabel = new JLabel("First Name");
        total.gridx = 0;
        total.gridy = 1;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(fNameLabel, total);

        //FirstName TextField
        fNameField = new JTextField();

        total.gridx = 1;
        total.gridy = 1;
        total.gridwidth = 6;
        total.gridheight = 1;
        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(fNameField, total);

        //LastName Label
        lNameLabel = new JLabel("Last Name");
        total.gridx = 0;
        total.gridy = 2;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(lNameLabel, total);

        //LastName TextField
        lNameField = new JTextField(10);
        total.gridx = 1;
        total.gridy = 2;
        total.gridwidth = 6;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(lNameField, total);


        //Course Label
        courseLabel = new JLabel("Courses");

        total.gridx = 0;
        total.gridy = 3;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(courseLabel, total);

        //Course TextField
        courseField = new JTextField(10);
        total.gridx = 1;
        total.gridy = 3;
        total.gridwidth = 6;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.WEST;
        panel.add(courseField, total);

        //Save Button
        saveButton = new JButton("Save Record");
        total.gridx = 1;
        total.gridy = 4;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(saveButton, total);

        backButton = new JButton("Back to Menu");
        total.gridx = 2;
        total.gridy = 4;
        total.gridwidth = 1;
        total.gridheight = 1;

        total.fill = GridBagConstraints.BOTH;
        total.anchor = GridBagConstraints.CENTER;
        panel.add(backButton, total);


        saveButton.addActionListener(e -> {
            Connection connection = null;
            Statement statement = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdb", "root", "");
                statement = connection.createStatement();
                statement.executeUpdate("insert into students " + "values(" + Integer.parseInt(idField.getText())
                        + ", " + "'" + fNameField.getText() + "', " + "'" + lNameField.getText() + "', " + "'"
                        + courseField.getText() + "')");
//                Student student = addStudent(idField.getText(), fNameField.getText(), lNameField.getText(), courseField.getText());
//                output.writeObject(student);
                clearText(idField, fNameField, lNameField, courseField);
            } catch (NumberFormatException elementException) {
                System.err.println("ID should be number.");
            } catch (IOException ioException) {
                System.err.println("Error to write the file.");
            }
        });

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


    public static Student addStudent(String id, String firstName, String lastName, String course) {
        int tempId = Integer.parseInt(id);
        String tempFirstName = firstName;
        String tempLastName = lastName;
        ArrayList<String> tempCourse = new ArrayList<>();
        ;

        String[] c = course.split(" ");
        for (int i = 0; i < c.length; i++) {
            tempCourse.add(c[i]);
        }
        return new Student(tempId, tempFirstName, tempLastName, tempCourse);
    }

    public static void clearText(JTextField id, JTextField firstName, JTextField lastName, JTextField course) {
        id.setText("");
        firstName.setText("");
        lastName.setText("");
        course.setText("");
    }

    private static void openFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        } catch (IOException ioException) {
            System.err.println("File can not open");
            System.exit(1); // terminate the program
        }
    }

    private static void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("File can not close.");
        }
    }

//    public static void main(String[] args) {
//        JPanel panel = new JPanel(new GridBagLayout());
//        writeStudent(panel);
//    }
}



