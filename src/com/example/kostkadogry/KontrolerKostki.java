package com.example.kostkadogry;

/**
 * Zapewnia wizualizację wyników rzutu kostką, której zachowanie zostało zdefiniowane w klasie Kostka.
 * @see Kostka
 * @author Szymon Sieciński
 */
public class KontrolerKostki extends Kostka {
	
	/**
	 * Tworzy obiekt klasy KontrolerKostka z domyślnymi parametrami (kostka 6-ścienna).
	 * @see Kostka()
	 */
	public KontrolerKostki() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Tworzy obiekt klasy Kostka o danym rodzaju.
	 * @param rodzaj	Rodzaj kostki (liczba ścian kostki)
	 * @see Kostka(RodzajKostki rodzaj)
	 * @see RodzajKostki
	 */
	public KontrolerKostki(RodzajKostki rodzaj) {
		super(rodzaj);
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości.
	 * @return ID obrazu
	 */
	public int getIdObrazu() {
		int rodzaj = this.getRodzajKostki().getValue();
		int liczba = this.getLiczba();

		switch (rodzaj) {
		case 3:
			return R.drawable.prostokat;
		case 4:
			return kosciK4(liczba);
		case 5:
			if (this.getLiczba() == 1 || this.getLiczba() == 5)
				return R.drawable.pieciokat;
			else
				return R.drawable.kwadrat;
		case 6:
		default:
			return kosciK6(liczba);
		case 7:
			if (this.getLiczba() == 6 || this.getLiczba() == 7)
				return R.drawable.pieciokat;
			else
				return kosciK6(liczba);
		case 8:
			return R.drawable.trojkat;
		case 10:
			return R.drawable.latawiec;
		case 12:
			return R.drawable.pieciokat;
		case 14:
			return R.drawable.trojkat;
		case 16:
			return R.drawable.trojkat;
		case 20:
			return R.drawable.trojkat;
		case 24:
			return R.drawable.trojkat;
		case 30:
			return R.drawable.romb;
		case 48:
			return R.drawable.trojkat2;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K4.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK4(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k4_1;
		case 2:
			return R.drawable.k4_2;
		case 3:
			return R.drawable.k4_3;
		case 4:
			return R.drawable.k4_4;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K6.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK6(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k6_1;
		case 2:
			return R.drawable.k6_2;
		case 3:
			return R.drawable.k6_3;
		case 4:
			return R.drawable.k6_4;
		case 5:
			return R.drawable.k6_5;
		case 6:
			return R.drawable.k6_6;
		}
	}
	
}
