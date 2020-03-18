package averageCalculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FileNumberSource implements INumberSource {
    String resultRow = "";
    Queue<Integer> numbers = new LinkedList<>();

    public FileNumberSource(List<Integer> numbers){
        this.numbers.addAll(numbers);
    }

    @Override
    public boolean hasMoreNumbers() {
        return !numbers.isEmpty();
    }

    @Override
    public int nextNumber() throws InvalidNumberException {
        return numbers.poll();
    }



/*
    Scanner scanner;


    public FileNumberSource(List<String> numbers) throws InvalidNumberException {
        for (String number : numbers) {
            String res = String.join(",", numbers); // convert arraylist to a string
            scanner = new Scanner(res);
            scanner.useDelimiter(",");
        }
    }

    @Override
    public boolean hasMoreNumbers() {
        if (scanner.hasNext()) {
            return true;
        }
        return false;
    }

    @Override
    public int nextNumber() throws InvalidNumberException {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            throw new InvalidNumberException();
        }
    }*/
}
