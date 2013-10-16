/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.SystemColor;

public class AddTime extends JPanel implements ActionListener {
	JComboBox cbDept;
	JComboBox cbCourse;
	JComboBox cbModule;
	JComboBox cbFloor;
	JComboBox cbRoom;
	JButton btnContinue;
	JButton btnCancel;

	String groundFloor[] = {"002", "003", "004", "004A", "004B", "005","006","007","008","009","010","011","012","013","014","015","016","017","018","019",
			"020","021","022","023","024","025","026","027","027A","028","029","030","031","031A","031C","032","033","034","036","038","040","042","044","046",
			"048","050","052","054"};
			
	String firstFloor[] = {"101","102","103","104","105","106","107","108","109","110","110","111","112","113","114","115","116","117","118",
			"119","120","121","123","124","125","126","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143"
			,"144","145","146","147","148","149","150","151"
	};
	
	String secondFloor[] = {"201","202","203","204","205","206","207","208","209","210","211","212","214","215","216","217","218","219","220","221","223",
			"225","227","229","231","233","235"
	};
			
			
	CrossVariables x = new CrossVariables();
	
	private JPanel contentPane;
	JTextField txtLecturer;
	String result = null;

	InputStream is = null;

	StringBuilder sb = null;

	String[][] courseNameID;
	String[][] moduleNameID;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddTime() {
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{166, 0, 0, 169, 0};
		gbl_contentPane.rowHeights = new int[]{135, 20, 20, 20, 0, 0, 0, 23, 0, 135};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Dept:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		cbDept = new JComboBox();
		cbDept.setModel(new DefaultComboBoxModel(new String[] { "",
				"Culinary Arts", "Computing", "Creative Digital Media",
				"Engineering", "Hospitality & Tourism", "Humanities",
				"Management", "Marketing & Advertising", "Science" }));
		GridBagConstraints gbc_cbDept = new GridBagConstraints();
		gbc_cbDept.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbDept.insets = new Insets(0, 0, 5, 5);
		gbc_cbDept.gridx = 2;
		gbc_cbDept.gridy = 1;
		contentPane.add(cbDept, gbc_cbDept);
		cbDept.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Course:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		cbCourse = new JComboBox();
		GridBagConstraints gbc_cbCourse = new GridBagConstraints();
		gbc_cbCourse.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCourse.insets = new Insets(0, 0, 5, 5);
		gbc_cbCourse.gridx = 2;
		gbc_cbCourse.gridy = 2;
		contentPane.add(cbCourse, gbc_cbCourse);
		cbCourse.addActionListener(this);

		JLabel lblNewLabel_2 = new JLabel("Module:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		cbModule = new JComboBox();
		GridBagConstraints gbc_cbModule = new GridBagConstraints();
		gbc_cbModule.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbModule.insets = new Insets(0, 0, 5, 5);
		gbc_cbModule.gridx = 2;
		gbc_cbModule.gridy = 3;
		contentPane.add(cbModule, gbc_cbModule);

		JLabel lblNewLabel_3 = new JLabel("Floor:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		cbFloor = new JComboBox();
		cbFloor.setModel(new DefaultComboBoxModel(new String[] { "",
				"Ground Floor", "First Floor", "Second Floor" }));
		GridBagConstraints gbc_cbFloor = new GridBagConstraints();
		gbc_cbFloor.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbFloor.insets = new Insets(0, 0, 5, 5);
		gbc_cbFloor.gridx = 2;
		gbc_cbFloor.gridy = 4;
		contentPane.add(cbFloor, gbc_cbFloor);
		cbFloor.addActionListener(this);

		JLabel lblNewLabel_4 = new JLabel("Room:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		cbRoom = new JComboBox();
		GridBagConstraints gbc_cbRoom = new GridBagConstraints();
		gbc_cbRoom.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbRoom.insets = new Insets(0, 0, 5, 5);
		gbc_cbRoom.gridx = 2;
		gbc_cbRoom.gridy = 5;
		contentPane.add(cbRoom, gbc_cbRoom);

		JLabel lblNewLabel_5 = new JLabel("Lecturer:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		txtLecturer = new JTextField();
		GridBagConstraints gbc_txtLecturer = new GridBagConstraints();
		gbc_txtLecturer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLecturer.insets = new Insets(0, 0, 5, 5);
		gbc_txtLecturer.gridx = 2;
		gbc_txtLecturer.gridy = 6;
		contentPane.add(txtLecturer, gbc_txtLecturer);
		txtLecturer.setColumns(10);

		btnContinue = new JButton("Continue");
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.insets = new Insets(0, 0, 5, 5);
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 8;
		contentPane.add(btnContinue, gbc_btnContinue);
		btnContinue.addActionListener(this);

		add(contentPane);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 8;
		contentPane.add(btnCancel, gbc_btnCancel);
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

					courseNameID[0][i] = Integer.toString(json_data
							.getInt("courseID"));
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
		else if(src == cbCourse && cbCourse.getSelectedIndex() != 0)
		{
			try {
				x.courseID = courseNameID[0][cbCourse.getSelectedIndex() - 1];

				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				int courseChosen =  cbCourse.getSelectedIndex();
				int courseID = Integer.parseInt(courseNameID[0][courseChosen - 1]);

				nameValuePairs.add(new BasicNameValuePair("courseID", Integer.toString(courseID)));

				DefaultHttpClient httpclient = new DefaultHttpClient();

				HttpPost httppost = new HttpPost(
						"http://garageserver.herobo.com/selectCourseChosen.php");

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
			cbModule.removeAllItems();

			try {

				JSONArray jArray = new JSONArray(result);

				JSONObject json_data = null;

				int rowAmount = 0;
				for (int i = 0; i < jArray.length(); i++) {

					rowAmount++;
				}
				moduleNameID = new String[2][rowAmount];

				for (int i = 0; i < jArray.length(); i++) {
					json_data = jArray.getJSONObject(i);

					moduleNameID[0][i] = Integer.toString(json_data.getInt("moduleID"));
					moduleNameID[1][i] = json_data.getString("moduleName");
				}

				cbModule.removeAllItems();

				cbModule.addItem("");
				for (int z = 0; z < rowAmount; z++) {

					cbModule.addItem(moduleNameID[1][z]);
				}

			} catch (JSONException e1) {
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		
		else if(src == cbFloor && cbFloor.getSelectedIndex() == 1)
		{
			cbRoom.removeAllItems();
			cbRoom.addItem("");
			for(int x = 0;x < groundFloor.length;x++){
			cbRoom.addItem(groundFloor[x]);	
			}
			}
		else if(src == cbFloor && cbFloor.getSelectedIndex() == 2)
		{
			cbRoom.removeAllItems();
			cbRoom.addItem("");
			for(int x = 0;x < firstFloor.length;x++){
			cbRoom.addItem(firstFloor[x]);	
			}
			}
		else if(src == cbFloor && cbFloor.getSelectedIndex() == 3)
		{
			cbRoom.removeAllItems();
			cbRoom.addItem("");
			for(int x = 0;x < secondFloor.length;x++){
			cbRoom.addItem(secondFloor[x]);	
			}
			}
		
		

		boolean noRows = false;
		
	}

}
