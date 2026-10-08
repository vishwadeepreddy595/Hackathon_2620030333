import java.util.Scanner;

class Student {

    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    
    Student(String studentName, int rollNumber, double marks,
            String courseName, int courseCredits) {

        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    
    double calculateFee() {
        return courseCredits * 1500;
    }

    
    boolean checkEligibility() {
        return marks >= 50;
    }

    
    double calculateScholarship() {

        if (marks >= 85) {
            return 20;
        } 
        else if (marks >= 70) {
            return 10;
        } 
        else {
            return 0;
        }
    }

    
    double calculateFinalFee() {

        double fee = calculateFee();
        double scholarshipPercent = calculateScholarship();

        double scholarshipAmount =
                fee * scholarshipPercent / 100;

        return fee - scholarshipAmount;
    }

    
    void displayDetails() {

        double fee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount =
                fee * scholarshipPercent / 100;
        double finalFee = calculateFinalFee();

        System.out.println("\n----- Student Course Registration Details -----");

        System.out.println("Student Name       : " + studentName);
        System.out.println("Roll Number        : " + rollNumber);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + courseName);
        System.out.println("Course Credits     : " + courseCredits);

        System.out.println("Eligibility        : Eligible");
        System.out.println("Total Course Fee   : Rs. " + fee);
        System.out.println("Scholarship        : " + scholarshipPercent + "%");
        System.out.println("Scholarship Amount : Rs. " + scholarshipAmount);
        System.out.println("Final Fee          : Rs. " + finalFee);
    }
}

public class HackathonSecond
 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        
        Student s = new Student(name, roll, marks, course, credits);

        
        if (s.checkEligibility()) {
            s.displayDetails();
        } 
        else {
            System.out.println("\nStudent is not eligible for course registration.");
            System.out.println("Minimum required marks: 50");
        }

        sc.close();
    }
}
