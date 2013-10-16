/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DeleteTime extends JPanel implements ActionListener {
	JComboBox cbDept;	
	JComboBox cbCourse;
	JButton btnCancel;
	JButton btnContinue;
	String[][] courseNameID;
	String result = null;
	InputStream is = null;
	StringBuilder sb = null;
	CrossVariables x = new CrossVariables();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public DeleteTime() {
		
	
		
		setBounds(100, 100, 588, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 179, 75, 0, 183, 0 };
		gbl_contentPane.rowHeights = new int[] { 182, 0, 0, 20, 20, 198, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
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
		gbc_cbDept.anchor = GridBagConstraints.SOUTH;
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

		btnContinue = new JButton("Continue");
		GridBagConstraints gbc_btnContinue = new GridBagConstraints();
		gbc_btnContinue.insets = new Insets(0, 0, 5, 5);
		gbc_btnContinue.gridx = 1;
		gbc_btnContinue.gridy = 4;
		contentPane.add(btnContinue, gbc_btnContinue);
		btnContinue.addActionListener(this);
		add(contentPane);

		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.EAST;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 2;
		gbc_btnCancel.gridy = 4;
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
			}
		}
		
	
		

		
	}

	
}

