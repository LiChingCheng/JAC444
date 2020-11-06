package student;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

public class WriteStudent {
    private static ObjectOutputStream output; // outputs data to file

    // open file student.txt
    public static void openFile() {
        try {
            output = new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        } catch (IOException ioException) {
            System.err.println("File can not open");
            System.exit(1); // terminate the program
        }
    }

    // add records to file
    public static void writeRecords() {
        Scanner input = new Scanner(System.in);
        int id;
        String fName;
        String lName;
        ArrayList<String> courses;
        try {
            System.out.print("Enter student ID: ");
            id = Integer.parseInt(input.nextLine());
            System.out.print("Enter student first name: ");
            fName = input.nextLine();
            System.out.print("Enter student last name: ");
            lName = input.nextLine();
            System.out.print("Enter student courses (ex: a b c ...separate by a space.): ");
            courses = new ArrayList<>();
            String allCourses = input.nextLine();

            String[] c = allCourses.split(" ");
            for (int i = 0; i < c.length; i++) {
                courses.add(c[i]);
            }
            Student student = new Student(id, fName, lName, courses);
            output.writeObject(student);

        } catch (NumberFormatException elementException) {
            System.err.println("ID should be number.");
            input.nextLine();
        } catch (IOException ioException) {
            System.err.println("Error to write the file.");
        }
    }

    // close file and terminate application
    public static void closeFile() {
        try {
            if (output != null)
                output.close();
        } catch (IOException ioException) {
            System.err.println("File can not close.");
        }
    }

    public static boolean moreRecord(String character) {
        boolean check = false;
        if (character.equalsIgnoreCase("Y") || character.equalsIgnoreCase("Yes")) {
            check = true;
        } else if (character.equalsIgnoreCase("N") || character.equalsIgnoreCase("No")) {
            check = false;
        } else {
            System.out.println("Invalid enter. Program end.");
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String check;

        openFile();
        do {
            writeRecords();
            System.out.print("Enter more records? ");
            check = input.nextLine();
        } while (moreRecord(check));
        closeFile();
    }
}
