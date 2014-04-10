package com.example.kostkadogry;

import java.util.Random;

public class Kostka {
	
	public static enum RodzajKostki {
		K3(3), K4(4), K5(5), K6(6), K7(7), K8(8), K10(10), 
		K12(12), K14(14), K16(16), K20(20), K24(24), K30(30), K48(48);
		
		private int value;
		
		private RodzajKostki(int value)
		{
			this.value = value;
		}
		
		public int getValue()
		{
			return value;
		}
	}
	/* Pola */
	private int liczba;
	private Random losowaLiczba;
	private RodzajKostki rodzaj;
	
	public Kostka()
	{
		rodzaj = RodzajKostki.K6;
		losowaLiczba = new Random();
	}
	
	public Kostka(RodzajKostki rodzaj)
	{
		this.rodzaj = rodzaj;
		losowaLiczba = new Random();
	}
	
	public void losujLiczbe()
	{
		if(rodzaj.getValue()!=10)
			liczba = 1 + losowaLiczba.nextInt(rodzaj.getValue());
		else
			liczba = losowaLiczba.nextInt(rodzaj.getValue());
	}
	
	public int getLiczba()
	{
		return liczba;
	}
	
	public int[] getZakres()
	{
		int[] zakres;
		if(rodzaj.getValue()!=10)
			zakres = new int[] {1,rodzaj.getValue()};
		else
			zakres = new int[] {0,rodzaj.getValue()-1};
		
		return zakres;
	}
	
	public RodzajKostki getRodzajKostki()
	{
		return rodzaj;
	}
	
	public void setRodzajKostki(RodzajKostki k)
	{
		this.rodzaj = k;
		losowaLiczba = new Random();
	}
}
