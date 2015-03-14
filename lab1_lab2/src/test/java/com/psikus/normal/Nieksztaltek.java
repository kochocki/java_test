package com.psikus.normal;

import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

public class Nieksztaltek {
	private static Gra gra;

	@BeforeClass
	public static void setUp() {
		gra = new Gra();
	}

	@Test
	public void nieksztaltekTest1() {
		assertThat(gra.nieksztaltek(123), is(128));
	}

	@Test
	public void nieksztaltekTest2() {
		assertThat(gra.nieksztaltek(-123), is(-128));
	}

	@Test
	public void nieksztaltekTest3() {
		assertThat(gra.nieksztaltek(-137), either(is(-187)).or(is(-131)));
	}

	@Test
	public void nieksztaltekTest4() {
		assertThat(gra.nieksztaltek(-367), either(is(-867)).or(is(-397)).or(is(-361)));
	}
	
	@Test
	public void nieksztaltekTest5() {
		assertThat(gra.nieksztaltek(33), either(is(38)).or(is(83)));
	}
	
	@Test
	public void nieksztaltekTest6() {
		assertThat(gra.nieksztaltek(723), either(is(123)).or(is(728)));
	}
}
