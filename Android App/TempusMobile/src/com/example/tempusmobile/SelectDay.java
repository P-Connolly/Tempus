package com.example.tempusmobile;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;


public class SelectDay extends Activity implements OnItemSelectedListener {
	DataHolder x = new DataHolder();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		x.dayChosen = "Monday";

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selectday);

		Spinner spinner = (Spinner) findViewById(R.id.enterDaySpinner);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
		protected Adapter initializedAdapter=null;
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) 
		    {
		        if(initializedAdapter !=parentView.getAdapter() ) {
		            initializedAdapter = parentView.getAdapter();
		           return;
		        }

		        String selected = parentView.getItemAtPosition(position).toString();
				x.dayChosen = selected;
				 Log.e("FUCKING HELL KIKE4", x.dayChosen + " lol123");

		    }
		    
		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {

		    }
		});
		//STOP
		//spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.day_Array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinnerd

spinner.setAdapter(adapter);

		
	}

		
	public void ViewDayButton(View view) throws ClientProtocolException, IOException
	{
		x.getDay();
		Intent enterDisplay = new Intent(getApplicationContext(),DayChosen.class);
		startActivity(enterDisplay);
		
	}
	public void backCourse(View view) 
	{
		x.backCourseClear();
		Intent enterDisplay = new Intent(getApplicationContext(),EnterCourse.class);
		startActivity(enterDisplay);
		
	}
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {

		x.dayChosen = (String) parent.getItemAtPosition(pos);
		


	}
	

    public void onNothingSelected(AdapterView<?> parent) {
		x.dayChosen = (String) parent.getItemAtPosition(0);
		

    }


	
	
	
	
}