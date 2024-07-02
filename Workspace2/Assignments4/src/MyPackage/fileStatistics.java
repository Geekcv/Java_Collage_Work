package MyPackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fileStatistics {

    public static void main(String[] args) {
        String filename = "E:\\newpass.txt"; // Replace with your file path

        displayFileStats(filename);
    }

    public static void displayFileStats(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++; // Count lines

                charCount += line.length(); // Count characters

                String[] words = line.trim().split("\\s+"); // Split by whitespace to count words
                wordCount += words.length;
            }

            System.out.println("File Statistics:");
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
