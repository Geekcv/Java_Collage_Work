package Mypackage;

import java.util.Scanner;

public class RecursiveAndNonRecursive {

    // Non-recursive (iterative) function to compute factorial
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive function to compute factorial
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }
  

    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Factorial computation
        System.out.print("Enter a number to compute its factorial: ");
        int number = scanner.nextInt();
        
        System.out.println("Factorial (Iterative) of " + number + " is: " + factorialIterative(number));
        System.out.println("Factorial (Recursive) of " + number + " is: " + factorialRecursive(number));
        
        
        scanner.close();
    }
}
