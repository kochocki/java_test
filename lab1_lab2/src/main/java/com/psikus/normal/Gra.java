package com.psikus.normal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gra implements Psikus {

	private Random generator = new Random();
	boolean negative;

	void ifNegative(int number) {
		if (number < 0)
			negative = true;
		else
			negative = false;
	}

	public Integer cyfrokrad(Integer number) {
		if (number > -10 && number < 10)
			return null;
		else {
			ifNegative(number);
			if (negative)
				number = -number;
			String numberString = number.toString();
			StringBuilder sb = new StringBuilder(numberString);
			int position = generator.nextInt(numberString.length());
			sb.deleteCharAt(position);
			int newNumber = Integer.parseInt(sb.toString());
			if (negative)
				newNumber = -newNumber;
			return newNumber;
		}
	}

	public Integer hultajchochla(Integer number) throws NieudanyPsikusException {
		if (number > -10 && number < 10)
			throw new NieudanyPsikusException();
		else {
			ifNegative(number);
			if (negative)
				number = -number;
			String numberString = number.toString();
			StringBuilder sb = new StringBuilder(numberString);
			int position1 = generator.nextInt(numberString.length());
			int position2;
			do
				position2 = generator.nextInt(numberString.length());
			while (position2 == position1);
			char character1 = sb.charAt(position1);
			char character2 = sb.charAt(position2);
			sb.setCharAt(position2, character1);
			sb.setCharAt(position1, character2);
			Integer newNumber = Integer.parseInt(sb.toString());
			if (negative)
				newNumber = -newNumber;
			return newNumber;
		}
	}

	public Integer nieksztaltek(Integer number) {
		ifNegative(number);
		if (negative)
			number = -number;
		List<Integer> positions = new ArrayList<Integer>();
		String numberString = number.toString();
		StringBuilder sb = new StringBuilder(numberString);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '3' || sb.charAt(i) == '7'
					|| sb.charAt(i) == '6')
				positions.add(i);
		}
		if (positions.size() == 0)
			if (negative)
				return -Integer.parseInt(sb.toString());
			else
				return Integer.parseInt(sb.toString());
		else {
			int position = generator.nextInt(positions.size());
			if (sb.charAt(positions.get(position)) == '3')
				sb.setCharAt((positions.get(position)), '8');
			else if (sb.charAt(positions.get(position)) == '7')
				sb.setCharAt((positions.get(position)), '1');
			else if (sb.charAt(positions.get(position)) == '6')
				sb.setCharAt((positions.get(position)), '9');
			Integer newNumber = Integer.parseInt(sb.toString());
			if (negative)
				newNumber = -newNumber;
			return newNumber;
		}
	}
}
