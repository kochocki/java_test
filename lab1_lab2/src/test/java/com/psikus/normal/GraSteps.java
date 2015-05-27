package com.psikus.normal;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import com.psikus.normal.*;

public class GraSteps {
	private Gra gra;
	private Integer number;
	
	@Given("Game")
	public void setUp() {
		gra = new Gra();
	}
	
	@When("set number to $number")
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	@Then("cyfrokrad returns null")
	public void cyfrokradReturnsNull() {
		assertNull(gra.cyfrokrad(number));
	}
	
	@Then("cyfrokrad returns either $number1 or $number2")
	public void cyfrokradTest(Integer number1, Integer number2) {
		assertThat(gra.cyfrokrad(number), either(is(number1)).or(is(number2)));
	}
	
	@Then("nieksztaltek returns either $number1 or $number2")
	public void nieksztaltekTest(Integer number1, Integer number2) {
		assertThat(gra.nieksztaltek(number), either(is(number1)).or(is(number2)));
	}
	
	@Then("hultajchochla throws NieduanyPsikusException")
	public void hultajchochlaThrowsNieudanyPsikusException() {
		try {
			gra.hultajchochla(number);
			Assert.fail();
		} catch (NieudanyPsikusException e) {
			Assert.assertTrue(true);
		}
	}
	
	@Then("hultajchochla returns either $number1 or $number2 or $number3")
	public void hultajchochlaTest(Integer number1, Integer number2, Integer number3) throws NieudanyPsikusException {
		assertThat(gra.hultajchochla(number), either(is(number1)).or(is(number2)).or(is(number3)));
	}

	
	
//	@Then("hultajchochla throws NieudanyPsikusException")
	
}
