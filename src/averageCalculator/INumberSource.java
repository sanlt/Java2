package averageCalculator;


public interface INumberSource {

    boolean hasMoreNumbers();

    int nextNumber() throws InvalidNumberException;

}
