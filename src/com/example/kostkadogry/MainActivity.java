package com.example.kostkadogry;

import java.util.ArrayList;

import com.example.kostkadogry.Kostka.RodzajKostki;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Klasa implementująca zachowanie głównej aktywności (okna) programu.
 * Zawiera interfejs do dodawania/usuwania kostek oraz wybrane kostki do gry.
 * Obok kostek wyświetlana jest bieżąca wartość oraz zakres losowanych liczb.
 * @author Szymon Sieciński
 */
public class MainActivity extends Activity implements SensorEventListener {

    private Button btnLosuj;
    private int _nrKostkiDoPokazania = 1, _nrKostkiDoUstawienia=0;
    
    private SensorManager mSensorManager;
    /**
     * Uchwyt do akcelerometru
     */
    private Sensor mAccelerometer;
    /**
     * Odczytane wartości przyspieszeń
     */
    private float Gx, Gy, Gz;
    
    /**
     * Próg szumu akcelerometru
     */
    private final float NOISE = 3.0f;
    
    private ArrayList<KontrolerKostki> obiektyKostki = new ArrayList<KontrolerKostki>();
    private ArrayList<TextView> kostkiText = new ArrayList<TextView>();
    private ArrayList<TextView> kostkiObraz = new ArrayList<TextView>();
    private ArrayList<TextView> kostkiZakres = new ArrayList<TextView>();
    
    /**
     * Funkcja odpowiada za obsługę uruchomienia programu.
     * @param	Stan instancji klasy (programu)
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnLosuj = (Button) this.findViewById(R.id.buttonLosuj);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		if (mAccelerometer == null) {
			btnLosuj.setVisibility(View.VISIBLE);
		} else {
			btnLosuj.setVisibility(View.INVISIBLE);
		}
		
		//Kostki (text) do wyswietlenia
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba1));
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba2));
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba3));
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba4));
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba5));
		kostkiText.add((TextView)this.findViewById(R.id.txtLiczba6));
		
		//Kostki (grafika) do wyswietlenia
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana1));
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana2));
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana3));
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana4));
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana5));
		kostkiObraz.add((TextView)this.findViewById(R.id.textSciana6));
		
		//Zakresy liczb do wyświetlenia
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres1));
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres2));
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres3));
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres4));
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres5));
		kostkiZakres.add((TextView)this.findViewById(R.id.textZakres6));
		
		//obiekty klasa kostka
		for(int i = 0; i<kostkiText.size(); i++)
		{
			obiektyKostki.add(new KontrolerKostki());
		}
	}

	/**
	 * Tworzy menu programu i wyświetla je na żądanie użytkownika.
	 * @param menu	Menu programu
	 * @return	Wartość <code>true</code>
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
	//Wybór opcji w menu
	/**
	 * Funkcja obsługuje zdarzenie wybrania pozycji w menu aplikacji.
	 * Wybranie pozycji w menu skutkuje uruchomieniem wskazanego okna (widoku).
	 * @param item	Pozycja w menu
	 * @return	Stwierdzenie wyboru opcji
	 */
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_help:
			Intent intent_help = new Intent(this, Help.class);
			this.startActivity(intent_help);
			return true;
		case R.id.action_about:
			Intent intent_about = new Intent(this, About.class);
			this.startActivity(intent_about);
			return true;
		default:
			return false;
		}
	}
    
    /**
     * Obsługuje zdarzenie ponownego uruchomienia programu.
     */
    //podczas wznawiania
    @Override
    protected void onResume() {
      super.onResume();
      mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
  
    /**
     * Obsługuje zdarzenie przejścia programu do działania w tle.
     */
    //podczas pauzowania
    @Override
    protected void onPause() {
      super.onPause();
      mSensorManager.unregisterListener(this);
    }
    
    /**
     * Obsługuje zdarzenie zatwierdzenia ustawień w oknie Ustawienia. Skutkiem jest ustawienie liczby ścian (rodzaju kostki)
     * wybranej przez użytkownika kostki do gry oraz przekazanie informacji o zakresie losowanych liczb.
     * @param requestCode	Kod żądania
     * @param resultCode	Kod odpowiedzi
     * @param data	Dane z okna Ustawienia
     */
    //ustawiamy kostke
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			String extraDane = data.getStringExtra("LiczbaScian");
			
			Toast.makeText(getApplicationContext(), String.format("Kostka: %d: K%s",_nrKostkiDoUstawienia+1, extraDane),
					Toast.LENGTH_LONG).show();

			int liczbaScian = Integer.parseInt(extraDane);
			obiektyKostki.get(_nrKostkiDoUstawienia).setRodzajKostki(liczbaNaRodzajKostki(liczbaScian));
			
			//ustal zakresy liczb
			String zakres = String.format("%d-%d", obiektyKostki.get(_nrKostkiDoUstawienia).getZakres()[0],
					obiektyKostki.get(_nrKostkiDoUstawienia).getZakres()[1]);
			kostkiZakres.get(_nrKostkiDoUstawienia).setText(zakres);
			
			//int idObrazu = obiektyKostki.get(_nrKostkiDoUstawienia).getIdObrazu();
			//kostkiObraz.get(_nrKostkiDoUstawienia).setImageResource(idObrazu);
		}
	}
    
	/**
	 * Zamienia liczbę ścian na rodzaj kostki.
	 * @param liczba	Liczba ścian
	 * @return	Obiekt klasy/typu wyliczeniowego Kostka.RodzajKostki
	 */
    private Kostka.RodzajKostki liczbaNaRodzajKostki(int liczba)
    {
		switch (liczba) {
		case 3:
			return Kostka.RodzajKostki.K3;
		case 4:
			return Kostka.RodzajKostki.K4;
		case 5:
			return Kostka.RodzajKostki.K5;
		case 6:
		default:
			return Kostka.RodzajKostki.K6;
		case 7:
			return Kostka.RodzajKostki.K7;
		case 8:
			return Kostka.RodzajKostki.K8;
		case 10:
			return Kostka.RodzajKostki.K10;
		case 12:
			return Kostka.RodzajKostki.K12;
		case 14:
			return Kostka.RodzajKostki.K14;
		case 16:
			return Kostka.RodzajKostki.K16;
		case 20:
			return Kostka.RodzajKostki.K20;
		case 24:
			return Kostka.RodzajKostki.K24;
		case 30:
			return Kostka.RodzajKostki.K30;
		case 48:
			return Kostka.RodzajKostki.K48;
		}
    }

    /**
     * Obsługuje zdarzenie naciśnięcia na przycisk „Losuj”.
     * @param view	Bieżący widok (okno) programu
     */
    //klikniecie przycisku losuj
	public void onButtonClick(View view) {
		losujLiczbe();
	}
    
	/**
	 * Losuje liczby na kostkach i pokazuje wyniki w postaci obrazów ścian z wartościami wylosowanych liczb.
	 */
	public void losujLiczbe() {
		for (int i = 0; i < kostkiText.size(); i++) {
			obiektyKostki.get(i).losujLiczbe();
			int idObrazu = obiektyKostki.get(i).getIdObrazu();
			kostkiObraz.get(i).setBackgroundResource(idObrazu);

			if (obiektyKostki.get(i).getRodzajKostki().getValue() != 4
					&& obiektyKostki.get(i).getRodzajKostki().getValue() != 6) {
				
				/* Przypisujemy liczby kostkom*/
				kostkiObraz.get(i).setText(
						String.format("%d", obiektyKostki.get(i).getLiczba()));
				
				/* przypadek kostki 7-ściennej */
				if(obiektyKostki.get(i).getRodzajKostki().getValue() == 7 && obiektyKostki
						.get(i).getLiczba() < 6)
					kostkiObraz.get(i).setText("");
					
			} else {
				kostkiObraz.get(i).setText("");
			}

			kostkiText.get(i).setText(
					String.format("%d", obiektyKostki.get(i).getLiczba()));
		}
	}

	/**
	 * Obsługuje zdarzenie zmiany dokładności czujnika.
	 * @param sensor	Rodzaj czujnika
	 * @param accuracy	Dokładność
	 */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
    }

    /**
     * Obsługuje zdarzenie zmiany stanu akcelerometru.
     * Losowanie liczby zostanie wywołane, jeżeli bieżące wartości przyspieszeń w osiach
     * X, Y, Z będą większe niż wartość zmiennej NOISE.
     * @param event	Zdarzenie związane z czujnikiem
     */
	@Override
	public void onSensorChanged(SensorEvent event) {

		float pGx = 0, pGy = 0, pGz = 0;

		if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
			return;

		Gx = event.values[0];
		Gy = event.values[1];
		Gz = event.values[2];

		if (Math.abs(Gx - pGx) > NOISE && Math.abs(Gy - pGy) > NOISE
				&& Math.abs(Gz - pGz) > NOISE) {
			
			losujLiczbe();

			pGx = Gx;
			pGy = Gy;
			pGz = Gz;
		}
	}
	
	/**
	 * Obsługuje procedurę dodawania kostek.
	 * Dodanie kostki skutkuje odsłonięciem wartości liczbowej, zakresu liczb i ilustracji przedstawiającej
	 * wartość na kostce oraz wyświetleniem komunikatu dla użytkownika.
	 * @param view	Bieżący widok (okno) programu.
	 */
	//dodaj kostke
	public void onAddDie(View view)
	{
		if(_nrKostkiDoPokazania < kostkiText.size())
		{
			kostkiText.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			kostkiObraz.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			kostkiZakres.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			
			obiektyKostki.get(_nrKostkiDoPokazania).losujLiczbe();
			int wartosc = obiektyKostki.get(_nrKostkiDoPokazania).getLiczba();
			kostkiText.get(_nrKostkiDoPokazania).setText(String.format("%d", wartosc));
			
			_nrKostkiDoPokazania++;
			
			Toast.makeText(getApplicationContext(), "Dodano kostkę",
					Toast.LENGTH_LONG).show();
		}
		else _nrKostkiDoPokazania = 1;
	}
	
	/**
	 * Obsługuje procedurę usuwania kostek.
	 * Dodanie kostki skutkuje zasłonięciem wartości liczbowej, zakresu liczb i ilustracji przedstawiającej
	 * wartość na kostce oraz wyświetleniem komunikatu dla użytkownika.
	 * @param view	Bieżący widok (okno) programu.
	 */
	// usun kostke
	public void onRemoveDie(View view) {

		if(_nrKostkiDoPokazania >= kostkiText.size()) _nrKostkiDoPokazania--;
		if (_nrKostkiDoPokazania > 0)
		{
			kostkiText.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			kostkiObraz.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			kostkiZakres.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			
			//resetujemy ustawienia
			obiektyKostki.get(_nrKostkiDoPokazania).setRodzajKostki(RodzajKostki.K6);
			obiektyKostki.get(_nrKostkiDoPokazania).losujLiczbe();
			
			_nrKostkiDoPokazania--;
			
			if(_nrKostkiDoPokazania >= 1)
			Toast.makeText(getApplicationContext(), "Usunięto kostkę",
					Toast.LENGTH_LONG).show();
			
		} else _nrKostkiDoPokazania = 1;
	}
	
	/**
	 * Obsługuje zdarzenie naciśnięcia na kostkę.
	 * Skutkiem jest wywołanie okna (widoku) Ustawienia, w którym użykownik może zmienić rodzaj kostki.
	 * @param view	Bieżący widok (okno) programu.
	 */
	//Ustawienie kostki
	public void DieChange(View view)
	{
		switch (view.getId()) {
		case R.id.textSciana1:
			_nrKostkiDoUstawienia = 0;
			break;
		case R.id.textSciana2:
			_nrKostkiDoUstawienia = 1;
			break;
		case R.id.textSciana3:
			_nrKostkiDoUstawienia = 2;
			break;
		case R.id.textSciana4:
			_nrKostkiDoUstawienia = 3;
			break;
		case R.id.textSciana5:
			_nrKostkiDoUstawienia = 4;
			break;
		case R.id.textSciana6:
			_nrKostkiDoUstawienia = 5;
			break;
		}
		
		Intent intent = new Intent(this, Ustawienia.class);
		startActivityForResult(intent, 1);
	}
}
