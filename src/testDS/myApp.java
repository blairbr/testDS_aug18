package testDS;
import java.util.Scanner;
import java.util.Stack;

public class myApp {

	public static void main(String[] args) {

		// Create an application that will take in integers & arithmetic
		// operators and act as a calculator

		String choice = "yes";
		Stack<Integer> s = new Stack<Integer>();
		Scanner scan1 = new Scanner(System.in);

		while (choice.equalsIgnoreCase("yes")) {
			try {
				System.out.println("Enter an operation: ");
				String userInput = scan1.next();
				char c;

				for (int i = 0; i < userInput.length(); i++) {
					c = userInput.charAt(i);

					// pop two numbers
					// do the operation
					// push the result back to the stack

					int x;
					int y;
					int result;

					switch (c) {
					case '*':
						x = s.pop();
						y = s.pop();
						result = x * y;
						s.push(result);
						break;

					case '/':
						x = s.pop();
						y = s.pop();
						try {
							result = y / x;
							s.push(result);
						} catch (ArithmeticException e) {
							System.out.println("Cannot divide by zero.");
						}
						break;

					case '+':
						x = s.pop();
						y = s.pop();
						result = x + y;
						s.push(result);
						break;

					case '-':
						x = s.pop();
						y = s.pop();
						result = y - x;
						s.push(result);
						break;

					default:  			//default case if char c is a number
						int d = Character.getNumericValue(c);
						if (d >= 0 && d <= 9) {
							// push to stack
							s.push(d);
						}
					}
				}
				try {
					System.out.println(s.pop());
				} catch (Exception e) {
					System.out.println("Invalid input.");
				}

			} finally {
				scan1.nextLine();
				System.out.println("Would you like to continue? (yes or no)");
				choice = scan1.nextLine();
			}
		}
		System.out.println("Goodbye.");
	}
}
