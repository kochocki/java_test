package lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gra implements Psikus {

	private Random generator = new Random();
	boolean ujemna;

	void czyUjemna(int liczba) {
		if (liczba < 0)
			ujemna = true;
		else
			ujemna = false;
	}

	@Override
	public Integer cyfrokrad(Integer liczba) {
		if (liczba > -10 && liczba < 10)
			return null;
		else {
			czyUjemna(liczba);
			if (ujemna)
				liczba = -liczba;
			String liczba_string = liczba.toString();


			StringBuilder sb = new StringBuilder(liczba_string);
			int pozycja = generator.nextInt(liczba_string.length());


			sb.deleteCharAt(pozycja);
			int nowa_liczba = Integer.parseInt(sb.toString());
			if (ujemna)
				nowa_liczba = -nowa_liczba;
			return nowa_liczba;
		}
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		if (liczba > -10 && liczba < 10)
			throw new NieudanyPsikusException();
		else {
			czyUjemna(liczba);
			if (ujemna)
				liczba = -liczba;
			String liczba_string = liczba.toString();
			StringBuilder sb = new StringBuilder(liczba_string);
			int pozycja1 = generator.nextInt(liczba_string.length());
			int pozycja2;
			do
				pozycja2 = generator.nextInt(liczba_string.length());
			while (pozycja2 == pozycja1);
			char litera1 = sb.charAt(pozycja1);
			char litera2 = sb.charAt(pozycja2);
			sb.deleteCharAt(pozycja2);
			sb.insert(pozycja2, litera1);
			sb.deleteCharAt(pozycja1);
			sb.insert(pozycja1, litera2);
			Integer nowa_liczba = Integer.parseInt(sb.toString());
			if (ujemna)
				nowa_liczba = -nowa_liczba;
			return nowa_liczba;
		}
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		czyUjemna(liczba);
		if (ujemna)
			liczba = -liczba;
		List<Integer> pozycje = new ArrayList<Integer>();
		String liczba_string = liczba.toString();
		StringBuilder sb = new StringBuilder(liczba_string);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '3' || sb.charAt(i) == '7'
					|| sb.charAt(i) == '6')
				pozycje.add(i);
		}

		if (pozycje.size() == 0)
			if (ujemna)
				return -Integer.parseInt(sb.toString());
			else
				return Integer.parseInt(sb.toString());
		else {
			int pozycja = generator.nextInt(pozycje.size());
			if (sb.charAt(pozycje.get(pozycja)) == '3')
				sb.setCharAt((pozycje.get(pozycja)), '8');
			else if (sb.charAt(pozycje.get(pozycja)) == '7')
				sb.setCharAt((pozycje.get(pozycja)), '1');
			else if (sb.charAt(pozycje.get(pozycja)) == '6')
				sb.setCharAt((pozycje.get(pozycja)), '9');
			Integer nowa_liczba = Integer.parseInt(sb.toString());
			if (ujemna)
				nowa_liczba = -nowa_liczba;
			return nowa_liczba;
		}
	}
}
