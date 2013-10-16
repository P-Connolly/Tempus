//X00081023 PAUL CONNOLLY
//X00082450 KEVIN DEEGAN

package com.example.tempusmobile;



import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class EnterDept extends Activity implements OnItemSelectedListener {
		DataHolder x = new DataHolder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_enterdept);
		
		
		
		Spinner spinner = (Spinner) findViewById(R.id.deptSpinner);
		spinner.setOnItemSelectedListener(this);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.dept_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
	}

		
	public void getCourse(View view) throws ClientProtocolException, IOException
	{
		x.fillCoursesArray();
		Intent enterDisplay = new Intent(getApplicationContext(),EnterCourse.class);
		startActivity(enterDisplay);
		
	}
	public void logout(View view)
	{
		x.clearLogin();
		Intent enterDisplay = new Intent(getApplicationContext(),Login.class);
		startActivity(enterDisplay);
		
	}

	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		
		x.deptChosen = (String) parent.getItemAtPosition(pos);
		
	}

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
	
	
}
