package ar.edu.untref.dyasc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FibonacciSequenceTest {
	
	private FibonacciSequence fibo;
	
	@BeforeEach
	public void setUp() {
		fibo = new FibonacciSequence();
	}
		
	@Test
	public void fibo_n10() {
		List<Integer> sequence = fibo.fibonacciSequence(10);
		assertEquals(10, sequence.size(), "The size of the array should be 10");
		assertEquals(0,(int) sequence.get(0), "First in the sequence is 0");
		assertEquals(1,(int) sequence.get(1), "Second in the sequence is 1");
		assertEquals(1,(int) sequence.get(2), "Third in the sequence is 1");
		assertEquals(2,(int) sequence.get(3), "Fourth in the sequence is 2");
		assertEquals(3,(int) sequence.get(4), "Fifth in the sequence is 3");
		assertEquals(5,(int) sequence.get(5), "Sixth in the sequence is 5");
		assertEquals(8,(int) sequence.get(6), "Seventh in the sequence is 8");
		assertEquals(13,(int) sequence.get(7), "Eighth in the sequence is 13");
		assertEquals(21,(int) sequence.get(8), "Ninth in the sequence is 21");
		assertEquals(34,(int) sequence.get(9), "Tenth in the sequence is 34");
	}

}
