package javatask_3;

import java.util.*;

class Student {
    int id;
    String name;// name
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + marks;
    }
}

public class CollectionTask {
    public static void main(String[] args) {

        // ===== ArrayList =====
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student(1, "Aman", 85));
        arrayList.add(new Student(2, "Rohit", 75));
        arrayList.add(new Student(3, "Neha", 90));

        System.out.println("ArrayList Data:");
        for (Student s : arrayList) {
            System.out.println(s);
        }

        // ===== LinkedList =====
        LinkedList<Student> linkedList = new LinkedList<>(arrayList);
        linkedList.addFirst(new Student(0, "Start", 60));

        System.out.println("\nLinkedList Data:");
        Iterator<Student> it = linkedList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // ===== HashSet (Unique Data) =====
        HashSet<Integer> uniqueIds = new HashSet<>();
        uniqueIds.add(1);
        uniqueIds.add(2);
        uniqueIds.add(2); // duplicate
        uniqueIds.add(3);

        System.out.println("\nUnique IDs using HashSet:");
        System.out.println(uniqueIds);

        // ===== Sorting using Comparator =====
        Collections.sort(arrayList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.marks - s1.marks; // descending
            }
        });

        System.out.println("\nSorted by Marks (Descending):");
        for (Student s : arrayList) {
            System.out.println(s);
        }

        // ===== Sorting Metrics (Time Comparison) =====
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(new Student(i, "Test", i));
        }
        long end = System.nanoTime();

        System.out.println("\nArrayList insertion time: " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(new Student(i, "Test", i));
        }
        end = System.nanoTime();

        System.out.println("LinkedList insertion time: " + (end - start) + " ns");
    }
}