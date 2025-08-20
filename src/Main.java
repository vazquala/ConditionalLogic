import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PART I, STUDENT DATA COLLECTION //
        System.out.println("=== Student Information System ===");

        System.out.println("Enter student name: "); // Information gathering
        String name = input.nextLine();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter GPA: ");
        double GPA = input.nextDouble();
        System.out.println("Enter credits completed: ");
        int credits = input.nextInt();
        System.out.println("Is student a resident? (true/false): ");
        boolean resident = input.nextBoolean();
        System.out.println("Does student have financial aid? (true/false): ");
        boolean financialAid = input.nextBoolean();
        System.out.println();

        System.out.println("=== STUDENT REPORT ==="); // Start of student report
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + GPA);
        System.out.println("Credits: " + credits);

        if (resident) {
            System.out.println("Resident: Yes");
        } else {
            System.out.println("Resident: No");
        }

        if (financialAid) {
            System.out.println("Financial Aid: Yes");
        } else {
            System.out.println("Financial Aid: No");
        }

        System.out.println();

        // PART II, ACADEMIC STANDING CLASSIFICATION //
        if (GPA >= 3.5) {
            System.out.println("Academic Standing: Dean's List");
        } else if (GPA >= 2.0 && GPA < 3.5) {
            System.out.println("Academic Standing: Good Standing");
        } else if  (GPA >= 1.5 && GPA < 2.0) {
            System.out.println("Academic Standing: Academic Warning");
        } else if (GPA < 1.5) {
            System.out.println("Academic Standing: Academic Probation");
        }

        // PART III, CLASS LEVEL DETERMINATION //
        if (credits >= 90) {
            System.out.println("Class Level: Senior");
        } else if (credits >= 60 && credits < 90) {
            System.out.println("Class Level: Junior");
        } else if (credits >= 30 && credits < 60) {
            System.out.println("Class Level: Sophomore");
        } else if (credits >= 0 && credits < 30) {
            System.out.println("Class Level: Freshman");
        }

        System.out.println();

        // PART IV, PROGRAM ELIGIBILITY //
        System.out.println("=== ELIGIBILITY STATUS ===");
        if (GPA >= 3.5 && credits >= 60) {
            System.out.println("Honor Society: Eligible");
        } else {
            System.out.println("Honor Society: Not Eligible");
        }

        if (GPA >= 2.0 && credits >= 120) {
            System.out.println("Graduation: Eligible");
        } else {
            System.out.println("Graduation: Not Eligible (needs " + (120 - credits) + " more credits)");
        }

        if (financialAid) {
            if (GPA >= 2.0 && (credits/(age-14)) >= 12) {
                System.out.println("Financial Aid Renewal: Eligible");
            } else if (GPA < 2.0 && (credits/(age-14)) >= 12) {
                System.out.println("Financial Aid Renewal: Not Eligible (GPA too low)");
            } else if (GPA >= 2.0 && (credits/(age-14)) < 12) {
                System.out.println("Financial Aid Renewal: Not Eligible (not enough credits)");
            } else if (GPA < 2.0 && (credits/(age-14)) < 12) {
                System.out.println("Financial Aid Renewal: Not Eligible (GPA too low and not enough credits)");
            }
        } else {
            System.out.println("Financial Aid Renewal: N/A (no current aid)");
        }

        if (!financialAid) {
            if (GPA >= 3.0 && resident) {
                System.out.println("Scholarship: Eligible");
            } else if (GPA < 3.0 && resident) {
                System.out.println("Scholarship: Not Eligible (GPA too low)");
            } else if (GPA >= 3.0 && !resident) {
                System.out.println("Scholarship: Not Eligible (not a resident)");
            } else if  (GPA < 3.0 && !resident) {
                System.out.println("Scholarship: Not Eligible (GPA too low and not a resident)");
            }
        } else {
            System.out.println("Scholarship: Not Eligible (already have financial aid)");
        }

        System.out.println();

        // PART V, RECOMMENDATIONS //
        System.out.println("=== RECOMMENDATIONS ===");
        if (GPA < 2.0) {
            System.out.println("- Your GPA is below 2.0. We strongly recommend tutoring services.");
        }

        if ((credits/(age-14)) < 12) {
            System.out.println("- You may be behind on credits for your age. Consider meeting with an academic counselor.");
        }

        if (!financialAid && GPA >= 3.0 && resident) {
            System.out.println("- You are eligible for scholarship programs! Consider applying.");
        }

        if (credits >= 100) {
            System.out.println("- You are about to graduate! Consider meeting with an advisor");
        }
    }
}