package com.example.tempusmobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class DataHolder 
{
	
	 String result = "";
     InputStream is = null;
     StringBuilder sb=null;
	
	static String deptChosen = "";
	static String[] users;
	static String[] passwords;
	static String[] courses;
	static String[] modulesRetrieved;
	static String[] timesRetrieved;
	static String[] rooms;

	static String[] times = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"};
	static String dayChosen = "";

	static String courseChosen = "";
	static String courseIDChosen = "";

	static int courseAmount = 0;
	static int timeAmount = 0;
	public void clearLogin()
	{
		
		users = null;
		passwords = null;
		  result = "";
	      is = null;
	      sb=null;
		
	}
	public boolean checkLogin(String username, String password)
	{
		
		 if (android.os.Build.VERSION.SDK_INT > 9) {
	        	StrictMode.ThreadPolicy policy = 
	        	new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        	StrictMode.setThreadPolicy(policy);
	        }
	        
		 try {

			

				DefaultHttpClient httpclient = new DefaultHttpClient();

				HttpPost httppost = new HttpPost(
						"http://garageserver.herobo.com/selectUsers.php");

				HttpResponse response = httpclient.execute(httppost);

				HttpEntity entity = response.getEntity();

				is = entity.getContent();
			} catch (Exception e) {
			}
			try {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				sb = new StringBuilder();
				sb.append(reader.readLine() + "\n");
				String line = "0";

				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				is.close();
				result = sb.toString();

			} catch (Exception e) {
			}
			// paring data
			

			try {

				JSONArray jArray = new JSONArray(result);
				JSONObject json_data = null;

				int rowAmount = 0;
				for (int i = 0; i < jArray.length(); i++) {
					
					
					rowAmount++;
				}
				users = new String[rowAmount];
				passwords = new String[rowAmount];


				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

					users[i] = json_data.getString("username");

					passwords[i] = json_data.getString("password");

					if(users[i].equals(username) && passwords[i].equals(password))
					{

						return true;
					}
				
				}


			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			return false;
		
	}
	public void backDeptClear()
	{
		courseAmount = 0;
		courseChosen = "";
		courseIDChosen = "";
		courses = null;
		  result = "";
	      is = null;
	      sb=null;
	}
	public void backCourseClear()
	{
		deptChosen = "";
		modulesRetrieved = null;
		  result = "";
	      is = null;
	      sb=null;
	}
	public void backDayClear()
	{
		int y = 9;
		for(int x = 0;x < 10;x++)
		{
			if(y == 9)
			{
				times[x] = "0"+ y +":00";
			}
			else
			{
				times[x] =  y +":00";

			}
		y++;
		}
		timeAmount = 0;
		
		timesRetrieved = null;
		rooms = null;
		dayChosen = "";
		  result = "";
	      is = null;
	      sb=null;
	}
	public void fillCoursesArray() throws ClientProtocolException, IOException
	{

		 if (android.os.Build.VERSION.SDK_INT > 9) {
	        	StrictMode.ThreadPolicy policy = 
	        	new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        	StrictMode.setThreadPolicy(policy);
	        }
	        
		 try {

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("dept", deptChosen));

				DefaultHttpClient httpclient = new DefaultHttpClient();

				HttpPost httppost = new HttpPost(
						"http://garageserver.herobo.com/selectDeptChosen.php");

				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse response = httpclient.execute(httppost);

				HttpEntity entity = response.getEntity();

				is = entity.getContent();

			} catch (Exception e) {
			}
			try {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				sb = new StringBuilder();
				sb.append(reader.readLine() + "\n");
				String line = "0";

				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				is.close();
				result = sb.toString();

			} catch (Exception e) {
			}
			// paring data
			

			try {
				JSONArray jArray = new JSONArray(result);

				JSONObject json_data = null;

				int rowAmount = 0;
				for (int i = 0; i < jArray.length(); i++) {
					
					
					courseAmount++;
				}
				courses = new String[courseAmount];


				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

				courses[i] = json_data.getString("courseName");

				
				}

			

			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		
		
	}

	public void getDay() throws ClientProtocolException, IOException
	{

		 if (android.os.Build.VERSION.SDK_INT > 9) {
	        	StrictMode.ThreadPolicy policy = 
	        	new StrictMode.ThreadPolicy.Builder().permitAll().build();
	        	StrictMode.setThreadPolicy(policy);
	        }
		 //STARTS HERE
		 try {
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("courseName", courseChosen));
				

				DefaultHttpClient httpclient = new DefaultHttpClient();

				HttpPost httppost = new HttpPost(
						"http://garageserver.herobo.com/selectCourseName.php");

				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse response = httpclient.execute(httppost);

				HttpEntity entity = response.getEntity();

				is = entity.getContent();

			} catch (Exception e) {
			}
			try {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				sb = new StringBuilder();
				sb.append(reader.readLine() + "\n");
				String line = "0";

				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				is.close();
				result = sb.toString();

			} catch (Exception e) {
			}
			// paring data
			

			try {
				JSONArray jArray = new JSONArray(result);

				JSONObject json_data = null;

				


				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

					courseIDChosen = Integer.toString(json_data.getInt("courseID"));
					
					
				}

			

			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//STOPS HERE
		 try {

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("courseID", courseIDChosen));
				nameValuePairs.add(new BasicNameValuePair("day", dayChosen));
				DefaultHttpClient httpclient = new DefaultHttpClient();

				HttpPost httppost = new HttpPost(
						"http://garageserver.herobo.com/selectDayChosen.php");

				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse response = httpclient.execute(httppost);

				HttpEntity entity = response.getEntity();

				is = entity.getContent();

			} catch (Exception e) {
			}
			try {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				sb = new StringBuilder();
				sb.append(reader.readLine() + "\n");
				String line = "0";

				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}

				is.close();
				result = sb.toString();

			} catch (Exception e) {
			}
			// paring data
			

			try {
				JSONArray jArray = new JSONArray(result);

				JSONObject json_data = null;

				for (int i = 0; i < jArray.length(); i++) {
					

					timeAmount++;
				}
				timesRetrieved = new String[timeAmount];
				modulesRetrieved = new String[timeAmount];
				rooms = new String[timeAmount];


				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

					timesRetrieved[i] = json_data.getString("time");
					modulesRetrieved[i] = json_data.getString("moduleName");
					rooms[i] = json_data.getString("room");
					timesRetrieved[i] = timesRetrieved[i].substring(0, timesRetrieved[i].length()-3);

					for (int z = 0; z < 10; z++) {
						if(timesRetrieved[i].equals(times[z]))
						{

							times[z] = times[z] + " " + modulesRetrieved[i] + " " + rooms[i];
							 

						}
					}
				}

			

			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		
		
	}
	
}
