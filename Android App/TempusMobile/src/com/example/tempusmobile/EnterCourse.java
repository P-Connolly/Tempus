package com.example.tempusmobile;

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


public class EnterCourse extends Activity implements OnItemSelectedListener {
	DataHolder x = new DataHolder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entercourse);
		Spinner spinner = (Spinner) findViewById(R.id.courseSpinner);

		
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
				x.courseChosen = selected;

		      
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        // your code here
		    }
		});
		//STOP
		x.courseChosen = x.courses[0];

		
		//spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, x.courses);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner

spinner.setAdapter(adapter);

		
	}

		
	public void getTimetable(View view)
	{

		Intent enterDisplay = new Intent(getApplicationContext(),SelectDay.class);
		startActivity(enterDisplay);
		
	}
	public void backDept(View view1)
	{
		x.backDeptClear();
		Intent enterDisplay1 = new Intent(getApplicationContext(),EnterDept.class);
		startActivity(enterDisplay1);
		
	}

	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		
		x.courseChosen = (String) parent.getItemAtPosition(pos);

	}
	  public void onNothingSelected(AdapterView<?> parent) {
			x.courseChosen = (String) parent.getItemAtPosition(0);
	    }

	
}