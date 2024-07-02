package Mypackage;

import java.util.Arrays;
import java.util.Scanner;

public class NameSorter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of names
        System.out.print("Enter the number of names you want to sort: ");
        int numberOfNames = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Initialize an array to hold the names
        String[] names = new String[numberOfNames];

        // Read the names from the user
        System.out.println("Enter the names:");
        for (int i = 0; i < numberOfNames; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // Sort the names in ascending order
        Arrays.sort(names);

        // Print the sorted names
        System.out.println("Sorted names in ascending order:");
        for (String name : names) {
            System.out.println(name);
        }

        scanner.close();
    }
}
