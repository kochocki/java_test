package zad2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import zad2.Calculator;

public class CalculatorTest {
	private static Calculator calculator;
	
	@BeforeClass
	public static void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void addTest() {
		assertEquals(1.1, calculator.add(0.1, 1), 1e-15);
	}
	
	@Test
	public void subTest() {
		assertEquals(-5.56, calculator.sub(-0.9, 4.66), 1e-15);
	}
	
	@Test
	public void multiTest() {
		assertEquals(16, calculator.multi(2, 8), 1e-15);
	}
	
	@Test
	public void divTest() {
		assertEquals(4, calculator.div(16, 4), 1e-15);
	}
	
	@Test
	public void divideByZeroTest() {
		assertEquals(Double.POSITIVE_INFINITY, calculator.div(5.9, 0), 1e-15);
	}
	
	@Test
	public void greaterTest1() {
		assertTrue(calculator.greater(16.7, 16.4));
	}
	
	@Test
	public void greaterTest2() {
		assertFalse(calculator.greater(3.79, 3.8));
	}
}
