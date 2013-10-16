//X00081023 PAUL CONNOLLY
//X00082450 KEVIN DEEGAN

package com.example.tempusmobile;



import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class Login extends Activity {
		DataHolder x = new DataHolder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
		
		
		
		
		
	}

		
	public void loginButton(View view)
	{
		EditText usernameT;
		EditText passwordT;
		String username;
		String password;
		usernameT   = (EditText)findViewById(R.id.usernameTxt);
	    passwordT   = (EditText)findViewById(R.id.passwordTxt);
	   // username = usernameT.toString();
	    //password = passwordT.toString();
	    
		boolean validLogin = false;
		validLogin = x.checkLogin(usernameT.getText().toString(),passwordT.getText().toString());

		
		if(validLogin)
		{
		Intent enterDisplay = new Intent(getApplicationContext(),EnterDept.class);
		startActivity(enterDisplay);
		}
		else
		{
			Context context = getApplicationContext();
			CharSequence text = "Incorrect Login Details.";
			

			Toast toast = Toast.makeText(context, text, 5);
			toast.show();
		}
		}
		
	}


	

   
	
	

