package main;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Nathan
 */
public class Student implements Comparator<Student> {

    private int id;
    private String name;
    private double cgpa;

    public Student() {
    }

    public Student(String name, double cgpa, int id) {
        if (id >= 1 && id <= 1000000)
            this.id = id;
        else {
            System.out.println("invalid id");
            return;
        }
        if (name.length() >= 2 && name.length() <= 30)
            this.name = name;
        else {
            System.out.println("invalid length of name");
            return;
        }
        if (cgpa >= 0 && cgpa <= 4.00)
            this.cgpa = cgpa;
        else {
            System.out.println("invalid cgpa");
            return;
        }
    }

    /**
     * 1. The student having the highest Cumulative Grade Point Average (CGPA) is served first.
     * 2. Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical
     * order.
     * 3. Any students having the same CGPA and name will be served in ascending order of the id.
     *
     * @param s1
     * @param s2
     * @return
     */
    // O(1)
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() < s2.getCgpa())
            return -1;
        else if (s1.getCgpa() > s2.getCgpa())
            return 1;
        else if (s1.getCgpa() == s2.getCgpa()) {
            if (s1.getName().equals(s2.getName())) {
                if (s1.getId() < s2.getId())
                    return -1;
                else if (s1.getId() > s2.getId())
                    return 1;
            } else {
                return s2.getName().compareTo(s1.getName());
            }
        }

        return 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}
    class Priorities {

        /**
         * to process all the given events and return all the students yet to be served.
         * I am assuming the length of the PriorityQueue is going to be 12.
         *
         * @param events
         * @return
         */
        public static List<Student> getStudents(List<String> events){

            Student studentComparator = new Student();
            PriorityQueue<Student> priorityQueue =new PriorityQueue<>(12,
                    (x, y) -> studentComparator.compare(y, x));
            System.out.println(events.size());
            for (String event : events){
                String[] input = new String[4];
                input = event.split("\\s");
                if (input.length > 1){
                    priorityQueue.add(new Student(input[1], Double.valueOf(input[2]), Integer.valueOf(input[3])));
                }else{
                    priorityQueue.remove();
                }

            }

            return priorityQueue.stream().toList();

        }

}
