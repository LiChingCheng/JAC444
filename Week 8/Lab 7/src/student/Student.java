package student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;

public class Student {
    private String firstName;
    private String lastName;
    private Double grade;
    private String department;

    public Student() {
        firstName = null;
        lastName = null;
        grade = 0.00;
        department = null;
    }

    public Student(String firstName, String lastName, Double grade, String department) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setDepartment(department);
    }

    public void setFirstName(String firstName) {
        if(firstName != null) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName != null) {
            this.lastName = lastName;
        }
    }

    public String getFirstName() {
        if(firstName != null) {
            return firstName;
        }
        else {
            return "No FirstName";
        }
    }

    public String getLastName() {
        if(lastName != null) {
            return lastName;
        }
        else {
            return "No LastName";
        }
    }

    public String getName() {
        if(firstName != null && lastName != null) {
            return String.format(firstName + " " + lastName);
        }
        else {
            return "No Student!";
        }
    }

    public void setGrade(Double grade) {
        if(grade > 0) {
            this.grade = grade;
        }
    }

    public Double getGrade() {
            return grade;
    }

    public void setDepartment(String department) {
        if(department != null) {
            this.department = department;
        }
    }

    public String getDepartment() {
        if(department != null) {
            return department;
        }
        else {
            return "No Department";
        }
    }

    @Override
    public String toString() {
        return  String.format("%-12s", firstName) +
                String.format("%-12s", lastName) +
                String.format("%-7.2f", grade)+
                String.format("%-12s", department);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    @Override
//    public int compareTo(Student student) {
////        double compareGrade = student.getGrade();
////        return (int)(Math.round(this.grade - compareGrade));
//
//    }

}
