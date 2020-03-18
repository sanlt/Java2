package averageCalculator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws InvalidNumberException, IOException {

        // INumberSource source = new RandomNumberSource(10);
        // INumberSource source = new StringNumberSource("7,5,8,11");

        BufferedReader in = new BufferedReader(new FileReader(".\\files\\goodData.txt"));
        List<Integer> numbers = new ArrayList<>();
        // String line;
        String[] input = in.readLine().split(",");

        for (String value : input) {
            if (!isParsable(value)){
                throw new InvalidNumberException();
            }
            numbers.add(Integer.parseInt(value));
        }

        /*while ((line = in.readLine()) != null) {
            numbers.add(line);
        }*/

        INumberSource source = new FileNumberSource(numbers);

        int sum = 0;
        int count = 0;

        while (source.hasMoreNumbers()) {
            sum += source.nextNumber();
            count++;
        }
        System.out.println("Average is " + (sum / count));
    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}