package averageCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RandomNumberSource implements INumberSource {
    // List<Integer> numbers = new ArrayList<>();
    Stack<Integer> numbers = new Stack<>();

    public RandomNumberSource(int sizeOfNumbers){
        for (int i = 0; i < sizeOfNumbers; i++) {
            numbers.push((int)(100 * Math.random()));
        }
    }

    @Override
    public boolean hasMoreNumbers() {
        return !numbers.isEmpty();
    }

    @Override
    public int nextNumber() {
        return numbers.pop();
    }
}
