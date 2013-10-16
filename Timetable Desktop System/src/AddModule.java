/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

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

public class AddModule extends JPanel implements ActionListener {
	JButton btnCancel;
	
	

	private JPanel contentPane;
	private JTextField tfModule;
	private JTextField tfTeacher;
	int courseID;
	String moduleName = null;
	String lecturer = null;
	/**
	 * Launch the application.
	 */


	JComboBox cbDept;
	JComboBox cbCourse;
	JButton btnCreateClass;
	String result = null;
	String result1 = null;

	InputStream is = null;
	InputStream is1 = null;

	StringBuilder sb = null;
	StringBuilder sb1 = null;

	String[][] courseNameID;

	/**
	 * Create the frame.
	 */

	public AddModule() {
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 155, 0, 93, 155, 0 };
		gbl_contentPane.rowHeights = new int[] { 160, 0, 20, 20, 20, 20, 20, 160, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
				JLabel lblDept = new JLabel("Dept:");
				GridBagConstraints gbc_lblDept = new GridBagConstraints();
				gbc_lblDept.anchor = GridBagConstraints.SOUTHWEST;
				gbc_lblDept.insets = new Insets(0, 0, 5, 5);
				gbc_lblDept.gridx = 1;
				gbc_lblDept.gridy = 1;
				contentPane.add(lblDept, gbc_lblDept);
		
				cbDept = new JComboBox();
				cbDept.setModel(new DefaultComboBoxModel(new String[] { "",
						"Culinary Arts", "Computing", "Creative Digital Media",
						"Engineering", "Hospitality & Tourism", "Humanities",
						"Management", "Marketing & Advertising", "Science" }));
				GridBagConstraints gbc_cbDept = new GridBagConstraints();
				gbc_cbDept.anchor = GridBagConstraints.SOUTH;
				gbc_cbDept.fill = GridBagConstraints.HORIZONTAL;
				gbc_cbDept.insets = new Insets(0, 0, 5, 5);
				gbc_cbDept.gridx = 2;
				gbc_cbDept.gridy = 1;
				contentPane.add(cbDept, gbc_cbDept);
				cbDept.addActionListener(this);
		
				JLabel lblCourse = new JLabel("Course:");
				GridBagConstraints gbc_lblCourse = new GridBagConstraints();
				gbc_lblCourse.anchor = GridBagConstraints.WEST;
				gbc_lblCourse.insets = new Insets(0, 0, 5, 5);
				gbc_lblCourse.gridx = 1;
				gbc_lblCourse.gridy = 2;
				contentPane.add(lblCourse, gbc_lblCourse);
		
				cbCourse = new JComboBox();
				GridBagConstraints gbc_cbCourse = new GridBagConstraints();
				gbc_cbCourse.anchor = GridBagConstraints.NORTH;
				gbc_cbCourse.fill = GridBagConstraints.HORIZONTAL;
				gbc_cbCourse.insets = new Insets(0, 0, 5, 5);
				gbc_cbCourse.gridx = 2;
				gbc_cbCourse.gridy = 2;
				contentPane.add(cbCourse, gbc_cbCourse);
		
				JLabel lblModule = new JLabel("Module:");
				GridBagConstraints gbc_lblModule = new GridBagConstraints();
				gbc_lblModule.anchor = GridBagConstraints.WEST;
				gbc_lblModule.insets = new Insets(0, 0, 5, 5);
				gbc_lblModule.gridx = 1;
				gbc_lblModule.gridy = 3;
				contentPane.add(lblModule, gbc_lblModule);
				
						tfModule = new JTextField();
						GridBagConstraints gbc_tfModule = new GridBagConstraints();
						gbc_tfModule.anchor = GridBagConstraints.NORTH;
						gbc_tfModule.fill = GridBagConstraints.HORIZONTAL;
						gbc_tfModule.insets = new Insets(0, 0, 5, 5);
						gbc_tfModule.gridx = 2;
						gbc_tfModule.gridy = 3;
						contentPane.add(tfModule, gbc_tfModule);
						tfModule.setColumns(10);
		
				JLabel lblNewLabel = new JLabel("Lecturer(s):");
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
				gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel.gridx = 1;
				gbc_lblNewLabel.gridy = 4;
				contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
				tfTeacher = new JTextField();
				GridBagConstraints gbc_tfTeacher = new GridBagConstraints();
				gbc_tfTeacher.anchor = GridBagConstraints.NORTH;
				gbc_tfTeacher.fill = GridBagConstraints.HORIZONTAL;
				gbc_tfTeacher.insets = new Insets(0, 0, 5, 5);
				gbc_tfTeacher.gridx = 2;
				gbc_tfTeacher.gridy = 4;
				contentPane.add(tfTeacher, gbc_tfTeacher);
				tfTeacher.setColumns(10);
		add(contentPane);
				
						btnCreateClass = new JButton("Create Class");
						GridBagConstraints gbc_btnCreateClass = new GridBagConstraints();
						gbc_btnCreateClass.anchor = GridBagConstraints.WEST;
						gbc_btnCreateClass.insets = new Insets(0, 0, 5, 5);
						gbc_btnCreateClass.gridx = 1;
						gbc_btnCreateClass.gridy = 6;
						contentPane.add(btnCreateClass, gbc_btnCreateClass);
						btnCreateClass.addActionListener(this);
				
						btnCancel = new JButton("Cancel");
						GridBagConstraints gbc_btnCancel = new GridBagConstraints();
						gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
						gbc_btnCancel.anchor = GridBagConstraints.EAST;
						gbc_btnCancel.gridx = 2;
						gbc_btnCancel.gridy = 6;
						contentPane.add(btnCancel, gbc_btnCancel);
				btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		Object src = evt.getSource();
		// RETREIVING COURSE INFO HERE
		if (src == cbDept && cbDept.getSelectedIndex() != 0)

		{
			try {

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				String dept = (String) cbDept.getSelectedItem();
				nameValuePairs.add(new BasicNameValuePair("dept", dept));

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
			cbCourse.removeAllItems();

			try {
				JSONArray jArray = new JSONArray(result);

				JSONObject json_data = null;

				int rowAmount = 0;
				for (int i = 0; i < jArray.length(); i++) {
					
					
					rowAmount++;
				}
				courseNameID = new String[2][rowAmount];


				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

					courseNameID[0][i] = Integer.toString(json_data.getInt("courseID"));
					courseNameID[1][i] = json_data.getString("courseName");

				
				}

				cbCourse.removeAllItems();

				cbCourse.addItem("");
				for (int z = 0; z < rowAmount; z++) {

					cbCourse.addItem(courseNameID[1][z]);
				}

			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} 
		boolean noRows = false;
		// CREATE CLASS BUTTON
		if (src == btnCreateClass) {
			if (cbCourse.getSelectedIndex() == 0
					|| cbDept.getSelectedIndex() == 0
					|| tfModule.getText().equals("") || tfTeacher.getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						"Please fill in the above fields correctly.");

			} else {
				// START
				try {
					DefaultHttpClient httpclient = new DefaultHttpClient();
					HttpGet httppost = new HttpGet(
							"http://garageserver.herobo.com/selectModules.php");
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					is1 = entity.getContent();

				} catch (Exception e) {

				}
				try {

					BufferedReader reader1 = new BufferedReader(
							new InputStreamReader(is1));
					sb1 = new StringBuilder();
					sb1.append(reader1.readLine() + "\n");
					String line = "0";

					while ((line = reader1.readLine()) != null) {
						sb1.append(line + "\n");
					}

					is1.close();
					result1 = sb1.toString();

				} catch (Exception e) {
				}
				// paring data
				String moduleNameCheck[] = null;
				

				boolean nameUsed = false;
				try {
					if (result1 != null) {

						JSONArray jArray1 = new JSONArray(result1);


						JSONObject json_data = null;
						int rowAmount1 = 0;

						for (int i = 0; i < jArray1.length(); i++) {
							rowAmount1++;

						}

						if (rowAmount1 == 0) {

							noRows = true;

						}
						if (noRows == false) {
							moduleNameCheck = new String[rowAmount1];

							for (int i = 0; i < jArray1.length(); i++) {

								json_data = jArray1.getJSONObject(i);
								moduleName = json_data.getString("moduleName");

								moduleNameCheck[i] = moduleName;

							}

						}
					}
				} catch (JSONException e1) {

				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				


				  if (noRows == false && result1 != null) {
				  
				  for (int y = 0; y < moduleNameCheck.length; y++) 
				  { if (moduleNameCheck[y].equals(tfModule.getText()))
				  		{ 
					  JOptionPane.showMessageDialog(this,"There is already a module with that name."); 
				  y = moduleNameCheck.length; 
				  nameUsed = true;

				  } 
				  } 
				  }
				 
				// END
				if (nameUsed == false) {
					
					courseID = Integer.parseInt(courseNameID[0][cbCourse.getSelectedIndex() - 1]);
					moduleName = tfModule.getText();
					lecturer = tfTeacher.getText();

					ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
					nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(courseID)));
					nameValuePairs.add(new BasicNameValuePair("moduleName", moduleName));
					nameValuePairs.add(new BasicNameValuePair("lecturer", lecturer));


					try {
						DefaultHttpClient httpclient1 = new DefaultHttpClient();
						HttpPost httppost = new HttpPost("http://garageserver.herobo.com/insertModules.php");

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
				cbDept.setSelectedIndex(0);
				cbCourse.setSelectedIndex(0);
				tfModule.setText("");
				tfTeacher.setText("");
			}
		}
		/*else if(src == btnCancel)
		{
			this.dispose();
			Menu f = new Menu();
			f.setLocationRelativeTo(null);
            f.setVisible(true);		
	}*/
	}
}
