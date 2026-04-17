package javatask_6;

import java.io.*;

public class TextProcessor {

    public static void main(String[] args) {

        // 🔸 Writing to file
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("data.txt"));

            writer.write("Hello Java\n");
            writer.write("File Handling Task\n");

            writer.close();
            System.out.println("Data Written Successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 🔸 Reading from file
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("data.txt"));

            String line;

            System.out.println("Reading File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}