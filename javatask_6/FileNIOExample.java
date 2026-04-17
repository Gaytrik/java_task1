package javatask_6;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class FileNIOExample {

    public static void main(String[] args) {

        Path path = Paths.get("niofile.txt");

        try {
            // Write
            Files.write(path, "Using NIO File API".getBytes());

            // Read
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}