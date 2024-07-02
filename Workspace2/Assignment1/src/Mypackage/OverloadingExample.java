package Mypackage;

public class OverloadingExample {

    // Constructor overloading

    // Default constructor
    public OverloadingExample() {
        System.out.println("Default constructor called");
    }

    // Constructor with one parameter
    public OverloadingExample(int a) {
        System.out.println("Constructor with one parameter called, value: " + a);
    }

    // Constructor with two parameters
    public OverloadingExample(int a, int b) {
        System.out.println("Constructor with two parameters called, values: " + a + ", " + b);
    }

    // Method overloading

    // Method with no parameters
    public void display() {
        System.out.println("Display method with no parameters called");
    }

    // Method with one int parameter
    public void display(int a) {
        System.out.println("Display method with one int parameter called, value: " + a);
    }

    // Method with one String parameter
    public void display(String message) {
        System.out.println("Display method with one String parameter called, message: " + message);
    }

    // Method with two parameters
    public void display(int a, String message) {
        System.out.println("Display method with two parameters called, value: " + a + ", message: " + message);
    }

    public static void main(String[] args) {
        // Constructor overloading
        OverloadingExample obj1 = new OverloadingExample();
        OverloadingExample obj2 = new OverloadingExample(10);
        OverloadingExample obj3 = new OverloadingExample(10, 20);

        // Method overloading
        obj1.display();
        obj1.display(30);
        obj1.display("Hello, World!");
        obj1.display(40, "Method Overloading Example");
    }
}
