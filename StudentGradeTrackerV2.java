package codeAlpha;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTrackerV2 {
    private ArrayList<Student> students;

    public StudentGradeTrackerV2() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, double grade) {
        students.add(new Student(name, grade));
    }

    public double computeAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (Student student : students) {
            sum += student.getGrade();
        }

        return sum / students.size();
    }

    public double findHighestGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double highest = students.get(0).getGrade();
        for (Student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }

        return highest;
    }

    public double findLowestGrade() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double lowest = students.get(0).getGrade();
        for (Student student : students) {
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }

        return lowest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentGradeTrackerV2 tracker = new StudentGradeTrackerV2();

        System.out.println("Enter student name and grade (type 'done' to finish):");

        while (true) {
            System.out.print("Student Name: ");
            String name = scan.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            while (true) {
                System.out.print("Grade: ");
                String gradeInput = scan.nextLine();

                try {
                    double grade = Double.parseDouble(gradeInput);
                    tracker.addStudent(name, grade);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid grade. Please enter a valid number.");
                }
            }
        }

        System.out.printf("Average Grade: %.2f\n", tracker.computeAverage());
        System.out.printf("Highest Grade: %.2f\n", tracker.findHighestGrade());
        System.out.printf("Lowest Grade: %.2f\n", tracker.findLowestGrade());

        scan.close();
    }
}
