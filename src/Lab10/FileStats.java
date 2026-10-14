package Lab10;
// Intermediate

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class FileStats {
    public static void main(String[] args) {
        Path path = Path.of("sample.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            int words = 0;
            int chars = 0;
            for (String line : lines) {
                chars += line.length();                          // line breaks not counted
                if (!line.isBlank()) {
                    words += line.trim().split("\\s+").length;   // split on runs of spaces
                }
            }
            System.out.println("Lines: " + lines.size());
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);
        } catch (NoSuchFileException e) {
            System.out.println("Missing file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}