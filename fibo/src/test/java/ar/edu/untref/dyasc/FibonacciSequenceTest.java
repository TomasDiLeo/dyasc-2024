package ar.edu.untref.dyasc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;


class FibonacciSequenceTest {

	private FibonacciSequence fibo;

	@BeforeEach
	public void setUp() {
		fibo = new FibonacciSequence();
	}
	
	@Test
	public void fibo_n5() {
		List<BigInteger> sequence = fibo.fibonacciSequence(5);
		assertEquals(5, sequence.size(), "The size of the array should be 5");
		assertEquals(BigInteger.valueOf(0), sequence.get(0), "First in the sequence is 0");
		assertEquals(BigInteger.valueOf(1), sequence.get(1), "Second in the sequence is 1");
		assertEquals(BigInteger.valueOf(1), sequence.get(2), "Third in the sequence is 1");
		assertEquals(BigInteger.valueOf(2), sequence.get(3), "Fourth in the sequence is 2");
		assertEquals(BigInteger.valueOf(3), sequence.get(4), "Fifth in the sequence is 3");
	}

	@Test
	public void fibo_n10() {
		List<BigInteger> sequence = fibo.fibonacciSequence(10);
		assertEquals(10, sequence.size(), "The size of the array should be 10");
		assertEquals(BigInteger.valueOf(0), sequence.get(0), "First in the sequence is 0");
		assertEquals(BigInteger.valueOf(1), sequence.get(1), "Second in the sequence is 1");
		assertEquals(BigInteger.valueOf(1), sequence.get(2), "Third in the sequence is 1");
		assertEquals(BigInteger.valueOf(2), sequence.get(3), "Fourth in the sequence is 2");
		assertEquals(BigInteger.valueOf(3), sequence.get(4), "Fifth in the sequence is 3");
		assertEquals(BigInteger.valueOf(5), sequence.get(5), "Sixth in the sequence is 5");
		assertEquals(BigInteger.valueOf(8), sequence.get(6), "Seventh in the sequence is 8");
		assertEquals(BigInteger.valueOf(13), sequence.get(7), "Eighth in the sequence is 13");
		assertEquals(BigInteger.valueOf(21), sequence.get(8), "Ninth in the sequence is 21");
		assertEquals(BigInteger.valueOf(34), sequence.get(9), "Tenth in the sequence is 34");
	}
	
	@Test
    public void fibo_n0() {
        assertThrows(IllegalArgumentException.class, () -> fibo.fibonacciSequence(0));
    }

    @Test
    public void fibo_negative() {
    	assertThrows(IllegalArgumentException.class, () -> fibo.fibonacciSequence(-5));
    }
    
    @Test
	public void fibo_nBIG() {
		List<BigInteger> sequence = fibo.fibonacciSequence(47);
		assertEquals(47, sequence.size(), "The size of the array should be 47");
		assertEquals(BigInteger.valueOf(1836311903), sequence.get(46), "n47 in the sequence is 1836311903");
	}
    
    @Test
	public void fibo_nSUPER_BIG() {
		List<BigInteger> sequence = fibo.fibonacciSequence(100);
		assertEquals(100, sequence.size(), "The size of the array should be 100");
		assertEquals(new BigInteger("218922995834555169026"), sequence.get(99), "n99 in the sequence is 218922995834555169026");
	}
    

}
