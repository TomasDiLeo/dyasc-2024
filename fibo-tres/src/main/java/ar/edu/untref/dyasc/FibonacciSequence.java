package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence {
	public List<Integer> fibonacciSequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		if (n <= 0)
			throw new IllegalArgumentException("The argument must be a positive integer");

		int a = 0;
		int b = 1;

		int aux;
		for (int i = 0; i < n; i++) {
			sequence.add(a);
			aux = a + b;
			a = b;
			b = aux;
		}

		return sequence;
	}
}