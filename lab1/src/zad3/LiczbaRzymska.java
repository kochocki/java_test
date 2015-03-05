package zad3;

public class LiczbaRzymska {
	private int liczba;

	public LiczbaRzymska(int liczba) {
		this.liczba = liczba;
	}

	public String toString() {
		String rzymskie = "";
		if (liczba <= 0 || liczba > 3999)
			throw new IllegalArgumentException("");
		else {
			while (liczba > 0) {
				if (liczba - 1000 >= 0) {
					rzymskie += "M";
					liczba -= 1000;
					continue;
				}
				
				if (liczba - 900 >= 0) {
					rzymskie += "CM";
					liczba -= 900;
					continue;
				}
				
				if (liczba - 500 >= 0) {
					rzymskie += "D";
					liczba -= 500;
					continue;
				}
				
				if (liczba - 400 >= 0) {
					rzymskie += "CD";
					liczba -= 400;
					continue;
				}
				
				if (liczba - 100 >= 0) {
					rzymskie += "C";
					liczba -= 100;
					continue;
				}
				
				if (liczba - 90 >= 0) {
					rzymskie += "XC";
					liczba -= 90;
					continue;
				}
				
				if (liczba - 50 >= 0) {
					rzymskie += "L";
					liczba -= 50;
					continue;
				}
				
				if (liczba - 40 >= 0) {
					rzymskie += "XL";
					liczba -= 40;
					continue;
				}
				
				if (liczba - 10 >= 0) {
					rzymskie += "X";
					liczba -= 10;
					continue;
				}
				
				if (liczba - 9 >= 0) {
					rzymskie += "IX";
					liczba -= 40;
					continue;
				}
				
				if (liczba - 5 >= 0) {
					rzymskie += "V";
					liczba -= 5;
					continue;
				}
				
				if (liczba - 4 >= 0) {
					rzymskie += "IV";
					liczba -= 4;
					continue;
				}
				
				if (liczba - 1 >= 0) {
					rzymskie += "I";
					liczba -= 1;
					continue;
				}
			}
		}
		return rzymskie;
	}
}
