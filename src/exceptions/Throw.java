package exceptions;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Throw {

    public static void method1(int i) throws InputMismatchException {
        if (i < 0)
            throw new InputMismatchException("must not be negative");
    }
    public static void main(String[] args) throws Exception {

        try {
            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(".\\files\\badData.txt"));
                System.out.println("Reading number from file");
                int res = scanner.nextInt();
                System.out.println("number is " + res);
            }
            finally {
                if (scanner != null)
                    scanner.close();
                System.out.println("Scanner closed");
            }
        }
        catch (InputMismatchException ex) {
            System.out.println("This is not a correct number");
            throw ex;
        }
        catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }
}