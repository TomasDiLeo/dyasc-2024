package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

import java.math.BigInteger;

public class FibonacciSequence {
	public List<BigInteger> fibonacciSequence(int n) {
		List<BigInteger> sequence = new ArrayList<BigInteger>();
		if (n <= 0)
			throw new IllegalArgumentException("The argument must be a positive integer");

		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;

		BigInteger aux;
		for (int i = 0; i < n; i++) {
			sequence.add(a);
			aux = a.add(b);
			a = b;
			b = aux;
		}

		return sequence;
	}
}
