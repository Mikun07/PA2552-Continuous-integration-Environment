import java.util.Scanner;

public class simpleCalculator {
    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        // Prompt user to enter an operator (+, -, *, /)
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        // Prompt user to enter the second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        // Perform the calculation and display the result
        try {
            double result = calculate(num1, num2, operator);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        // Close the scanner to prevent resource leak
        scanner.close();
    }

    /**
     * Performs the calculation based on the provided numbers and operator.
     *
     * @param num1 First number
     * @param num2 Second number
     * @param operator Mathematical operator (+, -, *, /)
     * @return The result of the operation
     * @throws IllegalArgumentException if an invalid operator is provided or division by zero occurs
     */
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2; // Addition
            case '-':
                return num1 - num2; // Subtraction
            case '*':
                return num1 * num2; // Multiplication
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Error! Division by zero.");
                }
                return num1 / num2; // Division
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
    }
}