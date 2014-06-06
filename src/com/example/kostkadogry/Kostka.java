package com.example.kostkadogry;

import java.util.Random;

/**
 * Klasa implementująca mechanizm kostki do gry
 * @author Szymon Sieciński
 */
public class Kostka {
	
	/**
	 * Typ wyliczeniowy implementujący rodzaj kostki do gry.
	 * Możliwe wartości: K3, K4, K5, K6, K7, K8, K10, K12, K14,
	 * K16, K20, K24, K30, K48.
	 * @author Szymon Sieciński
	 */
	public static enum RodzajKostki {
		
		/**
		 * Kostka 3-ścienna.
		 */
		K3(3),
		
		/** 
		 * Kostka 4-ścienna. Wartości liczbowe
		 * umieszczone w~wierzchołku kości.
		 */
		K4(4),
		
		/**
		 * Kostka 5-ścienna. Podstawy zawierają wartości 1 i 5.
		 */
		K5(5),
		
		/** 
		 * Kostka sześcienna (domyślna).
		 */
		K6(6),
		
		/**
		 * Kostka 7-ścienna. Podstawy zawierają wartości 6 i 7.
		 */
		K7(7),
		
		/**
		 * Kostka 8-ścienna.
		 */
		K8(8),
		
		/**
		 * Kostka 10-ścienna. Zawiera wartości od 0 do 9.
		 */
		K10(10), 
		
		/**
		 * Kostka 12-ścienna.
		 */
		K12(12),
		
		/**
		 * Kostka 14-ścienna.
		 */
		K14(14),
		
		/**
		 * Kostka 14-ścienna.
		 */
		K16(16),
		
		/**
		 * Kostka 16-ścienna.
		 */
		K20(20),
		
		/**
		 * Kostka 24-ścienna.
		 */
		K24(24),
		
		/**
		 * Kostka 30-ścienna.
		 */
		K30(30),
		
		/**
		 * Kostka 48-ścienna.
		 */
		K48(48);
		
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
