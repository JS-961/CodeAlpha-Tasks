package codeAlpha;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTrackerV1 {
    private ArrayList<Double> grades;

    public StudentGradeTrackerV1() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double computeAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public double findHighestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }

        return highest;
    }

    public double findLowestGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }

        return lowest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentGradeTrackerV1 tracker = new StudentGradeTrackerV1();
        
        System.out.println("Enter grades (type 'done' to finish):");

        while (true) {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double grade = Double.parseDouble(input);
                tracker.addGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
            }
        }

        System.out.printf("Average Grade: %.2f\n", tracker.computeAverage());
        System.out.printf("Highest Grade: %.2f\n", tracker.findHighestGrade());
        System.out.printf("Lowest Grade: %.2f\n", tracker.findLowestGrade());

        scan.close();
    }
}
