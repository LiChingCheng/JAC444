package student;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdID;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses;

    public Student() {
        stdID = 0;
        firstName = null;
        lastName = null;
        courses = null;
    }

    public Student(int id, String fName, String lName, ArrayList<String> course) {
        setID(id);
        setFirstName(fName);
        setLastName(lName);
        setCourse(course);
    }

    public void setID(int id) {
        if (id > 0) {
            stdID = id;
        }
    }

    public void setFirstName(String fName) {
        if (fName != null) {
            firstName = fName;
        }
    }

    public void setLastName(String lName) {
        if (lName != null) {
            lastName = lName;
        }
    }

    public void setCourse(ArrayList<String> course) {
        if (course != null) {
            courses = course;
        }
    }

    public int getID() {
        return stdID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public String toString() {
        return "Student ID: " + getID() + "\nFirst Name: " + getFirstName() +
                "\nLast Name: " + getLastName() + "\nCourses: " + getCourses();
    }
}




