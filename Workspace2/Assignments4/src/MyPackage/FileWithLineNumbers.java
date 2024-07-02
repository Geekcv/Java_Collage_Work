package MyPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileWithLineNumbers {

    public static void main(String[] args) {
        String filename = "E:\\newpass.txt"; // Replace with your file path

        displayFileWithLineNumbers(filename);
    }

    public static void displayFileWithLineNumbers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;

            System.out.println("File Contents with Line Numbers:");
            while ((line = reader.readLine()) != null) {
                System.out.printf("%d: %s\n", lineNumber++, line);
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
