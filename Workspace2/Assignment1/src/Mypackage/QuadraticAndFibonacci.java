package Mypackage;

import java.util.Scanner;

public class QuadraticAndFibonacci {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read coefficients a, b, c and constant D
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        System.out.print("Enter constant D: ");
        double D = scanner.nextDouble();

        // Calculate the quadratic equation ax^2 + bx + c = D
        double A = a;
        double B = b;
        double C = c - D;

        // Calculate the discriminant
        double discriminant = B * B - 4 * A * C;

        // Find the solutions based on the discriminant
        if (discriminant > 0) {
            double root1 = (-B + Math.sqrt(discriminant)) / (2 * A);
            double root2 = (-B - Math.sqrt(discriminant)) / (2 * A);
            System.out.println("Two real solutions: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -B / (2 * A);
            System.out.println("One real solution: " + root);
        } else {
            System.out.println("No real solutions.");
        }

        // Calculate the Fibonacci sequence
        System.out.print("Enter the number of Fibonacci sequence values to generate: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("The number of values should be a positive integer.");
        } else {
            System.out.println("Fibonacci sequence: ");
            long fib1 = 1, fib2 = 1;
            if (n >= 1) System.out.print(fib1 + " ");
            if (n >= 2) System.out.print(fib2 + " ");
            for (int i = 3; i <= n; i++) {
                long fib = fib1 + fib2;
                System.out.print(fib + " ");
                fib1 = fib2;
                fib2 = fib;
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
