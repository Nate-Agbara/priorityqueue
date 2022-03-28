package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Nathan
 */
public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        System.out.println("Enter the total number of events: ");
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        System.out.println("Paste all "+totalEvents+" events now and hit ENTER key.");
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        System.out.println();
        System.out.println("Thank you! Here you go...");
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
