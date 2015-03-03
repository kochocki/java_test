package zad3;

import org.junit.Test;

import zad3.LiczbaRzymska;
import static org.junit.Assert.*;

public class LiczbaRzymskaTest {

	@Test
	public void test_1() {
		assertEquals("I", new LiczbaRzymska(1).toString());
	}

	@Test
	public void test_10() {
		assertEquals("X", new LiczbaRzymska(10).toString());
	}

	@Test
	public void test_20() {
		assertEquals("XX", new LiczbaRzymska(20).toString());
	}

	@Test
	public void test_4() {
		assertEquals("IV", new LiczbaRzymska(4).toString());
	}

	@Test
	public void test_3999() {
		assertEquals("MMMCMXCIX", new LiczbaRzymska(3999).toString());
	}

	@Test
	public void test_44() {
		assertEquals("XLIV", new LiczbaRzymska(44).toString());
	}

	@Test
	public void test_444() {
		assertEquals("CDXLIV", new LiczbaRzymska(444).toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_minus_10() {
		new LiczbaRzymska(-10).toString();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_0() {
		new LiczbaRzymska(0).toString();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_4000() {
		new LiczbaRzymska(4000).toString();
	}
	
}
