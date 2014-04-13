package com.example.kostkadogry;

import java.util.Random;

/**
 * 
 * @author Szymon Sieciński
 * Klasa implementująca mechanizm kostki do gry
 *
 */
public class Kostka {
	
	/**
	 * 
	 * @author Szymon Sieciński
	 * Typ wyliczeniowy implementujący rodzaj kostki do gry.
	 * Możliwe wartości: K3, K4, K5, K6, K7, K8, K10, 
	 */
	public static enum RodzajKostki {
		K3(3), K4(4), K5(5), K6(6), K7(7), K8(8), K10(10), 
		K12(12), K14(14), K16(16), K20(20), K24(24), K30(30), K48(48);
		
		private int value;
		
		/**
		 * Konstruktor tworzący obiekt klasy RodzajKostki
		 * @param value	liczba ścian kostki
		 */
		private RodzajKostki(int value)
		{
			this.value = value;
		}
		
		/**
		 * Funkcja zwracająca liczbę ścian kostki do gry danego rodzaju.
		 * @return Liczba ścian kostki
		 */
		public int getValue()
		{
			return value;
		}
	}
	/* Pola */
	private int liczba;
	private Random losowaLiczba;
	private RodzajKostki rodzaj;
	
	/**
	 * Tworzy obiekt klasy Kostka o domyślnych parametrach (6-ścienna kostka do gry)
	 * i losowej liczbie z rozkładu jednostajnego.
	 */
	public Kostka()
	{
		rodzaj = RodzajKostki.K6;
		losowaLiczba = new Random();
	}
	
	/**
	 * Tworzy obiekt klasy Kostka o danym rodzaju
	 * @param rodzaj	Rodzaj kostki do gry (liczba ścian kostki)
	 */
	public Kostka(RodzajKostki rodzaj)
	{
		this.rodzaj = rodzaj;
		losowaLiczba = new Random();
	}
	
	/**
	 * Losuje liczbę na kostce do gry z zakresu 1 ÷ N, gdzie N to liczba ścian.
	 * Wyjątkiem jest kostka K10, dla której wylosowane zostaną liczby z zakresu 0 ÷ N-1
	 */
	public void losujLiczbe()
	{
		if(rodzaj.getValue()!=10)
			liczba = 1 + losowaLiczba.nextInt(rodzaj.getValue());
		else
			liczba = losowaLiczba.nextInt(rodzaj.getValue());
	}
	
	/**
	 * Funkcja zwraca wylosowaną liczbę.
	 * @return	Wylosowana liczba.
	 */
	public int getLiczba()
	{
		return liczba;
	}
	
	/**
	 * Funkcja zwraca zakres liczb, które mogą zostać wylosowane.
	 * @return Zakres liczb
	 */
	public int[] getZakres()
	{
		int[] zakres;
		if(rodzaj.getValue()!=10)
			zakres = new int[] {1,rodzaj.getValue()};
		else
			zakres = new int[] {0,rodzaj.getValue()-1};
		
		return zakres;
	}
	
	/**
	 * Funkcja zwraca aktualny rodzaj kostki
	 * @return rodzaj kostki
	 */
	public RodzajKostki getRodzajKostki()
	{
		return rodzaj;
	}
	
	/**
	 * Funkcja służy do zmiany aktualnego rodzaju kostki.
	 * @param k	Rodzaj kostki
	 */
	public void setRodzajKostki(RodzajKostki k)
	{
		this.rodzaj = k;
		losowaLiczba = new Random();
	}
}
