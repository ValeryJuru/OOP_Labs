package Lab10;
//Basic

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveLines {
    public static void main(String[] args) {
        Path path = Path.of("lines.txt");
        List<String> lines = new ArrayList<>();

        try (Scanner in = new Scanner(System.in)) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Line " + i + ": ");
                lines.add(in.nextLine());
            }
        }

        try {
            Files.write(path, lines);                    // creates or overwrites the file
            System.out.println("Saved " + lines.size() + " lines to " + path);

            System.out.println("--- Reading back ---");
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}