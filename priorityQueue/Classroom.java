package priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Classroom {
    static class Student implements Comparable<Student> { // function overriding
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank; // this will compare every student on rank basis..
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();//normal order
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());  //reverse order
        pq.add(new Student("A", 5)); // O(logn)
        pq.add(new Student("B", 1));
        pq.add(new Student("C", 15));
        pq.add(new Student("D", 8));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " " + pq.peek().rank);// O(1)
            pq.remove();// O(logn)
        }
    }
}
