package com.example.kostkadogry;

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
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private TextView liczba;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private java.util.Random losowaliczba;
    private float Gx, Gy, Gz;
    private boolean mInitialized = false;
    private final float NOISE = 1.96f;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	
	liczba = (EditText) this.findViewById(R.id.editText1);
	losowaliczba = new java.util.Random();
	
	mInitialized = false;
	mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
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
    public boolean onOptionsItemSelected(MenuItem item)
    {
	switch (item.getItemId()) {
	case R.id.action_settings:
	    //uruchamiamy ustawienia
	    Intent intent = new Intent(this, Ustawienia.class);
	    startActivity(intent);
	    
	    return true;
	default:
	    return false;
	}
    }
    
    @Override
    protected void onResume() {
      super.onResume();
      mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
      super.onPause();
      mSensorManager.unregisterListener(this);
    }


    public void onButtonClick(View view)
    {
	losujLiczbe();
    }
    
    public void losujLiczbe()
    {
	int wylosowanaLiczba = 1 + losowaliczba.nextInt(6);
	liczba.setText(String.format("%d", wylosowanaLiczba));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// TODO Auto-generated method stub
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
	// TODO Auto-generated method stub

	float pGx = 0, pGy =0, pGz =0;

	if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
	    return;

	Gx = event.values[0];
	Gy = event.values[1];
	Gz = event.values[2];

	if(Math.abs(Gx - pGx) > NOISE && Math.abs(Gy-pGy) > NOISE && Math.abs(Gz-pGz) > NOISE)
	{
	    losujLiczbe();
	    
		pGx = Gx;
		pGy = Gy;
		pGz = Gz;
	}
    }
}
