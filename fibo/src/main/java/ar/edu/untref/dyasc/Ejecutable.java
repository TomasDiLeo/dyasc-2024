package ar.edu.untref.dyasc;

import java.util.List;
import java.math.BigInteger;

public class Ejecutable {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Error: Exactly one argument is required.");
			System.err.println("Usage: java -jar fibo.jar <n>");
			System.exit(1);
		}
		FibonacciSequence fibo = new FibonacciSequence();

		try {
			int n = Integer.parseInt(args[0]);
			List<BigInteger> sequence = fibo.fibonacciSequence(n);
			System.out.println("fibo <" + n + ">: " + sequence.toString());
		} catch (NumberFormatException e) {
			System.err.println("Error: Argument must be an integer.");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}
}
