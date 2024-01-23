import java.util.InputMismatchException;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorEngine calculatorEngine = new CalculatorEngine();

        try {
            calculatorEngine.runCalculator();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Exiting the program.");
        }
    }
}
