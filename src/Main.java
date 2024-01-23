import java.util.InputMismatchException;
import java.util.Scanner;

class UserInterface {
    public static void showMenu() {
        System.out.println("\nSimple Calculator Menu:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    public static int getUserChoice() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Your choice: ");
                choice = scanner.nextInt();

                if (choice >= 1 && choice <= 5) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static void options() {
        System.out.print("\nWould you like to try again?");
        System.out.print("\n1 - Yes\n2 - No");

        System.out.print("\nEnter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();

        if (c == 1) {
        } else if (c == 2) {
            exit();
        } else {
            System.out.println("This is not a valid number. Exiting the program.");
            exit();
        }
    }

    public static void exit() {
        System.out.println("Exiting the program. Goodbye!");
        System.exit(0);
    }
}

interface Operation {
    void execute(int a, int b);
}

class AdditionOperation implements Operation {
    public void execute(int a, int b) {
        System.out.println("\nResult (Addition): " + (a + b));
    }
}

class SubtractionOperation implements Operation {
    public void execute(int a, int b) {
        System.out.println("\nResult (Subtraction): " + (a - b));
    }
}

class MultiplicationOperation implements Operation {
    public void execute(int a, int b) {
        System.out.println("\nResult (Multiplication): " + (a * b));
    }
}

class DivisionOperation implements Operation {
    public void execute(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero. Please enter a non-zero divisor.");
        } else {
            System.out.println("\nResult (Division): " + (a / b));
        }
    }
}

class CalculatorEngine {
    private int operation;

    public void runCalculator() {

        while (true) {
            UserInterface.showMenu();
            operation = UserInterface.getUserChoice();

            if (operation == 5) {
                UserInterface.exit();
            }

            try {
                System.out.println("\nPlease enter two whole numbers!");
                System.out.print("First number: ");
                int a = new Scanner(System.in).nextInt();

                System.out.print("Second number: ");
                int b = new Scanner(System.in).nextInt();

                switch (operation) {
                    case 1:
                        new AdditionOperation().execute(a, b);
                        break;
                    case 2:
                        new SubtractionOperation().execute(a, b);
                        break;
                    case 3:
                        new MultiplicationOperation().execute(a, b);
                        break;
                    case 4:
                        new DivisionOperation().execute(a, b);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }

                UserInterface.options();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid whole numbers.");
            }
        }
    }
}

