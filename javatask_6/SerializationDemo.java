package javatask_6;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) {

        Student s1 = new Student(1, "Rahul", 85.5);

        // 🔸 Serialization (Object → File)
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("student.ser"));

            oos.writeObject(s1);
            oos.close();

            System.out.println("Object Serialized Successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔸 Deserialization (File → Object)
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("student.ser"));

            Student s2 = (Student) ois.readObject();
            ois.close();

            System.out.println("Deserialized Object: " + s2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}