package com.example.kostkadogry;

import java.util.ArrayList;

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

public class MainActivity extends Activity implements SensorEventListener {

    private Button btnLosuj;
    private int _nrKostkiDoPokazania = 1, _nrKostkiDoUstawienia=0;
    
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float Gx, Gy, Gz;
    private final float NOISE = 3.0f;
    
    private ArrayList<KontrolerKostka> obiektyKostki = new ArrayList<KontrolerKostka>();
    private ArrayList<TextView> kostkiText = new ArrayList<TextView>();
    private ArrayList<ImageView> kostkiObraz = new ArrayList<ImageView>();
    private ArrayList<TextView> kostkiZakres = new ArrayList<TextView>();
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnLosuj = (Button) this.findViewById(R.id.buttonLosuj);

		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		if (mAccelerometer.equals(null)) {
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
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka1));
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka2));
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka3));
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka4));
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka5));
		kostkiObraz.add((ImageView)this.findViewById(R.id.imgKostka6));
		
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
			obiektyKostki.add(new KontrolerKostka());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
    /* 
     * Wybór opcji w menu
     * */
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_help:

			//Intent intent = new Intent(this, Ustawienia.class);
			//this.startActivityForResult(intent, 1);
			return true;
		case R.id.action_about:
			return true;
		default:
			return false;
		}
	}
    
    //podczas wznawiania
    @Override
    protected void onResume() {
      super.onResume();
      mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
  
    //podczas pauzowania
    @Override
    protected void onPause() {
      super.onPause();
      mSensorManager.unregisterListener(this);
    }
    
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


    //klikniecie przycisku losuj
	public void onButtonClick(View view) {
		losujLiczbe();
	}
    
	public void losujLiczbe() {
			for (int i = 0; i < kostkiText.size(); i++) {
				obiektyKostki.get(i).losujLiczbe();
				int idObrazu = obiektyKostki.get(i).getIdObrazu();
				kostkiObraz.get(i).setImageResource(idObrazu);
				kostkiText.get(i).setText(
						String.format("%d", obiektyKostki.get(i).getLiczba()));
			}
	}

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
    }

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
	
	//dodaj kostke
	public void onAddDie(View view)
	{
		if(_nrKostkiDoPokazania < kostkiText.size())
		{
			kostkiText.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			kostkiObraz.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			kostkiZakres.get(_nrKostkiDoPokazania).setVisibility(View.VISIBLE);
			
			_nrKostkiDoPokazania++;
			
			Toast.makeText(getApplicationContext(), "Dodano kostkę",
					Toast.LENGTH_LONG).show();
		}
		//else _nrKostkiDoPokazania = 1;
	}
	
	// usun kostke
	public void onRemoveDie(View view) {

		if(_nrKostkiDoPokazania >= kostkiText.size()) _nrKostkiDoPokazania--;
		if (_nrKostkiDoPokazania > 0)
		{
			kostkiText.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			kostkiObraz.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			kostkiZakres.get(_nrKostkiDoPokazania).setVisibility(View.INVISIBLE);
			
			_nrKostkiDoPokazania--;
			
			Toast.makeText(getApplicationContext(), "Usunięto kostkę",
					Toast.LENGTH_LONG).show();
			
		} //else _nrKostkiDoPokazania = 1;
	}
	
	//Ustawienie kostki
	public void DieChange(View view)
	{
		switch (view.getId()) {
		case R.id.imgKostka1:
			_nrKostkiDoUstawienia = 0;
			break;
		case R.id.imgKostka2:
			_nrKostkiDoUstawienia = 1;
			break;
		case R.id.imgKostka3:
			_nrKostkiDoUstawienia = 2;
			break;
		case R.id.imgKostka4:
			_nrKostkiDoUstawienia = 3;
			break;
		case R.id.imgKostka5:
			_nrKostkiDoUstawienia = 4;
			break;
		case R.id.imgKostka6:
			_nrKostkiDoUstawienia = 5;
			break;
		}
		
		Intent intent = new Intent(this, Ustawienia.class);
		startActivityForResult(intent, 1);
	}
}
