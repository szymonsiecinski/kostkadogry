package com.example.kostkadogry;

/**
 * Zapewnia wizualizację wyników rzutu kostką, której zachowanie zostało zdefiniowane w klasie Kostka.
 * 
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
	
	/*public static int getIdStanuNieustalonego(RodzajKostki k) {
		int rodzaj = k.getValue();

		switch (rodzaj) {
		case 3:
			return R.drawable.k3_roll;
		case 4:
			return R.drawable.k4_roll;
		case 5:
			return R.drawable.k5_roll;
		case 6:
			return R.drawable.k6_roll;
		case 7:
			return R.drawable.k7_roll;
		case 8:
			return R.drawable.k8_roll;
		case 10:
			return R.drawable.k10_roll;
		case 12:
			return R.drawable.k12_roll;
		case 14:
			return R.drawable.k14_roll;
		case 16:
			return R.drawable.k16_roll;
		case 20:
			return R.drawable.k20_roll;
		case 24:
			return R.drawable.k24_roll;
		case 30:
			return R.drawable.k30_roll;
		case 48:
			return R.drawable.k48_roll;
		default:
			return R.drawable.k6_roll;
		}
	}*/
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości.
	 * @return ID obrazu
	 */
	public int getIdObrazu() {
		int rodzaj = this.getRodzajKostki().getValue();
		int liczba = this.getLiczba();

		switch (rodzaj) {
		case 3:
			return kosciK3(liczba);
		case 4:
			return kosciK4(liczba);
		case 5:
			return kosciK5(liczba);
		case 6:
			return kosciK6(liczba);
		case 7:
			return kosciK7(liczba);
		case 8:
			return kosciK8(liczba);
		case 10:
			return kosciK10(liczba);
		case 12:
			return kosciK12(liczba);
		case 14:
			return kosciK14(liczba);
		case 16:
			return kosciK16(liczba);
		case 20:
			return kosciK20(liczba);
		case 24:
			return kosciK24(liczba);
		case 30:
			return kosciK30(liczba);
		case 48:
			return kosciK48(liczba);
		default:
			return kosciK6(liczba);
		}
	}

	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K3.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK3(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k3_1;
		case 2:
			return R.drawable.k3_2;
		case 3:
			return R.drawable.k3_3;
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
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K5.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK5(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k5_1;
		case 2:
			return R.drawable.k5_2;
		case 3:
			return R.drawable.k5_3;
		case 4:
			return R.drawable.k5_4;
		case 5:
			return R.drawable.k5_5;
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
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K7.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK7(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k7_1;
		case 2:
			return R.drawable.k7_2;
		case 3:
			return R.drawable.k7_3;
		case 4:
			return R.drawable.k7_4;
		case 5:
			return R.drawable.k7_5;
		case 6:
			return R.drawable.k7_6;
		case 7:
			return R.drawable.k7_7;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K8.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK8(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k8_1;
		case 2:
			return R.drawable.k8_2;
		case 3:
			return R.drawable.k8_3;
		case 4:
			return R.drawable.k8_4;
		case 5:
			return R.drawable.k8_5;
		case 6:
			return R.drawable.k8_6;
		case 7:
			return R.drawable.k8_7;
		case 8:
			return R.drawable.k8_8;			
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K10.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK10(int wartosc) {
		switch (wartosc) {
		case 0:
		default:
			return R.drawable.k10_0;
		case 1:
			return R.drawable.k10_1;
		case 2:
			return R.drawable.k10_2;
		case 3:
			return R.drawable.k10_3;
		case 4:
			return R.drawable.k10_4;
		case 5:
			return R.drawable.k10_5;
		case 6:
			return R.drawable.k10_6;
		case 7:
			return R.drawable.k10_7;
		case 8:
			return R.drawable.k10_8;
		case 9:
			return R.drawable.k10_9;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K12.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK12(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k12_1;
		case 2:
			return R.drawable.k12_2;
		case 3:
			return R.drawable.k12_3;
		case 4:
			return R.drawable.k12_4;
		case 5:
			return R.drawable.k12_5;
		case 6:
			return R.drawable.k12_6;
		case 7:
			return R.drawable.k12_7;
		case 8:
			return R.drawable.k12_8;
		case 9:
			return R.drawable.k12_9;
		case 10:
			return R.drawable.k12_10;
		case 11:
			return R.drawable.k12_11;
		case 12:
			return R.drawable.k12_12;	
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K14.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK14(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k14_1;
		case 2:
			return R.drawable.k14_2;
		case 3:
			return R.drawable.k14_3;
		case 4:
			return R.drawable.k14_4;
		case 5:
			return R.drawable.k14_5;
		case 6:
			return R.drawable.k14_6;
		case 7:
			return R.drawable.k14_7;
		case 8:
			return R.drawable.k14_8;
		case 9:
			return R.drawable.k14_9;
		case 10:
			return R.drawable.k14_10;
		case 11:
			return R.drawable.k14_11;
		case 12:
			return R.drawable.k14_12;
		case 13:
			return R.drawable.k14_13;
		case 14:
			return R.drawable.k14_14;	
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K16.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK16(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k16_1;
		case 2:
			return R.drawable.k16_2;
		case 3:
			return R.drawable.k16_3;
		case 4:
			return R.drawable.k16_4;
		case 5:
			return R.drawable.k16_5;
		case 6:
			return R.drawable.k16_6;
		case 7:
			return R.drawable.k16_7;
		case 8:
			return R.drawable.k16_8;
		case 9:
			return R.drawable.k16_9;
		case 10:
			return R.drawable.k16_10;
		case 11:
			return R.drawable.k16_11;
		case 12:
			return R.drawable.k16_12;
		case 13:
			return R.drawable.k16_13;
		case 14:
			return R.drawable.k16_14;
		case 15:
			return R.drawable.k16_15;
		case 16:
			return R.drawable.k16_16;	
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K20.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK20(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k20_1;
		case 2:
			return R.drawable.k20_2;
		case 3:
			return R.drawable.k20_3;
		case 4:
			return R.drawable.k20_4;
		case 5:
			return R.drawable.k20_5;
		case 6:
			return R.drawable.k20_6;
		case 7:
			return R.drawable.k20_7;
		case 8:
			return R.drawable.k20_8;
		case 9:
			return R.drawable.k20_9;
		case 10:
			return R.drawable.k20_10;
		case 11:
			return R.drawable.k20_11;
		case 12:
			return R.drawable.k20_12;
		case 13:
			return R.drawable.k20_13;
		case 14:
			return R.drawable.k20_14;
		case 15:
			return R.drawable.k20_15;
		case 16:
			return R.drawable.k20_16;
		case 17:
			return R.drawable.k20_17;
		case 18:
			return R.drawable.k20_18;
		case 19:
			return R.drawable.k20_19;
		case 20:
			return R.drawable.k20_20;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K24.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK24(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k24_1;
		case 2:
			return R.drawable.k24_2;
		case 3:
			return R.drawable.k24_3;
		case 4:
			return R.drawable.k24_4;
		case 5:
			return R.drawable.k24_5;
		case 6:
			return R.drawable.k24_6;
		case 7:
			return R.drawable.k24_7;
		case 8:
			return R.drawable.k24_8;
		case 9:
			return R.drawable.k24_9;
		case 10:
			return R.drawable.k24_10;
		case 11:
			return R.drawable.k24_11;
		case 12:
			return R.drawable.k24_12;	
		case 13:
			return R.drawable.k24_13;
		case 14:
			return R.drawable.k24_14;
		case 15:
			return R.drawable.k24_15;
		case 16:
			return R.drawable.k24_16;
		case 17:
			return R.drawable.k24_17;
		case 18:
			return R.drawable.k24_18;
		case 19:
			return R.drawable.k24_19;
		case 20:
			return R.drawable.k24_20;
		case 21:
			return R.drawable.k24_21;
		case 22:
			return R.drawable.k24_22;
		case 23:
			return R.drawable.k24_23;
		case 24:
			return R.drawable.k24_24;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K30.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK30(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k30_1;
		case 2:
			return R.drawable.k30_2;
		case 3:
			return R.drawable.k30_3;
		case 4:
			return R.drawable.k30_4;
		case 5:
			return R.drawable.k30_5;
		case 6:
			return R.drawable.k30_6;
		case 7:
			return R.drawable.k30_7;
		case 8:
			return R.drawable.k30_8;
		case 9:
			return R.drawable.k30_9;
		case 10:
			return R.drawable.k30_10;
		case 11:
			return R.drawable.k30_11;
		case 12:
			return R.drawable.k30_12;
		case 13:
			return R.drawable.k30_13;
		case 14:
			return R.drawable.k30_14;
		case 15:
			return R.drawable.k30_15;
		case 16:
			return R.drawable.k30_16;
		case 17:
			return R.drawable.k30_17;
		case 18:
			return R.drawable.k30_18;
		case 19:
			return R.drawable.k30_19;
		case 20:
			return R.drawable.k30_20;
		case 21:
			return R.drawable.k30_21;
		case 22:
			return R.drawable.k30_22;
		case 23:
			return R.drawable.k30_23;
		case 24:
			return R.drawable.k30_24;
		case 25:
			return R.drawable.k30_25;
		case 26:
			return R.drawable.k30_26;
		case 27:
			return R.drawable.k30_27;
		case 28:
			return R.drawable.k30_28;
		case 29:
			return R.drawable.k30_29;
		case 30:
			return R.drawable.k30_30;
		}
	}
	
	/**
	 * Funkcja zwraca wygenerowany z zasobów aplikacji ID obrazu odpowiadającego wylosowanej wartości dla kości K48.
	 * @param wartosc	Wartość liczbowa
	 * @return ID obrazu
	 */
	private int kosciK48(int wartosc) {
		switch (wartosc) {
		case 1:
		default:
			return R.drawable.k48_1;
		case 2:
			return R.drawable.k48_2;
		case 3:
			return R.drawable.k48_3;
		case 4:
			return R.drawable.k48_4;
		case 5:
			return R.drawable.k48_5;
		case 6:
			return R.drawable.k48_6;
		case 7:
			return R.drawable.k48_7;
		case 8:
			return R.drawable.k48_8;
		case 9:
			return R.drawable.k48_9;
		case 10:
			return R.drawable.k48_10;
		case 11:
			return R.drawable.k48_11;
		case 12:
			return R.drawable.k48_12;
		case 13:
			return R.drawable.k48_13;
		case 14:
			return R.drawable.k48_14;
		case 15:
			return R.drawable.k48_15;	
		case 16:
			return R.drawable.k48_16;
		case 17:
			return R.drawable.k48_17;
		case 18:
			return R.drawable.k48_18;
		case 19:
			return R.drawable.k48_19;
		case 20:
			return R.drawable.k48_20;
		case 21:
			return R.drawable.k48_21;
		case 22:
			return R.drawable.k48_22;
		case 23:
			return R.drawable.k48_23;	
		case 24:
			return R.drawable.k48_24;
		case 25:
			return R.drawable.k48_25;
		case 26:
			return R.drawable.k48_26;
		case 27:
			return R.drawable.k48_27;
		case 28:
			return R.drawable.k48_28;
		case 29:
			return R.drawable.k48_29;
		case 30:
			return R.drawable.k48_30;	
		case 31:
			return R.drawable.k48_31;
		case 32:
			return R.drawable.k48_32;
		case 33:
			return R.drawable.k48_33;
		case 34:
			return R.drawable.k48_34;
		case 35:
			return R.drawable.k48_35;
		case 36:
			return R.drawable.k48_36;
		case 37:
			return R.drawable.k48_37;	
		case 38:
			return R.drawable.k48_38;
		case 39:
			return R.drawable.k48_39;
		case 40:
			return R.drawable.k48_40;
		case 41:
			return R.drawable.k48_41;
		case 42:
			return R.drawable.k48_42;	
		case 43:
			return R.drawable.k48_43;
		case 44:
			return R.drawable.k48_44;
		case 45:
			return R.drawable.k48_45;
		case 46:
			return R.drawable.k48_46;
		case 47:
			return R.drawable.k48_47;	
		case 48:
			return R.drawable.k48_48;
		}
	}
}
