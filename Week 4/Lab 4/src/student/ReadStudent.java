package student;
import java.io.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadStudent {
    private static ObjectInputStream input;

    public static void openFile() {
        try { // open file
            input = new ObjectInputStream(new FileInputStream(new File("./student.txt")));

        } catch (IOException ioException) {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    static void readRecord() {
        try {
            while (input != null) {
                Student student = (Student) input.readObject();
                System.out.println(student.toString() + "\n");
            }
        } catch (EOFException e) {
            System.out.println("No more record!\n");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // close file and terminate application
    public static void closeFile() {
        try {
            if (input != null)
                input.close();
        } catch (IOException ioException) {
            System.err.println("File can not close.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        openFile();
        readRecord();
        closeFile();
    }
}
