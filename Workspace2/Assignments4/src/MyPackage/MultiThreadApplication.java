package MyPackage;

import java.util.Random;

public class MultiThreadApplication {

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        NumberProcessor processor = new NumberProcessor(generator);

        Thread thread1 = new Thread(generator);
        Thread thread2 = new Thread(processor);
        Thread thread3 = new Thread(processor);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RandomNumberGenerator implements Runnable {
    private Random random = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                int randomNumber = random.nextInt(100); // Generate random number between 0 and 99
                System.out.println("Generated Number: " + randomNumber);

                if (randomNumber % 2 == 0) {
                    synchronized (NumberProcessor.class) {
                        NumberProcessor.setSquare(randomNumber * randomNumber);
                        NumberProcessor.class.notify(); // Notify waiting thread
                    }
                } else {
                    synchronized (NumberProcessor.class) {
                        NumberProcessor.setCube(randomNumber * randomNumber * randomNumber);
                        NumberProcessor.class.notify(); // Notify waiting thread
                    }
                }

                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class NumberProcessor implements Runnable {
    private static int square;
    private static int cube;
    private RandomNumberGenerator generator;

    public NumberProcessor(RandomNumberGenerator generator) {
        this.generator = generator;
    }

    public static synchronized void setSquare(int square) {
        NumberProcessor.square = square;
    }

    public static synchronized void setCube(int cube) {
        NumberProcessor.cube = cube;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (NumberProcessor.class) {
                    NumberProcessor.class.wait(); // Wait for notification
                }

                if (square != 0) {
                    System.out.println("Square of Even Number: " + square);
                    square = 0; // Reset square after processing
                } else if (cube != 0) {
                    System.out.println("Cube of Odd Number: " + cube);
                    cube = 0; // Reset cube after processing
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
