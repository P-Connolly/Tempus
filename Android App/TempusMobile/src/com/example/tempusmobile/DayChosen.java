package com.example.tempusmobile;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;


public class DayChosen extends ListActivity  {
	DataHolder x = new DataHolder();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_daychosen);

		
		setListAdapter(new ArrayAdapter<String>(DayChosen.this, android.R.layout.simple_list_item_1, x.times));



		
	}

		
	public void backChosen(View view)
	{
		x.backDayClear();
		Intent enterDisplay = new Intent(getApplicationContext(),SelectDay.class);
		startActivity(enterDisplay);
		
	}


	

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


	
	
	
}