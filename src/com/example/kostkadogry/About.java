package com.example.kostkadogry;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Klasa implementuje zachowanie okna informacji o programie.
 * @author Szymon Sieciński
 *
 */
public class About extends ActionBarActivity {

	/**
     * Funkcja odpowiada za obsługę uruchomienia programu.
     * @param	Stan instancji klasy (programu)
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/**
	 * Dodaje do menu okna opcje menu.
	 * @param menu	Tworzone menu programu
	 * @return	Stan tworzenia opcji menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
	
	/**
	 * Obsługuje zdarzenie tworzenia menu okna.
	 * W tym przypadku jest wyłączone - ustawione na <code>false</code>.
	 * @param menu	Tworzone menu programu
	 * @return	Potwierdzenie tworzenia menu
	 */
	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
	     return false;
	 }
	

	/**
	 * Funkcja obsługuje zdarzenie wybrania pozycji w menu okna.
	 * Wybranie pozycji w menu skutkuje uruchomieniem wskazanego okna (widoku).
	 * @param item	Pozycja w menu
	 * @return	Stwierdzenie wyboru opcji
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Obsługuje zdarzenie wciśnięcia przycisku OK.
	 * Obsługa tego zdarzenia skutkuje zamknięciem widoku (okna).
	 * @param view	Bieżący widok
	 */
	public void btnOKClicked(View view)
	{
		this.finish();
	}
	
	/**
	 * Obsługuje zdarzenie wciśnięcia przycisku Licencja - wyświetla licencję programu.
	 * @param view	Bieżący widok
	 */
	public void btnLicenseClicked(View view)
	{
		//Otwiera plik licencji
		java.io.InputStream plik_licencji = this.getResources().openRawResource(R.raw.lgpl3);
		byte[] bajty;
		String text_licencji="";
		
		try {
			bajty = new byte[plik_licencji.available()];
			plik_licencji.read(bajty);
			plik_licencji.close();

			text_licencji = new String(bajty, "UTF-8");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //return new String(bytes,"UTF-8");
		
		TextView glownyText = (TextView)this.findViewById(R.id.textView3);
		glownyText.setMovementMethod(new ScrollingMovementMethod());
		glownyText.setText(text_licencji);
	}

	/**
	 * Widok okna pomocy.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_about,
					container, false);
			return rootView;
		}
	}

}
