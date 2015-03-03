package zad1;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
	private static Calculator calculator;
	
	@BeforeClass
	public static void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void addTest() {
		assertEquals(10, calculator.add(3, 7));
	}
	
	@Test
	public void subTest() {
		assertEquals(-3, calculator.sub(1, 4));
	}
	
	@Test
	public void multiTest() {
		assertEquals(16, calculator.multi(2, 8));
	}
	
	@Test
	public void divTest() {
		assertEquals(4, calculator.div(16, 4));
	}
	
	@Test(expected= ArithmeticException.class)
	public void divideByZeroTest() {
		calculator.div(5, 0);
	}
	
	
	@Test
	public void greaterTest() {
		assertEquals(true, calculator.greater(16, 4));
		assertEquals(false, calculator.greater(3, 5));
		assertEquals(false, calculator.greater(5, 5));
	}
}
