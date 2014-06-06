package com.example.kostkadogry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Spinner;

/**
 * Klasa implementująca widok ustawień. Widok wywoływany po naciśnięciu na jedną z widocznych kostek.
 * @author Szymon Sieciński
 */
public class Ustawienia extends Activity {

	Spinner _listaLiczbyScian;
	/**
	 * Zwracany stan aktywności potwierdzający wybór przez użytkownika nowych ustawień.
	 */
	static final int DIE_CHOSEN = 1;
	//int nrKostki = 0;
	
	/**
	 * Metoda obsługuje zdarzenie tworzenia instancji klasy (tworzenia obiektu widoku).
	 * @param savedInstanceState Stan klasy
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ustawienia);

		_listaLiczbyScian = (Spinner) this.findViewById(R.id.spinner1);
		//Intent intent = this.getIntent();
		//nrKostki = intent.getIntExtra("NumerKostki", R.id.txtLiczba1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ustawienia, menu);
		return true;
	}

	/**
	 * Obsługuje zdarzenie naciśnięcia na przycisk Ustaw.
	 * @param view Bieżący widok
	 */
	//ustawienie kostki
	public void onSetClick(View view)
	{
		/* Wracamy do ekranu startowego */
		Intent intent = new Intent(this.getApplicationContext(), MainActivity.class);
		intent.putExtra("LiczbaScian", _listaLiczbyScian.getSelectedItem().toString());
		//intent.putExtra("IdKostki", nrKostki);
		setResult(RESULT_OK, intent);
		finish();
	}
}
