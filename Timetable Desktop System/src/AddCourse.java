/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.SystemColor;





public class AddCourse extends JPanel implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCourse;
	private JTextField txtYear;
	JButton btnCancel;


	/**
	 * Create the frame.
	 */
	JButton btnCreateTable;

	String dept;
	String course;
	String year;
	String result = null;
	String courseNameCheck[];

	JComboBox comboBox;
	InputStream is = null;
	StringBuilder sb=null;

	int rowAmount = 0;

	boolean nameUsed = false;

	public AddCourse() {

		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{158, 0, 95, 142, 0};
		gbl_contentPane.rowHeights = new int[]{179, 20, 20, 20, 20, 0, 175, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
				JLabel lblDept = new JLabel("Dept:");
				GridBagConstraints gbc_lblDept = new GridBagConstraints();
				gbc_lblDept.fill = GridBagConstraints.VERTICAL;
				gbc_lblDept.anchor = GridBagConstraints.WEST;
				gbc_lblDept.insets = new Insets(0, 0, 5, 5);
				gbc_lblDept.gridx = 1;
				gbc_lblDept.gridy = 1;
				contentPane.add(lblDept, gbc_lblDept);
		
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Culinary Arts", "Computing", "Creative Digital Media", "Engineering", "Hospitality & Tourism", "Humanities", "Management", "Marketing & Advertising", "Science"}));
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.BOTH;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 1;
				contentPane.add(comboBox, gbc_comboBox);
		
				JLabel lblCourse = new JLabel("Course:");
				GridBagConstraints gbc_lblCourse = new GridBagConstraints();
				gbc_lblCourse.anchor = GridBagConstraints.WEST;
				gbc_lblCourse.insets = new Insets(0, 0, 5, 5);
				gbc_lblCourse.gridx = 1;
				gbc_lblCourse.gridy = 2;
				contentPane.add(lblCourse, gbc_lblCourse);
				
						txtCourse = new JTextField();
						GridBagConstraints gbc_textField = new GridBagConstraints();
						gbc_textField.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField.insets = new Insets(0, 0, 5, 5);
						gbc_textField.gridx = 2;
						gbc_textField.gridy = 2;
						contentPane.add(txtCourse, gbc_textField);
						txtCourse.setColumns(10);
		
				JLabel lblYearsAvailable = new JLabel("Year Length:");
				GridBagConstraints gbc_lblYearsAvailable = new GridBagConstraints();
				gbc_lblYearsAvailable.anchor = GridBagConstraints.WEST;
				gbc_lblYearsAvailable.insets = new Insets(0, 0, 5, 5);
				gbc_lblYearsAvailable.gridx = 1;
				gbc_lblYearsAvailable.gridy = 3;
				contentPane.add(lblYearsAvailable, gbc_lblYearsAvailable);
				
						txtYear = new JTextField();
						GridBagConstraints gbc_textField_1 = new GridBagConstraints();
						gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
						gbc_textField_1.insets = new Insets(0, 0, 5, 5);
						gbc_textField_1.gridx = 2;
						gbc_textField_1.gridy = 3;
						contentPane.add(txtYear, gbc_textField_1);
						txtYear.setColumns(12);
		add(contentPane);
				
						btnCreateTable = new JButton("Create Table");
						GridBagConstraints gbc_btnCreateTable = new GridBagConstraints();
						gbc_btnCreateTable.anchor = GridBagConstraints.WEST;
						gbc_btnCreateTable.insets = new Insets(0, 0, 5, 5);
						gbc_btnCreateTable.gridx = 1;
						gbc_btnCreateTable.gridy = 5;
						contentPane.add(btnCreateTable, gbc_btnCreateTable);
						btnCreateTable.addActionListener(this);
				
						btnCancel = new JButton("Cancel");
						GridBagConstraints gbc_btnCancel = new GridBagConstraints();
						gbc_btnCancel.anchor = GridBagConstraints.EAST;
						gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
						gbc_btnCancel.gridx = 2;
						gbc_btnCancel.gridy = 5;
						contentPane.add(btnCancel, gbc_btnCancel);
				btnCancel.addActionListener(this);




	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		Object src = evt.getSource();
		if(src == btnCreateTable)
		{
			if(comboBox.getSelectedIndex() == 0 || txtCourse.getText().equals("")|| txtYear.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please fill in the above fields correctly.");

			}
			else
			{
				//START
				try{
					DefaultHttpClient httpclient = new DefaultHttpClient();
					HttpGet httppost = new HttpGet("http://garageserver.herobo.com/selectTables.php");
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					is = entity.getContent();

				}catch(Exception e){

				}
				try{

					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					sb = new StringBuilder();
					sb.append(reader.readLine() + "\n");
					String line="0";

					while ((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}

					is.close();
					result=sb.toString();

				}catch(Exception e){
				}
				//paring data

				try{
					JSONArray jArray = new JSONArray(result);
					JSONObject json_data=null;


					for(int i=0;i<jArray.length();i++){
						rowAmount++;
						
					}

					courseNameCheck = new String[rowAmount];
					rowAmount = 0;
					String name;
					for(int i=0;i<jArray.length();i++){
						
						json_data = jArray.getJSONObject(i);
						name = json_data.getString("courseName");

						courseNameCheck[i] = name;

					}

				}catch(JSONException e1){

				}catch (ParseException e1){
					e1.printStackTrace();
				}
				for(int y = 0;y < courseNameCheck.length;y++)
				{
					if(courseNameCheck[y].equals(txtCourse.getText()))
					{  
						JOptionPane.showMessageDialog(this, "There is already a course with that name.");
						y = courseNameCheck.length;
						nameUsed = true;

					}
				}
				//END
				if(nameUsed == false)
				{
					dept = (String) comboBox.getSelectedItem();
					course = txtCourse.getText();
					year = txtYear.getText();




					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("dept", dept));
					nameValuePairs.add(new BasicNameValuePair("course", course));
					nameValuePairs.add(new BasicNameValuePair("year", year));

					try {
						DefaultHttpClient httpclient1 = new DefaultHttpClient();
						HttpPost httppost = new HttpPost("http://garageserver.herobo.com/insertTABLE.php");

						httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

						HttpResponse response = httpclient1.execute(httppost);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					

				}
				nameUsed = false;
				txtCourse.setText("");
				txtYear.setText("");
				comboBox.setSelectedIndex(0);
			}
		}
		
	}
}
