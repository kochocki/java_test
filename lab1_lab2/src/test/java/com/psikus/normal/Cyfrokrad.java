package com.psikus.normal;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Cyfrokrad {
	private static Gra gra;

	@BeforeClass
	public static void setUp() {
		gra = new Gra();
	}

	@Test
	public void cyfrokradTest1() {
		assertNull(gra.cyfrokrad(1));
	}

	@Test
	public void cyfrokradTest2() {
		assertNull(gra.cyfrokrad(0));
	}

	@Test
	public void cyfrokradTest3() {
		assertNull(gra.cyfrokrad(-1));
	}

	@Test
	public void cyfrokradTest4() {
		assertNull(gra.cyfrokrad(9));
	}

	@Test
	public void cyfrokradTest5() {
		assertNull(gra.cyfrokrad(-9));
	}

	@Test
	public void cyfrokradTest6() {
		assertThat(gra.cyfrokrad(10), either(is(1)).or(is(0)));
	}

	@Test
	public void cyfrokradTest7() {
		assertThat(gra.cyfrokrad(-10), either(is(-1)).or(is(0)));
	}

	@Test
	public void cyfrokradTest8() {
		assertEquals(3, gra.cyfrokrad(4556).toString().length());
	}

	@Test
	public void cyfrokradTest9() {
		assertEquals(1, gra.cyfrokrad(12).toString().length());
	}

	@Test
	public void cyfrokradTest10() {
		assertThat(gra.cyfrokrad(12), either(is(1)).or(is(2)));
	}

	@Test
	public void cyfrokradTest11() {
		assertThat(gra.cyfrokrad(-123), either(is(-12)).or(is(-23)).or(is(-13)));
	}
}
