/*Third Year Project Tempus: Iteration 1 
 * X00081023 PAUL CONNOLLY
 * X00082450 KEVIN DEEGAN
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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

public class AssignUserCourse extends JPanel implements ActionListener {
	JButton btnCancel;
	
	

	private JPanel contentPane;
	int courseID;
	String moduleName = null;
	String lecturer = null;
	/**
	 * Launch the application.
	 */


	JComboBox cbDept;
	JComboBox cbCourse;
	JButton btnAssignCourse;
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
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCourse frame = new UserCourse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public AssignUserCourse() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e1) {
		    // handle exception
		} catch (ClassNotFoundException e1) {
		    // handle exception
		} catch (InstantiationException e1) {
		    // handle exception
		} catch (IllegalAccessException e1) {
		    // handle exception
		}
		setBounds(100, 100, 588, 500);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 155, 0, 93, 155, 0 };
		gbl_contentPane.rowHeights = new int[] { 160, 0, 20, 20, 20, 160, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0,
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
		
				
						btnAssignCourse = new JButton("Assign Course");
						GridBagConstraints gbc_btnAssignCourse = new GridBagConstraints();
						gbc_btnAssignCourse.anchor = GridBagConstraints.WEST;
						gbc_btnAssignCourse.insets = new Insets(0, 0, 5, 5);
						gbc_btnAssignCourse.gridx = 1;
						gbc_btnAssignCourse.gridy = 4;
						contentPane.add(btnAssignCourse, gbc_btnAssignCourse);
						btnAssignCourse.addActionListener(this);
				
						btnCancel = new JButton("Cancel");
						GridBagConstraints gbc_btnCancel = new GridBagConstraints();
						gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
						gbc_btnCancel.anchor = GridBagConstraints.EAST;
						gbc_btnCancel.gridx = 2;
						gbc_btnCancel.gridy = 4;
						contentPane.add(btnCancel, gbc_btnCancel);
				btnCancel.addActionListener(this);
				add(contentPane);
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
		

		else if(src == cbDept && cbDept.getSelectedIndex() != 0)
		{
			
		}

		else if (src == btnAssignCourse)
		{
			if(cbDept.getSelectedIndex()==0 || cbCourse.getSelectedIndex() == 0)
			{
				JOptionPane.showMessageDialog(this, "Please choose the appropriate options.");
			}
			else
			{
			CrossVariables x = new CrossVariables();
			
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("courseID", courseNameID[0][cbCourse.getSelectedIndex()-1]));
			nameValuePairs.add(new BasicNameValuePair("username", x.username));

			x.userCourseID = courseNameID[0][cbCourse.getSelectedIndex()-1];
			try {
				DefaultHttpClient httpclient1 = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://garageserver.herobo.com/UpdateID.php");

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
			cbCourse.setSelectedIndex(0);
			cbDept.setSelectedIndex(0);
		}

		
		
	}
}


